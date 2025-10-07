package bo.cirrus.demo.domain.model;

import java.util.List;

public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private List<AssignedPrivilege> assignedPrivileges;

    public User() {
    }

    public User(Long id, String username, String email, List<AssignedPrivilege> assignedPrivileges, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.assignedPrivileges = assignedPrivileges;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AssignedPrivilege> getAssignedPrivileges() {
        return assignedPrivileges;
    }

    public void setAssignedPrivileges(List<AssignedPrivilege> assignedPrivileges) {
        this.assignedPrivileges = assignedPrivileges;
    }
}
