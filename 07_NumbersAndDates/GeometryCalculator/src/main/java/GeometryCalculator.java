public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return Math.PI * Math.pow(radius,2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {

        double k = (double) 4/3;

        return Math.abs(k * Math.PI * Math.pow(radius,3));
    }

    public static boolean isTrianglePossible(double a, double b, double c)
    {
        if(a + b > c & b + c > a & a + c > b) return true;

        else return false;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c)
    {
        if(!isTrianglePossible(a,b,c) | a < 0 | b < 0 | c < 0) return -1;

        else return Math.abs(Math.sqrt(((a+b+c)/2)*(((a+b+c)/2) - a)*(((a+b+c)/2) - b)*(((a+b+c)/2) - c)));
    }
}
