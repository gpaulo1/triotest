package com.test.trio.service.mapper;

import com.test.trio.repository.entity.ContatctEntity;
import com.test.trio.repository.request.ImportContactRequest;
import com.test.trio.repository.request.MergeFields;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContactsResponseMapper {

    public List<ImportContactRequest> toRequest(final List<ContatctEntity> contatctEntityList){

        List<ImportContactRequest> importList = new ArrayList<>();

        contatctEntityList.forEach(contatctEntity -> {
            ImportContactRequest importContactRequest = new ImportContactRequest();
            MergeFields mergeFields = new MergeFields();

            mergeFields.setFirstName(contatctEntity.getFirstName());
            mergeFields.setLastName(contatctEntity.getLastName());

            importContactRequest.setEmailAddress(contatctEntity.getEmail());
            importContactRequest.setMergeFields(mergeFields);

            importList.add(importContactRequest);
        });

        return importList;

    }

}
