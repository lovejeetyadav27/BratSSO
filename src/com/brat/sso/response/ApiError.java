package com.brat.sso.response;

public class ApiError {
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "error='" + error + '\'' +
                '}';
    }
}
