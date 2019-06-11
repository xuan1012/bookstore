package com.bookstore.bookstore.web.form;

import lombok.Data;

@Data
public class ModifyForm {

    private Long userId;

    private String nicname;

    private String email;

    private String phone;

    private String password;

    private String passwordTow;

    private String verificationCode;

}
