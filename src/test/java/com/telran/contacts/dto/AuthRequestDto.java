package com.telran.contacts.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class AuthRequestDto {

    String email;
    String password;
}
