package Testing;

public class Main {
    public static void main(String[] args) {
        Animal an = new Animal("Bobby");
        System.out.println(an);

    }
}
     class Animal {
        private String name = "";

        public Animal(String name) {
            this.name = name;
        }
        public Animal() {
            this.name = "Temp";
        }
        @Override
        public String toString() {
            return "Animal{" +
                    "name='" + name + '\'' +
                    '}';
        }

         public String getName() {
             return name;
         }

         public void setName(String name) {
             this.name = name;
         }
     }
