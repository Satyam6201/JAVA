public class oops {
    static class student {
        String name;
        int age;

        public student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void showDetail() {
            System.out.println("Name = " + this.name);
            System.out.println("Age = " + this.age);
        }
    }

    public static void main(String[] args) {
        // student s1 = new student("Satyam", 21);
        // s1.showDetail();

        // Student s1 = new Student();
        // // set the value 
        // s1.setName("Satyam");
        // s1.setAge(21);
        // s1.setRoll(135);

        // System.out.println(s1.getName()); // get the value 

        Animals a = new Animals();
        a.setWeight(15);

        Dog d = new Dog();
        System.out.println(a.weight);
        d.eat();

    }

    // getter and setter
    static class Student {
        String name;
        int age;
        int roll;

        //getter
        String getName() {
            return this.name;
        }
        int getAge() {
            return age;
        }
        int getRoll() {
            return roll;
        }

        // setter
        void setName(String name) {
            this.name = name;
        }
        void setAge(int age) {
            this.age = age;
        }
        void setRoll(int roll) {
            this.roll = roll;
        }
    }

    // inheritance 
    static class Animals {
        String color;
        int weight;

        public void setWeight(int weight) {
            this.weight = weight;
        }

        void eat() {
            System.out.println("Eat meat and grass");
        }
        void breath() {
            System.out.println("He breath by his nose");
        }
    }

    static class Dog extends Animals {
        void eat() {
            System.out.println("eat meat only");
        }
    }

    static class Cow extends Dog {
        void eat() {
            System.out.println("eat grass only");
        }
    }
    static class Goat extends Animals {
        void eat() {
            System.out.println("eat grass only");
        }
    }
    static class Cat extends Animals {
        void eat() {
            System.out.println("eat grass only");
        }
    }
    static class Hen extends Animals {
        void eat() {
            System.out.println("eat grass only");
        }
    }
}