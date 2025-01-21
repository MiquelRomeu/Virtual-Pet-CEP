package petPackage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuOption;
        String petName, petType;
        boolean exit = false, dead = false;

        System.out.println("Welcome to a virtual pet.");
        System.out.println("This is a test to know if you are fit to adopt a pet.");
        System.out.println("------------------------");

        petType = choosePetType();
        petName = choosePetName();

        Pet myPet = new Pet(petType, petName);

        showStats(myPet);

        do {
            menuOption = menu(myPet);

            if (menuOption == 1) {
                myPet.sleep();
            } else if (menuOption == 2) {
                myPet.play();
            } else if (menuOption == 3) {
                myPet.eat();
            } else if (menuOption == 4) {
                myPet.clean();
            } else if (menuOption == 0) {
                exit = true;
            }

            dead = myPet.checkAttributes();
            if (dead) {
                System.out.println("---------YOUR PET DIED!---------");
                exit = true;
            }
            showStats(myPet);
        } while (!exit);
    }

    private static String choosePetName() {
        Scanner sc = new Scanner(System.in);
        String petName;

        System.out.println("------------------------");
        System.out.print("Now enter your pet's name: ");
        petName = sc.nextLine();

        return petName;
    }

    private static String choosePetType() {
        Scanner sc = new Scanner(System.in);
        int petType = 0;
        String petTypeString = "";
        boolean invalidInput = false;

        do {
            System.out.println("You can choose form 2 pets:");
            System.out.printf("%-4s %-10s \n", "1 -", "Cat");
            System.out.printf("%-4s %-10s \n", "2 -", "Dog");
            System.out.print("Choose your pet type(1/2): ");

            try {
                petType = sc.nextInt();
                sc.nextLine();
                invalidInput = false;
            } catch (InputMismatchException e) {
                System.out.println("---------PLEASE ENTER A VALID INPUT!---------");
                sc.nextLine();
                invalidInput = true;
            }

            if (petType != 1 && petType != 2 && !invalidInput) {
                System.out.println("---------PLEASE ENTER A VALID OPTION!---------");
                invalidInput = true;
            }
        } while (invalidInput);

        if (petType == 1) {
            petTypeString = "c";
        } else {
            petTypeString = "d";
        }

        return  petTypeString;
    }

    private static void showStats(Pet pet) {
        System.out.printf("%-10s \n", "Stats");
        System.out.println("--------- ---------");
        System.out.printf("%-10s %8s \n", "Name", pet.getName());
        System.out.printf("%-10s %8s \n", "Type", pet.getType());
        System.out.println("--------- ---------");
        System.out.printf("%-10s %8s \n", "Energy", pet.getEnergy());
        System.out.printf("%-10s %8s \n", "Fatigue", pet.getFatigue());
        System.out.printf("%-10s %8s \n", "Sleep", pet.getSleep());
        System.out.printf("%-10s %8s \n", "Hygiene", pet.getHygiene());
        System.out.printf("%-10s %8s \n", "Weight", pet.getWeight());
        System.out.println("--------- ---------");
    }

    private static int menu(Pet pet) {
        Scanner sc = new Scanner(System.in);
        int menuOption = 0;
        boolean invalidInput = false;

        do {
            System.out.printf("%-4s \n", "Menu");
            System.out.println("---- --------------");
            System.out.printf("%-4s %14s \n", " ", "Action");
            System.out.println("---- --------------");
            System.out.printf("%-4s %14s \n", "1 -", "Sleep");
            System.out.printf("%-4s %14s \n", "2 -", "Play");
            System.out.printf("%-4s %14s \n", "3 -", "Eat");
            if (pet.getType() == 'c') {
                System.out.printf("%-4s %14s \n", "4 -", "Self-cleaning");
            } else if (pet.getType() == 'd') {
                System.out.printf("%-4s %14s \n", "4 -", "Shower");
            }
            System.out.printf("%-4s %14s \n", "0 -", "Exit");
            System.out.println("---- --------------");

            System.out.print("Choose an option: ");
            try {
                menuOption = sc.nextInt();
                sc.nextLine();
                invalidInput = false;
            } catch (InputMismatchException e) {
                System.out.println("---------PLEASE ENTER A VALID INPUT!---------");
                sc.nextLine();
                invalidInput = true;
            }

            if (menuOption != 1 && menuOption != 2 && menuOption != 3 && menuOption != 4 && menuOption != 0 && !invalidInput) {
                System.out.println("---------PLEASE ENTER A VALID OPTION!---------");
                invalidInput = true;
            }
        } while (invalidInput);

        return menuOption;
    }
}