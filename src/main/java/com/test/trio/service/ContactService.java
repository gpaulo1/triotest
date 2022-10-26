package com.test.trio.service;

import com.test.trio.repository.ContactIntegration;
import com.test.trio.repository.entity.ContatctEntity;
import com.test.trio.repository.request.ImportContactRequest;
import com.test.trio.repository.response.SyncContactsResponse;
import com.test.trio.service.mapper.ContactsResponseMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    private final ContactIntegration contactIntegration;
    private final MailChimpService mailChimpService;
    private final ContactsResponseMapper contactsResponseMapper;

    public SyncContactsResponse findContacts(){

        log.info("Obtaining contacts from OpenAPI.");

        List<ContatctEntity> allContacts = contactIntegration.getAllContacts();

        log.info("Contacts obtained successfully!");

        List<ImportContactRequest> importContactRequests = contactsResponseMapper.toRequest(allContacts);

        return mailChimpService.importContacts(importContactRequests);
    }

}
