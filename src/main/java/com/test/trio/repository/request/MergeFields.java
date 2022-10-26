package com.test.trio.repository.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MergeFields {

    @JsonProperty("FNAME")
    private String firstName;

    @JsonProperty("LNAME")
    private String lastName;

}
