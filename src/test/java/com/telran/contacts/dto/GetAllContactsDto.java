package com.telran.contacts.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Builder
public class GetAllContactsDto {

    List<ContactDto> contacts;
}
