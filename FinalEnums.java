import java.util.Scanner;

class Car {
    private String brand;
    private double speed;
    private CarType carType; //CarType attribute using the enum teehee :D
    final int maxSpeed = 100;

    //Constructors
    public Car () {
        this.brand = brand;
        this.speed = 0;
        this.carType = null;
    }

    //Setters
    public void setBrand(String brand) {this.brand = brand;}
    public void setSpeed(double speed) {this.speed = speed;}
    public void setCarType (CarType carType) {this.carType = carType;}

    //Getters
    public String getBrand () {return brand;}
    public double getSpeed() {return speed;}
    public CarType getCarType () {return carType;}

    //Methods for display !!
    public void displayDetails(){
        System.out.println("\nYippeee you have just picked the " + getBrand() + " which is a " + getCarType() + " !!");
        System.out.println("");
        System.out.println("==================================================");
        System.out.println("Car Brand:" + getBrand());
        System.out.println("Current Speed: " + getSpeed() + " km/h");
        System.out.println("==================================================");
        System.out.println("");
    }

    //Protected speed modification for subclass >.<
    protected void changeSpeed (double amount){
        double newSpeed = speed += amount;
        if (newSpeed > 100){
            speed= maxSpeed;
        } else if (newSpeed < 0){
            speed = 0;
        } else {
            speed = newSpeed;
        }
    }
}

//Sub-Class :>
class SubCar extends Car{
    public void accelerate() {
        switch (getCarType()){
            case SEDAN:
                System.out.println("\n==================================================");
                System.out.println("Operation boost Sedan to Sudan has been activated");
                break;
            case SUV:
                System.out.println("\n==================================================");
                System.out.println("Kid's joy ride activated, now boosting !!");
                break;
            case TRUCK:
                System.out.println("\n==================================================");
                System.out.println("Kennon Road overtaking mode !!");
                break;
        }

        //cahnging speed from prtected method :3
        changeSpeed(50);
        System.out.println(getBrand() + " accelerated...");
        System.out.println("Current Speed: " + getSpeed() + "km/h");
        System.out.println("==================================================");
    }

    public void decelerate() {
        changeSpeed(-25);
        System.out.println(getBrand() + " is slowing down D:");
        System.out.println("Current speed: " + getSpeed() + "km/h");
    }
}

//Enums TT
enum CarType{
    SEDAN,   //BMW
    SUV,    //Ferrari
    TRUCK  //Lamborghini
}

//Main Class =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

