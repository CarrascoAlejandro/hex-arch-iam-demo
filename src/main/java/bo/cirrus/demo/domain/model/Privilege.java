package bo.cirrus.demo.domain.model;

public class Privilege {
    private Long id;
    private String name;
    private String resourceKey;

    public Privilege() {
    }

    public Privilege(Long id, String name, String resourceKey) {
        this.id = id;
        this.name = name;
        this.resourceKey = resourceKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }
    
}
