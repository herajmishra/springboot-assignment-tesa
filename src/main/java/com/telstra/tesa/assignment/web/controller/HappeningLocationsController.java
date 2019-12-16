package com.telstra.tesa.assignment.web.controller;

import com.telstra.tesa.assignment.service.HappeningLocationsService;
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
@RequestMapping(path = "/happening")
@CrossOrigin(origins="*")
public class HappeningLocationsController {

  @Autowired
  private HappeningLocationsService happeningLocationsService;

  @GetMapping(path = "/locations/{location}")
  public ResponseEntity getLocations(@PathVariable String location) {

    if (StringUtils.isBlank(location)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "location cannot be empty");
    }
    return new ResponseEntity(happeningLocationsService.getHappeningLocations(location), HttpStatus.OK);
  }

}
