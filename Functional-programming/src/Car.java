import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

 interface  s {
    File openas();
        }
class Test extends File implements s {

    public Test(String pathname) {
        super(pathname);
    }

    public static void main(String[] args) {

        List<Object> a = new ArrayList<>();

    }

    @Override
    public File openas() {
        Test a = new Test("L");
        return a;
    }
}