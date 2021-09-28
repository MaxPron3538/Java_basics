public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        char[][] arr = new char[size][size];

        for(int i = 0;i < size;i++) {
            for (int j = 0; j < size; j++)
            {
                if(j == i | j == size-1-i) arr[i][j] = 'X';
                else arr[i][j] = ' ';
            }
        }
        return arr;
    }
}
