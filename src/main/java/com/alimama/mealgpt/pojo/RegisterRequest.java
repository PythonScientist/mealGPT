package com.alimama.mealgpt.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RegisterRequest {

    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String gender;
}
