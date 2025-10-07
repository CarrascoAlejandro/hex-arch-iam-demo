package bo.cirrus.demo.infrastructure.adapter.in.rest.dto;

import java.util.List;

public class UserWebResponseDto {
    private String username;
    private String email;
    private List<AssignedPrivilegeWebResponseDto> assignedPrivileges;

    public UserWebResponseDto() {
    }

    public UserWebResponseDto(String username, String email, List<AssignedPrivilegeWebResponseDto> assignedPrivileges) {
        this.username = username;
        this.email = email;
        this.assignedPrivileges = assignedPrivileges;
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

    public List<AssignedPrivilegeWebResponseDto> getAssignedPrivileges() {
        return assignedPrivileges;
    }

    public void setAssignedPrivileges(List<AssignedPrivilegeWebResponseDto> assignedPrivileges) {
        this.assignedPrivileges = assignedPrivileges;
    }
}
