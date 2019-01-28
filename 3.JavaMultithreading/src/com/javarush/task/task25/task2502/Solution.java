package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            wheels = new ArrayList<>();
            String[] wheelsFromDB = loadWheelNamesFromDB();
            if (wheelsFromDB.length != 4) {
                    throw new Exception();
            }
            else {
                for (String aWheelsFromDB : wheelsFromDB) {
                    wheels.add(Wheel.valueOf(aWheelsFromDB));
                }

            }

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
