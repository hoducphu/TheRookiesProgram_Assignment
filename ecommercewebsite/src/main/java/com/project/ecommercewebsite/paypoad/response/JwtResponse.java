package com.project.ecommercewebsite.paypoad.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private int account_id;
    private String username;
    private String email;
    private List<String> role;

    public JwtResponse(String accessToken, int account_id, String username, String email, List<String> role) {
        this.token = accessToken;
        this.account_id = account_id;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRole() {
        return role;
    }
}
