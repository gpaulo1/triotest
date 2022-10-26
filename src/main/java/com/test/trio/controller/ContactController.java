package com.test.trio.controller;

import com.test.trio.repository.response.SyncContactsResponse;
import com.test.trio.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("contacts/sync")
    public ResponseEntity findContacts(){
        SyncContactsResponse contacts = contactService.findContacts();
        return new ResponseEntity<>(contacts, OK);
    }

}

