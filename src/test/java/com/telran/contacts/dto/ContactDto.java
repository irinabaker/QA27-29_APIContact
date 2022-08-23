package com.telran.contacts.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class ContactDto {

    String address;
    String description;
    String email;
    String lastName;
    String name;
    String phone;
    int id;
}
