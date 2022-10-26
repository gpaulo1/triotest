package com.test.trio.repository.response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SyncContactsResponse {

    private Long syncedContacts = 0l;
    private Set<ContactResponse> contact = new HashSet<>();

    public void addSyncedCount(){
        this.syncedContacts += 1;
    }

}
