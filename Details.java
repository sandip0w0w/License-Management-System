import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

class Details {
    private static ArrayList<UserRegistration> userList = new ArrayList<>();
    Details(){
        System.out.println("=== Enter Details ===");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name:");
        String name = scanner.nextLine();
        System.out.print("Enter your address:");
        String address = scanner.nextLine();
        System.out.print("Enter your phone number:");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter your citizenship number:");
        String citizenshipNumber = scanner.nextLine();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Enter a date in the format yyyy-MM-dd (e.g., 2023-10-05):");
        String inputDate = scanner.nextLine();
        int ageOfUser= 0;
        try {
            LocalDate date = LocalDate.parse(inputDate, formatter);
            System.out.println("You entered the date: " + date);
            LocalDate currentDate = LocalDate.now();


            Period age = Period.between(LocalDate.parse(inputDate), currentDate);
            ageOfUser = age.getYears();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");

        }


        System.out.print("Admin or User: ");
        String adminOrUser = scanner.nextLine().toUpperCase();
        ArrayList<String> license = new ArrayList<>();



        UserRegistration user = new UserRegistration(name, address, phoneNumber, citizenshipNumber, adminOrUser, inputDate, ageOfUser,license);
        userList.add(user);
        System.out.println();
        System.out.println("=== User registered ===\n");




       }
    public static ArrayList<UserRegistration> getUserList() {
        return userList;
    }

    }

