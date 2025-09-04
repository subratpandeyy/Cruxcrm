package com.cruxcrm.Backend.service;

import com.cruxcrm.Backend.DTO.Request.ContactRequestDto;
import com.cruxcrm.Backend.DTO.Response.ContactResponseDto;

import java.util.List;

public interface ContactService {
    List<ContactResponseDto> getContacts();
    ContactResponseDto addContact(ContactRequestDto contactDto);
}
