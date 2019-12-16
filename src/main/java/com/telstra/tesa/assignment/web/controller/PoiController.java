package com.telstra.tesa.assignment.web.controller;

import com.telstra.tesa.assignment.service.PoiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/poi")
@CrossOrigin(origins="*")
public class PoiController {

  @Autowired
  private PoiService poiService;

  @GetMapping(path = "/{type}")
  public ResponseEntity getHotels(@PathVariable String type) {
    if (StringUtils.isBlank(type)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "type cannot be empty");
    }
    return new ResponseEntity(poiService.getPois(type), HttpStatus.OK);
  }
}
