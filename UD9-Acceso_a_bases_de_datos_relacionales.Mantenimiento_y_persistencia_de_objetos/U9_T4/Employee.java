package Tarea4;

public class Employee {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extesion;
    private String email;
    private String officeCode;
    private int reportsTo;
    private String jobTitle;

    public Employee(int employeeNumber, String lastName, String firstName, String extesion, String email, String officeCode, int reportsTo, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extesion = extesion;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtesion() {
        return extesion;
    }

    public void setExtesion(String extesion) {
        this.extesion = extesion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public int getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(int reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "employeeNumber = " + employeeNumber +
                ", lastName = " + lastName + '\'' +
                ", firstName = " + firstName + '\'' +
                ", extesion = " + extesion + '\'' +
                ", email = " + email + '\'' +
                ", officeCode = " + officeCode +
                ", reportsTo = " + reportsTo +
                ", jobTitle = " + jobTitle + '\'' +
                "}\n";
    }
}
