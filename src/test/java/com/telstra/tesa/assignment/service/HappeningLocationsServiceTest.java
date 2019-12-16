package com.telstra.tesa.assignment.service;

import com.telstra.tesa.assignment.domain.CoOrdinates;
import com.telstra.tesa.assignment.domain.Location;
import com.telstra.tesa.assignment.enums.Area;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith( SpringRunner.class )
@SpringBootTest
public class HappeningLocationsServiceTest {

  @Autowired
  private HappeningLocationsService happeningLocationsService;

  @Test
  public void shouldReturnLocationsIfParamLocationIsValid() {
    List<CoOrdinates> result = (List<CoOrdinates>) happeningLocationsService.getHappeningLocations(Area.Magarpatta.toString());
    assertNotNull(result);
    int totalLocationOfMagarpatta = happeningLocationsService.getLocations()
        .stream()
        .filter(location -> Area.Magarpatta.toString().equals(location.getArea().toString()))
        .collect(Collectors.toList()).size();
    System.out.println(result.size() + " " + totalLocationOfMagarpatta);
    assertTrue( result.size() <= totalLocationOfMagarpatta);
  }

  @Test
  public void shouldReturnEmptysIfParamLocationIsNotValid() {
    List<CoOrdinates> result = null;
    try {
      result = (List<CoOrdinates>) happeningLocationsService.getHappeningLocations("Invalid");
    } catch (ResponseStatusException ex) {
      assertEquals("404 NOT_FOUND \"invalid param\"", ex.getMessage());
    }
    assertNull(result);
  }
}