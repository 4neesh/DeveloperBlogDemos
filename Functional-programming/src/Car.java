public class Car {

    public void getProperties(){

        Engine engine = new Engine(){

            @Override
            public int getSize() {
                return 10;
            }
        };

        System.out.println("Engine size: " + engine.getSize());
    }

    public void getACoffee(){

        CoffeeMachine cafe = new CoffeeMachine() {
            int numberOfCoffees = 1;
            @Override
            public void makeCoffee() {
                 this.numberOfCoffees = randomNumberCoffees();
                System.out.println("making " + numberOfCoffees + " coffee(s)");
            }

            int randomNumberCoffees(){
                return (int)(numberOfCoffees * Math.random()*100);
            }
        };

        CoffeeMachine cafe2 = () -> {
            System.out.println("LO");
        };

        Coffee a = () -> {return "LO";};
        Coffee b = () -> "LO";

        cafe.makeCoffee();
    }

    public static void main(String[] args) {
        Car a = new Car();
        a.getACoffee();
    }

}
