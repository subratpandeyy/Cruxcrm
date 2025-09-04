package com.cruxcrm.Backend.service.Impl;

import com.cruxcrm.Backend.DTO.Request.ContactRequestDto;
import com.cruxcrm.Backend.DTO.Response.ContactResponseDto;
import com.cruxcrm.Backend.DTO.Response.LeadResponseDto;
import com.cruxcrm.Backend.model.Account;
import com.cruxcrm.Backend.model.Contact;
import com.cruxcrm.Backend.model.Lead;
import com.cruxcrm.Backend.repository.AccountRepository;
import com.cruxcrm.Backend.repository.ContactRepository;
import com.cruxcrm.Backend.repository.MemberRepository;
import com.cruxcrm.Backend.repository.OrganizationRepository;
import com.cruxcrm.Backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepo;

    @Autowired
    AccountRepository accountRepo;

    @Autowired
    OrganizationRepository orgRepo;

    @Autowired
    MemberRepository memberRepo;

    public List<ContactResponseDto> getContacts() {
        List<Contact> contacts = contactRepo.findAll();
                return contacts.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ContactResponseDto addContact(ContactRequestDto contactDto) {
        Contact contact = new Contact();
        contact.setContactName(contactDto.getContactName());
        contact.setContactEmail(contact.getContactEmail());
        contact.setContactPhone(contact.getContactPhone());

        Account account = accountRepo.findById(contactDto.getAccountId())
                .orElseThrow(() -> new RuntimeException("No Account found." + contactDto.getAccountId()));

    }


    private ContactResponseDto mapToResponse(Contact contact) {
        ContactResponseDto response = new ContactResponseDto();
        response.setContactId(contact.getContactId());
        response.setContactName(contact.getContactName());
        response.setContactEmail(contact.getContactEmail());
        response.setContactPhone(contact.getContactPhone());

        if(contact.getAccount()!=null) {
            response.setAccountName(contact.getAccount().getAccountName());
        }

        if(contact.getOrg()!=null) {
            response.setOrgName(contact.getOrg().getOrgName());
        }

        if(contact.getMember()!=null) {
            response.setMemberName(contact.getMember().getMemberName());
        }
        return response;
    }
}
