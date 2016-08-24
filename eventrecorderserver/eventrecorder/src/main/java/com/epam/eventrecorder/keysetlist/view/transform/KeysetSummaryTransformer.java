package com.epam.eventrecorder.keysetlist.view.transform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.eventrecorder.keyset.domain.Keyset;
import com.epam.eventrecorder.keysetlist.view.model.KeysetSummary;

@Component
public class KeysetSummaryTransformer {

    public List<KeysetSummary> transformKeysetsToSummaries(List<Keyset> keysets) {
        List<KeysetSummary> result = new ArrayList<>();
        for (Keyset keyset : keysets) {
            result.add(transformKeysetToSummary(keyset));
        }
        return result;
    }

    public KeysetSummary transformKeysetToSummary(Keyset keyset) {
        KeysetSummary result = new KeysetSummary();
        result.setId(keyset.getId());
        result.setName(keyset.getName());
        result.setKeyEvents(keyset.getKeyEvents());
        return result;
    }

    public Keyset transformSummaryToKeyset(KeysetSummary keysetSummary) {
        Keyset result = new Keyset();
        result.setId(keysetSummary.getId());
        result.setName(keysetSummary.getName());
        result.setKeyEvents(keysetSummary.getKeyEvents());
        return result;
    }

}
