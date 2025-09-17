package bo.cirrus.demo.domain.model;

import java.util.List;

public class User {
    private Long id;
    private String username;
    private String email;
    private List<Privilege> privileges;

    public User() {
    }

    public User(Long id, String username, String email, List<Privilege> privileges) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.privileges = privileges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }
}
