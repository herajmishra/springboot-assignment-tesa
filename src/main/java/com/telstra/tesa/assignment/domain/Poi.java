package com.telstra.tesa.assignment.domain;

import com.telstra.tesa.assignment.enums.PoiType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Poi {
  private String name;
  private CoOrdinates coOrdinates;
  private PoiType type;
  private float rating;
}
