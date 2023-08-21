package com.alimama.mealgpt.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterRequest {

    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String gender;
}
