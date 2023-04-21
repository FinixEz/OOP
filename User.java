public class User {
    public String username;
    public String type;
    public double hours;

    public User(String username, String type, Double hours) {
        this.username = username;
        this.type = type;
        this.hours = hours;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public double getHours() {
        return hours;
    }
}
