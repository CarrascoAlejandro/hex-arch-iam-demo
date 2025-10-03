package bo.cirrus.demo.infrastructure.adapter.in.rest.dto;

public class UserWebResponseDto {
    private String username;
    private String email;

    public UserWebResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
