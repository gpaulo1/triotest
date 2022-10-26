package com.test.trio.repository.client;

import com.test.trio.repository.entity.NewUserMailChimbEntity;
import com.test.trio.repository.request.ImportContactRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="mailChimp", url = "${feign.client.config.mailchimp.endpoint}")
public interface MailChimpClient {

    @PutMapping("lists/1a60b1b366/members/{mailMd5Hash}")
    NewUserMailChimbEntity getAllContacts(@RequestHeader final HttpHeaders headers,
                                          @PathVariable final String mailMd5Hash,
                                          @RequestBody final ImportContactRequest importContactRequest);

}
