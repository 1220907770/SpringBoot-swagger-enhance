package demo;

public class Car {

    public void getCar(){
        System.out.println("Car.class");
    }

}

class Suv extends Car{

    public void getCar(){
        System.out.println("Suv.class");
    }

    public void getCarName(){
        System.out.println("Suv");
    }
}

class Test{

    public static void main(String[] args) {

        Car car = new Suv();

        car.getCar();

        Suv usv = (Suv)car;
        usv.getCarName();

    }

}
