package com.lambdaschool.lambdatable.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private String userNameOrEmail;

    @NotBlank
    private String password;

    public String getUserNameOrEmail() {
        return userNameOrEmail;
    }

    public void setUserNameOrEmail(String userNameOrEmail) {
        this.userNameOrEmail = userNameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
