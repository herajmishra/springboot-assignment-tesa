package com.telstra.tesa.assignment.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PoiResponse {
  private String name;
  private CoOrdinates coOrdinates;
}
