package bo.cirrus.demo.domain.model;

import java.time.LocalDateTime;

public class AssignedPrivilege {
    private Long id;
    private LocalDateTime assignedSince;
    private Privilege privilege;

    public AssignedPrivilege() {
    }

    public AssignedPrivilege(Long id, LocalDateTime assignedSince, Privilege privilege) {
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

    public LocalDateTime getAssignedSince() {
        return assignedSince;
    }

    public void setAssignedSince(LocalDateTime assignedSince) {
        this.assignedSince = assignedSince;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }
}