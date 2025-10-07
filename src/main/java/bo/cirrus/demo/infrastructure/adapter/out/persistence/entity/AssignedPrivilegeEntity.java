package bo.cirrus.demo.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assigned_privilege")
public class AssignedPrivilegeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "assigned_since", nullable = false)
    private String assignedSince;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(targetEntity = PrivilegeEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "privilege_id", nullable = false)
    private PrivilegeEntity privilege;

    public AssignedPrivilegeEntity() {
        // Required by JPA Entity specification
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PrivilegeEntity getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeEntity privilege) {
        this.privilege = privilege;
    }
    
}
