public class Arithmetic
{
    int firstValue,secondValue;

    Arithmetic(int firstValue,int secondValue){

        this.firstValue = firstValue;
        this.secondValue = secondValue;

    }

    int getArithmeticSum(){ return firstValue + secondValue;}

    int getArithmeticProduct(){return firstValue * secondValue;}

    int getMaxValue(){ int maxElement; return maxElement = (firstValue > secondValue) ? firstValue : secondValue;}

    int getMinValue(){ int minElement; return minElement = (firstValue < secondValue) ? firstValue : secondValue;}

}
