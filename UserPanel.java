import java.util.ArrayList;
import java.util.Scanner;

public class UserPanel {
    private static ArrayList<UserRegistration> userList = Details.getUserList();
    Scanner scanner = new Scanner(System.in);
    String loggedInUserName;

    UserPanel(String loggedInUserName) throws InterruptedException {
        this.loggedInUserName = loggedInUserName;
        while (true) {

            System.out.println("=== User Panel ===");
            System.out.println("Welcome " + loggedInUserName);
            System.out.println("1.Apply for new license.");
            System.out.println("2.Add license");
            System.out.println("3.View Application");
            System.out.println("4.Exit");
            int userInput = Integer.parseInt(scanner.nextLine());
            String licenseCategory = "";
            UserRegistration loggedInUser = null;
            for (UserRegistration user : userList) {
                if (user.getName().equals(loggedInUserName)) {
                    loggedInUser = user;
                    break;
                }
            }


            if (loggedInUser == null) {
                System.out.println("User not found.");
                return;
            }
            if (userInput == 1) {

                System.out.println("A - Bike, Scooter, Moped");
                System.out.println("B - Car, Light weight four wheeler");
                System.out.println("K - Scooter, Moped");
                System.out.print("Enter the category you want to apply:");
                licenseCategory = scanner.nextLine().toUpperCase();
                if (!licenseCategory.equals("A") && !licenseCategory.equals("B") && !licenseCategory.equals("K")) {
                    System.out.println("Invalid license category.");
                    continue;
                }


                boolean eligible = false;
                if (licenseCategory.equals("A") || licenseCategory.equals("K")) {
                    if (loggedInUser.getAgeOfUser() >= 16) {
                        eligible = true;
                    }
                } else if (licenseCategory.equals("B")) {
                    if (loggedInUser.getAgeOfUser() >= 18) {
                        eligible = true;
                    }
                }

                if (eligible) {
                    System.out.println("Your application has been submitted. Wait for the approval.");
                    loggedInUser.setUserApplication(licenseCategory);
                    loggedInUser.setLicenseApplied(true);
                    loggedInUser.setLicenseApproved(false);
                    loggedInUser.isLicenseApplied();
                } else {
                    System.out.println("Age ineligible for license application.");
                }


            } else if (userInput == 2) {
                while (!loggedInUser.getLicense().isEmpty()) {
                    System.out.println("A - Bike, Scooter, Moped");
                    System.out.println("B - Car, Light weight four wheeler");
                    System.out.println("K - Scooter, Moped");
                    System.out.print("Enter the category you want to apply:");
                    licenseCategory = scanner.nextLine();
                    if (!licenseCategory.equals("A") && !licenseCategory.equals("B") && !licenseCategory.equals("K")) {
                        System.out.println("Invalid license category.");
                        continue;
                    }
                    if (!loggedInUser.getLicense().contains(licenseCategory)) {


                        boolean eligible = false;
                        if (licenseCategory.equals("A") || licenseCategory.equals("K")) {
                            if (loggedInUser.getAgeOfUser() >= 16) {
                                eligible = true;
                            }
                        } else if (licenseCategory.equals("B")) {
                            if (loggedInUser.getAgeOfUser() >= 18) {
                                eligible = true;
                            }
                        }

                        if (eligible) {
                            System.out.println("Your application has been submitted. Wait for the approval.");
                            loggedInUser.setUserApplication(licenseCategory);
                            loggedInUser.setLicenseApplied(true);
                            loggedInUser.setLicenseApproved(false);



                        }
                        return;


                    } else {
                        System.out.println("You already have that category of license. Please apply for another category");
                    }
                }
                System.out.println("You don't have a license.");
            } else if (userInput == 3) {
                System.out.println("Name: " + loggedInUser.getName());
                System.out.println("Age: " + loggedInUser.getAgeOfUser());
                System.out.println("DOB: " + loggedInUser.getInputDate());
                System.out.println("CitizenshipNumber: " + loggedInUser.getCitizenshipNumber());
                System.out.println("License: " + loggedInUser.getLicense());

            }
            else{
                new Login();
            }


        }
    }
}
