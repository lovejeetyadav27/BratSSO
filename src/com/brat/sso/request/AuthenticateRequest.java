package com.brat.sso.request;

import javax.validation.constraints.NotNull;

public class AuthenticateRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;

    private String redirectUrl;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
