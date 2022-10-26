package com.test.trio.repository;

import com.test.trio.exception.RestException;
import com.test.trio.repository.client.MailChimpClient;
import com.test.trio.repository.entity.NewUserMailChimbEntity;
import com.test.trio.repository.request.ImportContactRequest;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import static com.test.trio.utils.SecurityUtils.convertMailToMd5;

@Component
@RequiredArgsConstructor
public class MailChimpIntegration {

    private static final Logger log = LoggerFactory.getLogger(MailChimpIntegration.class);

    private final MailChimpClient mailChimpClient;
    private static final String STATUS_SUBSCRIBED = "subscribed";

    @Value("${mail.chimp.client.apikey}")
    private String chimpApiKey;

    public Boolean addContacts(final ImportContactRequest contact){

        log.info("Beginning integration with mail chimp list. Contact: {} {}", contact.getMergeFields().getFirstName(), contact.getMergeFields().getLastName());

        String hash = convertMailToMd5(contact.getEmailAddress());

        NewUserMailChimbEntity addUser;

        try{

            addUser = mailChimpClient.getAllContacts(getHeader(), hash, contact);

        }catch (final FeignException.FeignServerException exception){

            throw new RestException(exception.getMessage(), exception, exception.status());

        }catch (final FeignException exception){

            log.error("Error sync contact: {}. Message: {}", contact.getMergeFields().getFirstName(), exception.getMessage());
            return false;

        }

        log.info("sync completed!");

        return STATUS_SUBSCRIBED.equals(addUser.getStatus())
                ? true
                : false;

    }

    private HttpHeaders getHeader(){
        final HttpHeaders header = new HttpHeaders();
        header.setBearerAuth(chimpApiKey);
        header.setContentType(MediaType.APPLICATION_JSON);

        return header;
    }



}
