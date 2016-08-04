package com.epam.eventrecorder.keysetlist.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eventrecorder.dao.KeysetDao;
import com.epam.eventrecorder.domain.Keyset;
import com.epam.eventrecorder.keysetlist.view.model.KeysetSummary;
import com.epam.eventrecorder.keysetlist.view.transform.KeysetToKeysetSummaryTransformer;

@RestController
public class KeysetListController {

    @Autowired
    KeysetToKeysetSummaryTransformer keysetSummaryTransformer;

    @Autowired
    KeysetDao keysetDao;

    @RequestMapping(value = "/keysets@{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<KeysetSummary> keysets(@PathVariable Integer userId) {
        List<Keyset> keysets = keysetDao.getKeysetByUserId(userId);
        return keysetSummaryTransformer.transformKeysetsToSummaries(keysets);
    }

}
