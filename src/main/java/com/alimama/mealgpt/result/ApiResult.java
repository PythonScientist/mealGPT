package com.alimama.mealgpt.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResult implements Serializable {
    private String userName;
    private String jwtToken;
    private final String FAIL_MSG = "Invalid username or password";

    public ApiResult success(String userName, String jwtToken) {
        ApiResult apiResult = new ApiResult();
        apiResult.setUserName(userName);
        apiResult.setJwtToken(jwtToken);

        return apiResult;
    }

    public String fail() {
        return FAIL_MSG;
    }

}
