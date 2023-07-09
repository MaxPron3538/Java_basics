import java.io.PrintWriter;

public class Loader {

    public static void main(String[] args) {
        /*
        long start = System.currentTimeMillis();
        int init = 1;
        int step = 500;

        for(int i = 0;i < 2;i++){
            runThread(init,step,i+1);
            init=step;
            step+=step;
        }
        System.out.println((System.currentTimeMillis() - start) + " ms");

         */
    }

    public static void runThread(int init,int step,int count) {
        Runnable thread = () -> {
            try {
                buildAndWriteCarNumber(init,step,"res/numbers" + count + ".txt");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        Thread run = new Thread(thread);
        run.start();

        try {
            run.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
    public static void buildAndWriteCarNumber(int init,int finish,String path) throws Exception {
        int regionCode = 199;
        PrintWriter writer = new PrintWriter(path);
        String region = padNumber(regionCode, 2);
        char[] letters = {'У','К','Е','Н','Х','В','А','Р','О','С','М','Т'};

        for (int number = init; number < finish; number++) {
            StringBuilder builder = new StringBuilder();
            String padNum = padNumber(number, 3);

            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        builder.append(firstLetter);
                        builder.append(padNum);
                        builder.append(secondLetter);
                        builder.append(thirdLetter);
                        builder.append(region);
                        builder.append("\n");
                    }
                }
            }
            writer.write(builder.toString());
        }
    }
    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }
        return numberStr;
    }
}
