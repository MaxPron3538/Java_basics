import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Movements {

    private final String pathMovementCsv;
    private HashMap<String,List<Double>> infoTransactions = new HashMap<>();

    public Movements(String pathMovementsCsv) {
        this.pathMovementCsv = pathMovementsCsv;
        infoTransactions = new HashMap<>();
        this.parseMovementCsv();
    }

    private void parseMovementCsv(){

        try {
            List<String> infoBankTransfers = Files.readAllLines(Paths.get(pathMovementCsv));
            String mccCode = "MCC";

            for (String strInfo : infoBankTransfers) {
                Pattern pattern = Pattern.compile("\\/|\\\\");
                StringBuilder stringBuilder = new StringBuilder();
                List<String> chunks = Arrays.asList(strInfo.split("\\s{3,}"));

                List<String> selectChunks = chunks.stream()
                        .filter(s -> pattern.matcher(s).find() || s.contains(mccCode)).collect(Collectors.toList());

                for (String chunk : selectChunks) {
                    Matcher matcher = pattern.matcher(chunk);

                    if (matcher.find()) {
                        List<String> receiver = Arrays.asList(chunk.split(pattern.pattern()));
                        stringBuilder.append(receiver.get(receiver.size() - 1));
                        continue;
                    }
                    if (chunk.contains("\"")) {
                        List<String> listFloatValues = Arrays.asList(chunk.split("\"")).stream()
                                .map(s -> s.replace(',', '.')).collect(Collectors.toList());

                        if (chunk.lastIndexOf("\"") != chunk.length() - 1) {
                            putIncomeAndExpense(stringBuilder, listFloatValues.get(1), "0");
                            continue;
                        }
                        putIncomeAndExpense(stringBuilder, "0", listFloatValues.get(1));
                        continue;
                    }
                    List<String> listIntegerValues = Arrays.asList(chunk.split(","))
                       .stream().filter(s -> s.matches("\\d{1,}")).collect(Collectors.toList());
                    putIncomeAndExpense(stringBuilder, listIntegerValues.get(0), listIntegerValues.get(1));
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void putIncomeAndExpense(StringBuilder stringBuilder,String inc,String exp) {
        double income = Double.parseDouble(inc);
        double expense = Double.parseDouble(exp);

        if(infoTransactions.containsKey(stringBuilder.toString())) {
            List<Double> value = infoTransactions.get(stringBuilder.toString());
            infoTransactions.put(stringBuilder.toString(),Arrays.asList(value.get(0)+income,value.get(1)+expense));
        }
        else {
            infoTransactions.put(stringBuilder.toString(),Arrays.asList(income,expense));
        }
    }

    public void outputInfoOfBankTransfers(int count){
        for(Map.Entry<String,List<Double>> entry : infoTransactions.entrySet()){
            System.out.println(entry.getKey() + "    " + entry.getValue().get(count) + "руб.");
        }
    }

    private double getExpInc(int count){
        double num = 0;

        for(Map.Entry<String,List<Double>> entry : infoTransactions.entrySet()){
            num += entry.getValue().get(count);
        }
        return num;
    }

    public double getExpenseSum() {
        return getExpInc(1);
    }

    public double getIncomeSum() {
        return getExpInc(0);
    }
}
