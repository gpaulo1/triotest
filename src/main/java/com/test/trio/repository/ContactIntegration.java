package com.test.trio.repository;

import com.test.trio.repository.client.ContactClient;
import com.test.trio.repository.entity.ContatctEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ContactIntegration {

    private final ContactClient contactClient;

    public List<ContatctEntity> getAllContacts() {
        return contactClient.getAllContacts();
    }

}
