package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("myfile", null, new File("D:/"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User petr = new User();
            petr.setBirthDate(new Date());
            petr.setCountry(User.Country.RUSSIA);
            petr.setFirstName("Petr");
            petr.setLastName("Petrov");
            petr.setMale(true);
            javaRush.users.add(petr);

            User ivan = new User();
            ivan.setBirthDate(new Date());
            ivan.setCountry(User.Country.RUSSIA);
            ivan.setFirstName("Ivan");
            ivan.setLastName("Ivanov");
            ivan.setMale(true);
            javaRush.users.add(ivan);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if (users != null) {
                for (User user : users) {
                    String firstName = user.getFirstName();
                    printWriter.print(firstName + ";");
                    String lastName = user.getLastName();
                    printWriter.print(lastName + ";");
                    Date birthDate = user.getBirthDate();
                    printWriter.print(birthDate.getTime() + ";");
                    boolean isMale = user.isMale();
                    printWriter.print(isMale + ";");
                    User.Country country = user.getCountry();
                    printWriter.print(country.getDisplayedName() + ";");
                    printWriter.println();
                    printWriter.flush();
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                User user = new User();
                String[] userLine = line.split(";");
                user.setFirstName(userLine[0]);
                user.setLastName(userLine[1]);
                user.setBirthDate(new Date(Long.parseLong(userLine[2])));
                user.setMale(Boolean.parseBoolean(userLine[3]));
                String country = userLine[4];
                if (country.equals("Russia"))
                    user.setCountry(User.Country.RUSSIA);
                else if (country.equals("Ukraine"))
                    user.setCountry(User.Country.UKRAINE);
                else
                    user.setCountry(User.Country.OTHER);
                this.users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;
        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}