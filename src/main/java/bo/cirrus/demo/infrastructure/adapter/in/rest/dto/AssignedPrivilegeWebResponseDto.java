package bo.cirrus.demo.infrastructure.adapter.in.rest.dto;

public class AssignedPrivilegeWebResponseDto {
    private String assignedSince;
    private PrivilegeWebResponseDto privilege;

    public AssignedPrivilegeWebResponseDto() {
    }

    public AssignedPrivilegeWebResponseDto(String assignedSince, PrivilegeWebResponseDto privilege) {
        this.assignedSince = assignedSince;
        this.privilege = privilege;
    }

    public String getAssignedSince() {
        return assignedSince;
    }

    public void setAssignedSince(String assignedSince) {
        this.assignedSince = assignedSince;
    }

    public PrivilegeWebResponseDto getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeWebResponseDto privilege) {
        this.privilege = privilege;
    }
}