public class FinalEnums {
    public static void main (String[] args){
        Scanner s = new Scanner (System.in);
        boolean exit = false;

        //Create objects yes :D
        SubCar carUno = new SubCar();                               //Sedan (BMW)
            carUno.setBrand("BMW");
            carUno.setSpeed(0);
            carUno.setCarType(CarType.SEDAN);

        SubCar carDos = new SubCar();                               //SUV (Ferrari)
            carDos.setBrand("Ferrari");
            carDos.setSpeed(0);
            carDos.setCarType(CarType.SUV);

        SubCar carTres = new SubCar();                              //Truck (Lambo)
            carTres.setBrand("Lamborghini");
            carTres.setSpeed(0);
            carTres.setCarType(CarType.TRUCK);

            while (!exit){
                System.out.println("\n\n===================WELCOME TO THE BREAD CAR DEALERSHEEP===================\n");
                System.out.println("Please Choose what you is liking to do hehe :D");
                System.out.println("1. Choose Car");
                System.out.println("2. Exit");

                int choice1 = 0;

                while (true){
                    System.out.print("So what you pick (1 or 2): ");
                    if (s.hasNextInt()){
                        choice1 = s.nextInt();
                        if (choice1 >= 1 && choice1 <= 2){
                            s.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid Choice... 1 or 2 ONLY !!");
                    }
                } else {
                    System.out.println("That ain't no integer cuh...");
                    s.nextLine();
                }
            }
            
            switch (choice1){
                case 1:
                    System.out.println("\n==================================================");
                    System.out.println("Please choose your car");
                    System.out.println("1. BMW (Sedan)");
                    System.out.println("2. Ferrari (SUV)");
                    System.out.println("3. Lamborghini (Truck)");

                    int choice2 = 0;

                    while (true){
                        System.out.println("==================================================");
                        System.out.print("\nSo... whatcha pick: ");
                        if (s.hasNextInt()){
                            choice2 = s.nextInt();
                            if (choice2 >= 1 && choice2 <= 3){
                                s.nextLine();
                                break;
                            } else{
                                System.out.println("Invalid input... 1 - 3 only plez :D");
                            }
                        } else {
                            System.out.println("That ain't an integer cuh...");
                            s.nextLine();
                        }
                    }
                        switch (choice2){
                            case 1:
                                carUno.displayDetails();
                                int choice3 = 0;
                                boolean back = false;

                                while (!back) {
                                System.out.println("\nShould we speed things up? \n");
                                System.out.println("1. Accelerate");
                                System.out.println("2. Decelerate");
                                System.out.println("3. Go Back ");

                                while (true){
                                    System.out.print("\nPick 1, 2, or 3: ");
                                    if (s.hasNextInt()){
                                        choice3 = s.nextInt();
                                        if (choice3 >= 1 && choice3 <= 3) {
                                            s.nextLine();
                                            break;
                                        } else{
                                            System.out.println("1 or 2 brah...");
                                        }
                                    } else {
                                        System.out.println("That ain't an integer cuh !!");
                                        s.nextLine();
                                    }
                                }
                                    switch (choice3){
                                        case 1:
                                            carUno.accelerate();
                                            break;
                                        case 2:
                                            carUno.decelerate();
                                            break;
                                        case 3:
                                            back = true;
                                            break;
                                    }
                                }
                                    break;
                                
                            case 2:
                                carDos.displayDetails();
                                int choice4 = 0;
                                boolean back1 = false;

                                while (!back1) {
                                System.out.println("\nShould we speed things up? \n");
                                System.out.println("1. Accelerate");
                                System.out.println("2. Decelerate");
                                System.out.println("3. Go Back ");

                                while (true){
                                    System.out.print("\nPick 1, 2, or 3: ");
                                    if (s.hasNextInt()){
                                        choice4 = s.nextInt();
                                        if (choice4 >= 1 && choice4 <= 3) {
                                            s.nextLine();
                                            break;
                                        } else{
                                            System.out.println("1 or 2 brah...");
                                        }
                                    } else {
                                        System.out.println("That ain't an integer cuh !!");
                                        s.nextLine();
                                    }
                                }
                                    switch (choice4){
                                        case 1:
                                            carDos.accelerate();
                                            break;
                                        case 2:
                                            carDos.decelerate();
                                            break;
                                        case 3:
                                            back1 = true;
                                            break;
                                    }
                                }

                                break;
                            case 3:
                                carTres.displayDetails();
                                int choice5 = 0;
                                boolean back2 = false;

                                while (!back2) {
                                System.out.println("\nShould we speed things up? \n");
                                System.out.println("1. Accelerate");
                                System.out.println("2. Decelerate");
                                System.out.println("3. Go Back ");

                                while (true){
                                    System.out.print("\nPick 1, 2, or 3: ");
                                    if (s.hasNextInt()){
                                        choice5 = s.nextInt();
                                        if (choice5 >= 1 && choice5 <= 3) {
                                            s.nextLine();
                                            break;
                                        } else{
                                            System.out.println("1 or 2 brah...");
                                        }
                                    } else {
                                        System.out.println("That ain't an integer cuh !!");
                                        s.nextLine();
                                    }
                                }
                                    switch (choice5){
                                        case 1:
                                            carTres.accelerate();
                                            break;
                                        case 2:
                                            carTres.decelerate();
                                            break;
                                        case 3:
                                            back2 = true;
                                            break;
                                    }
                                }
                                break;
                        }
                    break;

                case 2:
                        System.out.println("\n\nOk then... bye bye D:");
                        System.out.println("\n... P R O G R A M   S U C C E S S F U L L Y   T E R M I N A T E D ...");
                        exit = true;
                        break;
            }

        }
    }
}

//String userInput = scanner.nextLine();

//car = //enum.valueOf(userInput);

//Sop (“Your Car Type: ” + car);