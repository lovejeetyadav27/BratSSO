package com.brat.sso.response;

import org.springframework.http.HttpHeaders;

public class ApiResponse {
    private String accessToken;
    private String createdTime;
    private String tillValidate;


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getTillValidate() {
        return tillValidate;
    }

    public void setTillValidate(String tillValidate) {
        this.tillValidate = tillValidate;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", tillValidate='" + tillValidate + '\'' +
                '}';
    }
}
