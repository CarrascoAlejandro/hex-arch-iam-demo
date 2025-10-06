package bo.cirrus.demo.infrastructure.adapter.in.rest.dto;

public class CreatePrivilegeRequestDto {
    private String name;
    private String resourceKey;

    public CreatePrivilegeRequestDto() {
    }

    public CreatePrivilegeRequestDto(String name, String resourceKey) {
        this.name = name;
        this.resourceKey = resourceKey;
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
