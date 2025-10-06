package bo.cirrus.demo.infrastructure.adapter.in.rest.dto;

public class PrivilegeWebResponseDto {
    private Long id;
    private String name;
    private String resourceKey;

    public PrivilegeWebResponseDto(Long id, String name, String resourceKey) {
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
