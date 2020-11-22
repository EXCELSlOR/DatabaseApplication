import java.sql.Date;

public class User {
    private int id;
    private String login;
    private String password;
    private Date birthdate;
    private boolean gender;

    public User(int id, String login, String password, Date birthdate, boolean gender) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
