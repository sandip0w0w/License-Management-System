import java.util.ArrayList;
import java.util.Scanner;

public class Login {


    Login() throws InterruptedException {
        ArrayList<UserRegistration> userList = Details.getUserList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== LICENSE MANAGEMENT APP ===");
            System.out.println("1. NEW USER");
            System.out.println("2. REGISTERED USER");
            System.out.println("3. EXIT");

            int userInput = Integer.parseInt(scanner.nextLine());
            if (userInput == 1) {
                System.out.println("=== User Registration ===");
                new Details();


            } else if (userInput == 2) {

                if (userList.isEmpty()) {
                    System.out.println("No registered users found. Please register first.");
                    continue;
                }
                System.out.print("User Name:");
                String userName = scanner.nextLine();

                System.out.print("Password:");
                String password = scanner.nextLine();
                boolean loginSuccess = false; //

                for (UserRegistration user : userList) {
                    if (user.getName().equals(userName) && user.getPhoneNumber().equals(password) && user.getAdminOrUser().equals("ADMIN")) {
                        new AdminPanel(user.getName());
                        loginSuccess = true;
                        break;
                    }else if (user.getName().equals(userName) && user.getPhoneNumber().equals(password) && user.getAdminOrUser().equals("USER")){
                        new UserPanel(user.getName());
                        loginSuccess = true;
                        break;
                    }
                }

                if (!loginSuccess) {
                    System.out.println("ERROR: Invalid username or password.");


                }
            } else if (userInput == 3) {
                    System.out.print("Exiting the application.");
                    Thread.sleep(2000);
                    System.out.print("..");
                    System.exit(0);

                }
            else {
                    System.out.println("Not a valid argument");
                }


        }
    }
}
