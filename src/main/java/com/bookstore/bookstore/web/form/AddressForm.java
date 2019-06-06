package com.bookstore.bookstore.web.form;

import lombok.Data;

@Data
public class AddressForm {

     private Long userId;

    private String content;

    private String area;

    private String defaultAddress;

    private Integer phone;

    private String people;

    private Integer postcode;



}
