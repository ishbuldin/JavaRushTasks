package com.javarush.task.task15.task1522;

/*

On Demand Holder idiom
+ Ленивая инициализация
+ Высокая производительность
- Невозможно использовать для не статических полей класса

 */

public class Earth  implements Planet {
    /*
    public static class EarthHolder {
        public static final Earth HOLDER_INSTANCE = new Earth();
    }

    public static Earth getInstance() {
        return EarthHolder.HOLDER_INSTANCE;
    }

    private Earth() {

    }
    */

    private static Earth instance;

    public static synchronized Earth getInstance() {
        if (instance == null) {
            instance = new Earth();
        }
        return instance;
    }

    private Earth() {

    }

}