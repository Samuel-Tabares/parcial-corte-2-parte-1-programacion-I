import java.io.Serializable;

public class TeamMember implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String role;

    public TeamMember(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "TeamMember [id=" + id + ", name=" + name + ", role=" + role + "]";
    }
}
