package com.test.trio.repository.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImportContactRequest {

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("status_if_new")
    private String statusIfNew = "subscribed";

    @JsonProperty("merge_fields")
    private MergeFields mergeFields;

}
