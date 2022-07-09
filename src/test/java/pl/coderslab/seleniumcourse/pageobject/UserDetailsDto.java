package pl.coderslab.seleniumcourse.pageobject;

public class UserDetailsDto {
    private String firstName;
    private String lastName;
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public UserDetailsDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDetailsDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDetailsDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
