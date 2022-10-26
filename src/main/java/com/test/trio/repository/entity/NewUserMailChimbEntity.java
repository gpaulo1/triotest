package com.test.trio.repository.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserMailChimbEntity {

    private String id;

    @JsonProperty("contact_id")
    private String contactId;

    @JsonProperty("email_address")
    private String emailAddress;

    private String status;

}
