import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        float[] arrTemperatures = new float[patientsCount];

        for(int i = 0;i < arrTemperatures.length;i++) {
            arrTemperatures[i] = ((float) (32 + Math.random() * 8));
        }
        return arrTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        String allTemperature = "";
        float middleTemperature = 0;
        int countOfHealthy = 0;

        for(int i = 0;i < temperatureData.length;i++)
        {
           if (temperatureData[i] >= 36.2F & temperatureData[i] <= 36.9F)
           countOfHealthy += 1;
           allTemperature += " " + String.valueOf(Math.round(temperatureData[i] * 10.0) / 10.0);
           middleTemperature += temperatureData[i];
        }

        middleTemperature /= temperatureData.length;
        String report =
                    "Температуры пациентов:" + allTemperature +
                            "\nСредняя температура: " + Math.round(middleTemperature * 100.0)/100.0 +
                            "\nКоличество здоровых: " + countOfHealthy;
        return report;
    }
}
