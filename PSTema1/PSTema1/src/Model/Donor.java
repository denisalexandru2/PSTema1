package Model;

public class Donor {
    public int id;
    public String username;
    public String password;
    public String bloodType;

    public Donor(int id, String username, String password, String bloodType) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.bloodType = bloodType;
    }

    public Donor(String username, String password, String bloodType) {
        this.username = username;
        this.password = password;
        this.bloodType = bloodType;
    }

    public Donor() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
}
