package ru.skillbox;

public class Main {

    public static void main(String[] args)
    {
        Dimensions dimensions = new Dimensions(43.6,76.4,106.7);

        Goods InitialGoods = new Goods(dimensions,24,13345656,true,"345321dw3",false);

        Goods ChangedGoods = InitialGoods.changePropertyOfAddress(36647);

        dimensions = new Dimensions(34.5,45.6,67);

        ChangedGoods = ChangedGoods.changePropertyOfDimensions(dimensions);

        ChangedGoods = ChangedGoods.changePropertyOfWeight(36);

        InitialGoods.print(dimensions);
        ChangedGoods.print(dimensions);

    }
}
