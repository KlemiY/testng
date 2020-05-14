package main.java.Homework_lesson2;

public class Task777 {

        private static int counter = 0;
        private int age;
        private String name;
        public String ageGroup;

  /*  public Task1() {
        this("not defined.");
    }*/

        public Task777(String name, int age) {
            System.out.println("New user!");
            counter++;
            this.setName(name);
            this.setAge(age);
            this.setAgeGroup(age);
        }

        // Геттеры для каждой переменной.
        public int getAge() {
            return this.age;
        }

        public String getName() {
            return this.name;
        }

        public String getAgeGroup() {
            return this.ageGroup;
        }

        // Сеттеры для каждоый переменной
        public void setAge(int age) {
            if (age > 100) {
                System.out.println("Not valid age: " + age);
                this.age = 0;
            } else if (age <= 0) {
                System.out.println("Not valid age: " + age);
                this.age = 0;
            } else {
                this.age = age;
            }
        }

        public void setName(String name) {
            name = name.trim();
            for ( ; ; ) {  //Костыль (просто решил посмотреть, сработает или нет).
                if (name.length() == 0) {
                    System.out.println("Invalid name, you can't use only spaces in your name!");
                    this.name = "Undefined";
                    break;
                } else if (name.length() < 3) {
                    System.out.println("Your name should include at least 4 characters.");
                    this.name = "Undefined";
                    break;
                } else if (name.length() > 50) {
                    System.out.println("Your name should include less than(or) 50 characters.");
                    this.name = "Undefined";
                    break;
                } else {
                    this.name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                    break;
                }
            }
        }

        private void setAgeGroup(int age) {
            if (age == 0) {
                System.out.println("Invalid age!");
                this.ageGroup = "Undefined";
            } else if (age > 0 && age <= 14) {
                this.ageGroup = "Child";
            } else if (age >= 15 && age <= 25) {
                this.ageGroup = "Student";
            } else if (age >= 26 && age <= 65) {
                this.ageGroup = "Worker";
            } else {
                this.ageGroup = "Pensioner";
            }
        }
}
