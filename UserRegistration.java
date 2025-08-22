import java.util.ArrayList;

class UserRegistration {
     private String name;
     private String address;
     private String phoneNumber;
     private String inputDate;
     private String citizenshipNumber;
     private String adminOrUser;
     private int ageOfUser;
     private ArrayList<String> license;
     private boolean licenseApplied;
     private  boolean licenseApproved;
     private String appliedCategory;



     UserRegistration(String name, String address, String phoneNumber, String citizenshipNumber, String adminOrUser,String inputDate, int ageOfUser
     ,ArrayList<String> license) {
         this.name = name;
         this.address = address;
         this.phoneNumber = phoneNumber;
         this.citizenshipNumber = citizenshipNumber;
         this.inputDate = inputDate;
         this.adminOrUser = adminOrUser;
         this.ageOfUser = ageOfUser;
         this.license = license;
         this.licenseApplied = false;
         this.licenseApproved = false;




     }

     public String getName() {
         return name;
     }

     public String getAddress() {
         return address;
     }

     public String getPhoneNumber() {
         return phoneNumber;
     }

     public String getCitizenshipNumber() {
         return citizenshipNumber;
     }

     public String getAdminOrUser() {
         return adminOrUser;
     }
     public String getInputDate(){
         return inputDate;

     }

     public int getAgeOfUser() {
         return ageOfUser;
     }


     public ArrayList<String> getLicense(){
         return  license;
     }

    public boolean isLicenseApplied() {
        return licenseApplied;
    }

    public boolean isLicenseApproved() {
        return licenseApproved;
    }



    public void setLicenseApplied(boolean applied){
         this.licenseApplied = applied;
    }
    public void setLicenseApproved(boolean approved){
         this.licenseApproved = approved;
    }


    public void setUserApplication(String appliedCategory) {
         this.appliedCategory = appliedCategory;



    }
    public void setLicense(String category){
         license.add(appliedCategory);
    }

    public String getLicenseApplied(){
         return appliedCategory;
    }



     @Override
     public String toString(){
         return "Name: '"+name+"', Citizenship: '"+citizenshipNumber+"', Category:'"+ appliedCategory+"'\n ";
     }
     public String toDetailString(){
         return  "Name: '"+name+"', Citizenship: '"+citizenshipNumber+"', hasApplied:'"+ isLicenseApplied()+"', hasApproved:'"+ isLicenseApproved()+"'\n ";
     }
 }

