package bo.cirrus.demo.infrastructure.adapter.in.rest.dto;

public class AssignPrivilegeRequestDto {
    private String username;
    private Long privilegeId;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public Long getPrivilegeId() {
        return privilegeId;
    }
    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }
    
}
