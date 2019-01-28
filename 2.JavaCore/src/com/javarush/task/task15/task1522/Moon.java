package com.javarush.task.task15.task1522;

/*

Double Checked Locking & volatile
+ Ленивая инициализация
+ Высокая производительность
- Поддерживается только с JDK 1.5 [5]

 */
public class Moon implements Planet {
    private static volatile Moon instance;

    public static Moon getInstance() {
        Moon localInstance = instance;
        if (localInstance == null) {
            synchronized (Moon.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Moon();
                }
            }
        }
        return localInstance;
    }

    private Moon() {

    }

}