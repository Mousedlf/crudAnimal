package dev.esdlyon.crudanimal.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class LoginResponse {
    private String token;
    private long expiresIn;

    public Object setToken(String jwtToken) {
        token = jwtToken;
        return token;
    }

    public void setExpiresIn(Long expirationTime) {
        expiresIn = expirationTime;
    }
}