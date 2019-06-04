package com.bookstore.bookstore.web.form;

import lombok.Data;

@Data
public class ModifyForm {

    private Long userId;

    private String username;

    private String email;

    private String phone;

}
