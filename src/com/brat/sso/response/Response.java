package com.brat.sso.response;

import org.springframework.http.HttpHeaders;

public class Response<T> {
    private Integer status;
    private HttpHeaders httpHeaders;

    private T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public void setHttpHeaders(HttpHeaders httpHeaders) {
        this.httpHeaders = httpHeaders;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", httpHeaders=" + httpHeaders +
                ", response=" + response +
                '}';
    }
}
