package com.test.trio.service;

import com.test.trio.repository.MailChimpIntegration;
import com.test.trio.repository.request.ImportContactRequest;
import com.test.trio.repository.response.ContactResponse;
import com.test.trio.repository.response.SyncContactsResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MailChimpService {

    private static final Logger log = LoggerFactory.getLogger(MailChimpService.class);

    private final MailChimpIntegration mailChimpIntegration;

    public SyncContactsResponse importContacts(final List<ImportContactRequest> contatcts){

        SyncContactsResponse syncContactsResponse = new SyncContactsResponse();

        contatcts.stream().forEach(contact -> {
            Boolean isUserCreatedSuccess = mailChimpIntegration.addContacts(contact);

            if(isUserCreatedSuccess){

                log.info("Add contact to response list.");

                ContactResponse contactResponse = new ContactResponse();
                contactResponse.setEmail(contact.getEmailAddress());
                contactResponse.setFirstName(contact.getMergeFields().getFirstName());
                contactResponse.setLastName(contact.getMergeFields().getLastName());

                syncContactsResponse.addSyncedCount();
                syncContactsResponse.getContact().add(contactResponse);

            }
        });

        log.info("sync complete!");

        return syncContactsResponse;
    }

}
