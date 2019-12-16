package com.telstra.tesa.assignment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.telstra.tesa.assignment.domain.Poi;
import com.telstra.tesa.assignment.domain.PoiResponse;
import com.telstra.tesa.assignment.enums.PoiType;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoiServiceTest {

  @Autowired
  private PoiService poiService;

  @Test
  public void shouldReturnHotelsIfPoiTypeIsHotel() {
    List<PoiResponse> poiResponses = (List<PoiResponse>) poiService.getPois(PoiType.Hotels.toString());
    assertNotNull(poiResponses);
    List<Poi> totalHotels = poiService.getPois()
        .stream()
        .filter(poi -> PoiType.Hotels.toString().equals(poi.getType().toString()))
        .collect(Collectors.toList());
    assertTrue(totalHotels.size() >= poiResponses.size());
    assertTrue(20 >= poiResponses.size());
  }

  @Test
  public void shouldReturnEmptysIfParamLocationIsNotValid() {
    List<PoiResponse> poiResponses = null;
    try {
      poiResponses = (List<PoiResponse>) poiService.getPois("Invalid");
    } catch (ResponseStatusException ex) {
      assertEquals("404 NOT_FOUND \"invalid param\"", ex.getMessage());
    }
    assertNull(poiResponses);
  }
}
