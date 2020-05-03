package com.pilvo.contacts.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactResponse {
    long id;
    private String name;
    private String email;
    private String phonenumber;
}
