package com.telstra.tesa.assignment.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telstra.tesa.assignment.enums.Area;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {

  private CoOrdinates coOrdinates;
  private Area area;

  @JsonIgnore
  private Float rating;

}
