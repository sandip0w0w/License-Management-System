import jdk.jfr.Category;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminPanel {

    private static ArrayList<UserRegistration> userList = Details.getUserList();
    Scanner scanner = new Scanner(System.in);
    String loggedInUserName;

    AdminPanel(String loggedInUserName) throws InterruptedException {
            this.loggedInUserName = loggedInUserName;
            System.out.println("=== Admin Panel ===");
            System.out.println("Welcome " + loggedInUserName);
            System.out.println("1. View Application");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            int userInput = Integer.parseInt(scanner.nextLine());


            if (userInput == 1) {
                boolean hasPendingApplications = false;
                for(UserRegistration applicationUser : userList) {
                    if(applicationUser.isLicenseApplied() && !applicationUser.isLicenseApproved()) {
                        hasPendingApplications = true;
                        System.out.println(applicationUser.toString());
                        System.out.print("Press Y to accept N to reject:");
                        String confirmation = scanner.nextLine().toUpperCase();
                        if (confirmation.equals("Y")) {
                            applicationUser.setLicenseApproved(true);
                            applicationUser.isLicenseApproved();
                            applicationUser.setLicense(applicationUser.getLicenseApplied());


                            System.out.println("License approved for " + applicationUser.getName());


                        } else if (confirmation.equals("N")) {
                            System.out.println("License rejected for " + applicationUser.getName());


                        }
                    }
                }
                if (!hasPendingApplications) {
                    System.out.println("No pending applications found.");
                }
                new AdminPanel(loggedInUserName);


            } else if (userInput == 2){

                boolean hasReports = false;

                for (UserRegistration user : userList) {
                    if (user.isLicenseApplied() || user.isLicenseApproved()) {
                        hasReports = true;
                        System.out.println(user.toDetailString());
                    }
                }

                if (!hasReports) {
                    System.out.println("No reports available.");
                }

                new AdminPanel(loggedInUserName);







            } else {
                new Login();
            }


        }
    }

