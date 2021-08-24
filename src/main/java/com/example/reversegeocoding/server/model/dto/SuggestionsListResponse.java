package com.example.reversegeocoding.server.model.dto;

import java.util.List;

public class SuggestionsListResponse {

    private List<AddressValueDTO> suggestions;

    public SuggestionsListResponse() {}

    public List<AddressValueDTO> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<AddressValueDTO> suggestions) {
        this.suggestions = suggestions;
    }


}
