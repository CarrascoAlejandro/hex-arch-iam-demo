package bo.cirrus.demo.domain.model;

public class AssignedPrivilege {
    private Long id;
    private String assignedSince;
    private Privilege privilege;

    public AssignedPrivilege() {
    }

    public AssignedPrivilege(Long id, String assignedSince, Privilege privilege) {
        this.id = id;
        this.assignedSince = assignedSince;
        this.privilege = privilege;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssignedSince() {
        return assignedSince;
    }

    public void setAssignedSince(String assignedSince) {
        this.assignedSince = assignedSince;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}