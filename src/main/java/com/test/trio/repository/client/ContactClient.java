package com.test.trio.repository.client;

import com.test.trio.repository.entity.ContatctEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="contacts", url = "${feign.client.config.contacts.endpoint}")
public interface ContactClient {

    @GetMapping("contacts")
    List<ContatctEntity> getAllContacts();

}
