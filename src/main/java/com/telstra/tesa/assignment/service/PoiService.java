package com.telstra.tesa.assignment.service;

import com.telstra.tesa.assignment.domain.CoOrdinates;
import com.telstra.tesa.assignment.domain.Poi;
import com.telstra.tesa.assignment.domain.PoiResponse;
import com.telstra.tesa.assignment.enums.PoiType;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PoiService {

  private final List<Poi> pois = new ArrayList<>();

  public PoiService() {
    generatePois();
  }

  public Object getPois(String type) {
    PoiType poiType = null;
    try {
       poiType = PoiType.valueOf(type);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "invalid param");
    }
    return filterTopRatedPois(poiType);
  }

  private Object filterTopRatedPois(PoiType poiType) {
    List<Poi> filteredPois = this.pois
        .stream()
        .filter(poi -> poiType.equals(poi.getType()))
        .collect(Collectors.toList());
    List<Poi> sortedPois = filteredPois
        .stream()
        .sorted(Comparator.comparingDouble(Poi::getRating).reversed())
        .collect(Collectors.toList());
    return (formatResponse(sortedPois.stream().limit(20).collect(Collectors.toList())));
  }

  private Object formatResponse(List<Poi> topPois) {
    List<PoiResponse> poiResponses = new ArrayList<>();
    if (topPois.size() > 0) {
      topPois.stream().forEach(poi -> poiResponses.add(new PoiResponse(poi.getName(), poi.getCoOrdinates())));
    }
    return poiResponses;
  }

  private void generatePois() {
    pois.add(new Poi("Sagar", new CoOrdinates(5, 9), PoiType.Hotels,  4.3f));
    pois.add(new Poi("Meridian", new CoOrdinates(5, 6), PoiType.Hotels, 4.9f));
    pois.add(new Poi("Hill Top", new CoOrdinates(3, 6), PoiType.Hotels, 4.0f));
    pois.add(new Poi("Kaveri", new CoOrdinates(4, 5), PoiType.Hotels, 4.3f));
    pois.add(new Poi("Ibis", new CoOrdinates(6, 5), PoiType.Hotels, 4.9f));
    pois.add(new Poi("Oyo rooms", new CoOrdinates(5, 7), PoiType.Hotels, 2.5f));
    pois.add(new Poi("Shiv Sagar", new CoOrdinates(7, 7), PoiType.Hotels, 1.9f));
    pois.add(new Poi("Cozy Nest", new CoOrdinates(2, 8), PoiType.Hotels, 1.9f));
    pois.add(new Poi("Sonar Bangla", new CoOrdinates(1, 3), PoiType.Hotels, 1.0f));
    pois.add(new Poi("Radisson Blue", new CoOrdinates(6, 1), PoiType.Hotels, 4.5f));
    pois.add(new Poi("Ginger", new CoOrdinates(1, 2), PoiType.Hotels, 4.6f));
    pois.add(new Poi("Orritel", new CoOrdinates(1, 1), PoiType.Hotels, 3.4f));
    pois.add(new Poi("Solitaire", new CoOrdinates(4, 1), PoiType.Hotels, 4.9f));
    pois.add(new Poi("Fortune Inn", new CoOrdinates(6, 6), PoiType.Hotels, 4.8f));
    pois.add(new Poi("Marriott", new CoOrdinates(7, 8), PoiType.Hotels, 4.9f));
    pois.add(new Poi("Siesta", new CoOrdinates(4, 9), PoiType.Hotels, 4.1f));
    pois.add(new Poi("Lemon Tree", new CoOrdinates(4, 6), PoiType.Hotels, 4.0f));
    pois.add(new Poi("Vivanta", new CoOrdinates(6, 6), PoiType.Hotels, 4.7f));
    pois.add(new Poi("Ornate", new CoOrdinates(2, 5), PoiType.Hotels, 4.6f));
    pois.add(new Poi("Mastiff", new CoOrdinates(8, 7), PoiType.Hotels, 4.2f));
    pois.add(new Poi("Sorrento", new CoOrdinates(8, 7), PoiType.Hotels, 4.9f));
    pois.add(new Poi("Pragati", new CoOrdinates(1, 8), PoiType.Hotels, 2.9f));
    pois.add(new Poi("Ecotel", new CoOrdinates(4, 3), PoiType.Hotels, 2.9f));
    pois.add(new Poi("Comfort Inn", new CoOrdinates(5, 9), PoiType.Hotels, 4.3f));
    pois.add(new Poi("Novatel", new CoOrdinates(6, 2), PoiType.Hotels, 4.4f));
    pois.add(new Poi("Premium", new CoOrdinates(4, 1), PoiType.Hotels, 3.6f));
    pois.add(new Poi("Oyo Flagship", new CoOrdinates(9, 1), PoiType.Hotels, 3.1f));
    pois.add(new Poi("Trupti", new CoOrdinates(2, 6), PoiType.Hotels, 2.4f));
    pois.add(new Poi("Holiday Inn", new CoOrdinates(9, 7), PoiType.Hotels, 3.9f));
    pois.add(new Poi("Taj", new CoOrdinates(5, 9), PoiType.Hotels, 4.4f));

    pois.add(new Poi("Jeevan Sudha Hospital", new CoOrdinates(4, 1), PoiType.Hospitals,  4.3f));
    pois.add(new Poi("Civil Hospital", new CoOrdinates(6, 6), PoiType.Hospitals, 4.9f));
    pois.add(new Poi("Gayatri Hospital", new CoOrdinates(7, 8), PoiType.Hospitals, 4.0f));
    pois.add(new Poi("Kaveri Hospital", new CoOrdinates(4, 9), PoiType.Hospitals, 4.3f));
    pois.add(new Poi("Fortis", new CoOrdinates(4, 6), PoiType.Hospitals, 4.9f));
    pois.add(new Poi("Ruby Hall", new CoOrdinates(2, 5), PoiType.Hospitals, 2.5f));
    pois.add(new Poi("Shiv Sagar Hosital", new CoOrdinates(8,  7), PoiType.Hospitals, 1.9f));
    pois.add(new Poi("Prathna Hospital", new CoOrdinates(4, 3), PoiType.Hospitals, 1.9f));
    pois.add(new Poi("Nobel Hospital ", new CoOrdinates(9, 1), PoiType.Hospitals, 1.0f));
    pois.add(new Poi("Shalby Hospital", new CoOrdinates(9, 7), PoiType.Hospitals, 4.5f));
    pois.add(new Poi("Deenanath Mangeshkar Hospital", new CoOrdinates(9, 7), PoiType.Hospitals, 4.6f));
    pois.add(new Poi("Sahyadri", new CoOrdinates(4, 8), PoiType.Hospitals, 3.4f));
    pois.add(new Poi("Deccan", new CoOrdinates(4, 5), PoiType.Hospitals, 4.9f));
    pois.add(new Poi("Colambia", new CoOrdinates(6, 7), PoiType.Hospitals, 4.8f));
    pois.add(new Poi("Jehangir", new CoOrdinates(2, 4), PoiType.Hospitals, 4.9f));
    pois.add(new Poi("Kem", new CoOrdinates(8, 9), PoiType.Hospitals, 4.1f));
    pois.add(new Poi("Poona", new CoOrdinates(8, 8), PoiType.Hospitals, 4.0f));
    pois.add(new Poi("N M Wadia", new CoOrdinates(8, 8), PoiType.Hospitals, 4.7f));
    pois.add(new Poi("Joshi Hospital", new CoOrdinates(5, 6), PoiType.Hospitals, 4.6f));
    pois.add(new Poi("Hardikar Hospital", new CoOrdinates(5, 9), PoiType.Hospitals, 4.2f));
    pois.add(new Poi("Command Hospital", new CoOrdinates(5, 9), PoiType.Hospitals, 4.9f));
    pois.add(new Poi("Inlaks Hospital", new CoOrdinates(5, 9), PoiType.Hospitals, 2.9f));
    pois.add(new Poi("Cloud Nine Hospitals", new CoOrdinates(3, 6), PoiType.Hospitals, 2.9f));
    pois.add(new Poi("Sterling", new CoOrdinates(4, 5), PoiType.Hospitals, 4.3f));
    pois.add(new Poi("Cipla ", new CoOrdinates(3, 6), PoiType.Hospitals, 4.4f));
    pois.add(new Poi("BJ Medical", new CoOrdinates(5, 9), PoiType.Hospitals, 3.6f));
    pois.add(new Poi("ONP Leela Hospitals ", new CoOrdinates(5, 9), PoiType.Hospitals, 3.1f));
    pois.add(new Poi("Ranka Hospital", new CoOrdinates(5, 9), PoiType.Hospitals, 2.4f));
    pois.add(new Poi("Sancheti Hospital", new CoOrdinates(7, 7), PoiType.Hospitals, 3.9f));
    pois.add(new Poi("Sahawas Hospital", new CoOrdinates(5, 9), PoiType.Hospitals, 4.4f));
  }

  public List<Poi> getPois() {
    return pois;
  }

}
