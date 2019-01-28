package com.javarush.task.task15.task1522;

/*

1 Synchronized Accessor
+ Ленивая инициализация
- Низкая производительность (критическая секция) в наиболее типичном доступе

 */

public class Sun implements Planet {
    private static Sun instance;

    public static synchronized Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }

    private Sun() {

    }

}