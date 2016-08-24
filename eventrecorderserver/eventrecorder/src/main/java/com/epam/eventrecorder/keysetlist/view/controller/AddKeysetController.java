package com.epam.eventrecorder.keysetlist.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.eventrecorder.keyset.service.AddKeysetService;
import com.epam.eventrecorder.keysetlist.view.model.KeysetSummary;
import com.epam.eventrecorder.keysetlist.view.transform.KeysetSummaryTransformer;

@Controller
public class AddKeysetController {

    @Autowired
    private AddKeysetService addKeysetService;

    @Autowired
    private KeysetSummaryTransformer keysetSummaryTransformer;

    @RequestMapping(value = "/addKeyset", method = RequestMethod.POST)
    void addKeyset(@RequestBody KeysetSummary keysetSummary) {
        addKeysetService.addKeyset(keysetSummaryTransformer.transformSummaryToKeyset(keysetSummary));
    }

}
