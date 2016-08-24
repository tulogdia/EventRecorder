package com.epam.eventrecorder.keysetlist.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.epam.eventrecorder.keyset.domain.Keyset;
import com.epam.eventrecorder.keyset.service.KeysetListService;
import com.epam.eventrecorder.keysetlist.view.model.KeysetSummary;
import com.epam.eventrecorder.keysetlist.view.transform.KeysetSummaryTransformer;

@RestController
public class KeysetListController {

    @Autowired
    private KeysetListService keysetListService;

    @Autowired
    private KeysetSummaryTransformer keysetSummaryTransformer;

    @RequestMapping(value = "/keysets@{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<KeysetSummary> keysets(@PathVariable Long userId) {
        List<Keyset> keysets = keysetListService.getKeysetByUserId(userId);
        return keysetSummaryTransformer.transformKeysetsToSummaries(keysets);
    }

}
