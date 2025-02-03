package com.example.catalog.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class ResponseData {
    private List<StyleResponse> styleResponses;

}
