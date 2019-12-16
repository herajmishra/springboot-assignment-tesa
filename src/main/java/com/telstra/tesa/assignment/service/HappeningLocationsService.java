package com.telstra.tesa.assignment.service;

import com.telstra.tesa.assignment.domain.CoOrdinates;
import com.telstra.tesa.assignment.domain.Location;
import com.telstra.tesa.assignment.enums.Area;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HappeningLocationsService {

  private final List<Location> locations = new ArrayList<>();

  public HappeningLocationsService() {
    generateLocations();
  }

  public Object getHappeningLocations(String location) {
    Area area = null;
    try {
      area = Area.valueOf(location);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "invalid param");
    }
    return filterHappenningLocations(area);
  }

  private Object filterHappenningLocations(Area area) {
    List<Location> filteredLocations = this.locations
        .stream()
        .filter(loc -> area.equals(loc.getArea()))
        .collect(Collectors.toList());
    List<Location> sortedLocations = filteredLocations
        .stream()
        .sorted(Comparator.comparingDouble(Location::getRating).reversed())
        .collect(Collectors.toList());
    return formatResponse(sortedLocations.stream().limit(10).collect(Collectors.toList()));
  }

  private Object formatResponse(List<Location> mostHappeningLocations) {
    List<CoOrdinates> coOrdinates = new ArrayList<>();
    if(mostHappeningLocations.size() > 0) {
      mostHappeningLocations.stream().forEach(location -> coOrdinates.add(location.getCoOrdinates()));
    }
    return coOrdinates;
  }

  private void generateLocations() {

    this.locations.add(new Location(new CoOrdinates(5, 9), Area.Magarpatta,4.4f));
    this.locations.add(new Location(new CoOrdinates(5, 8), Area.Hinjawadi, 4.4f));
    this.locations.add(new Location(new CoOrdinates(3, 6), Area.Magarpatta, 4.6f));
    this.locations.add(new Location(new CoOrdinates(1, 4), Area.Vimannagar,4.7f));
    this.locations.add(new Location(new CoOrdinates(6, 5), Area.Magarpatta,4.9f));
    this.locations.add(new Location(new CoOrdinates(5, 7), Area.Vimannagar, 4.8f));
    this.locations.add(new Location(new CoOrdinates(7, 7), Area.Magarpatta,4.5f));
    this.locations.add(new Location(new CoOrdinates(2, 8), Area.Hinjawadi, 4.6f));
    this.locations.add(new Location(new CoOrdinates(1, 3), Area.Vimannagar, 4.8f));
    this.locations.add(new Location(new CoOrdinates(6, 1), Area.Magarpatta, 4.7f));
    this.locations.add(new Location(new CoOrdinates(1, 2), Area.Hinjawadi, 2.8f));
    this.locations.add(new Location(new CoOrdinates(1, 1), Area.Vimannagar, 3.8f));
    this.locations.add(new Location(new CoOrdinates(4, 1), Area.Hinjawadi, 1.8f));
    this.locations.add(new Location(new CoOrdinates(4, 4), Area.Magarpatta, 3.3f));
    this.locations.add(new Location(new CoOrdinates(7, 8), Area.Magarpatta,4.1f));

    this.locations.add(new Location(new CoOrdinates(4, 9), Area.Magarpatta,4.4f));
    this.locations.add(new Location(new CoOrdinates(4, 6), Area.Hinjawadi, 4.4f));
    this.locations.add(new Location(new CoOrdinates(3, 3), Area.Magarpatta, 4.6f));
    this.locations.add(new Location(new CoOrdinates(2, 5), Area.Vimannagar,4.7f));
    this.locations.add(new Location(new CoOrdinates(6, 9), Area.Magarpatta,4.9f));
    this.locations.add(new Location(new CoOrdinates(8, 1), Area.Vimannagar, 4.8f));
    this.locations.add(new Location(new CoOrdinates(8, 7), Area.Magarpatta,4.5f));
    this.locations.add(new Location(new CoOrdinates(1, 8), Area.Hinjawadi, 4.6f));
    this.locations.add(new Location(new CoOrdinates(4, 3), Area.Vimannagar, 4.8f));
    this.locations.add(new Location(new CoOrdinates(5, 1), Area.Magarpatta, 4.7f));
    this.locations.add(new Location(new CoOrdinates(6, 2), Area.Hinjawadi, 2.8f));
    this.locations.add(new Location(new CoOrdinates(3, 1), Area.Vimannagar, 3.8f));
    this.locations.add(new Location(new CoOrdinates(9, 1), Area.Hinjawadi, 1.8f));
    this.locations.add(new Location(new CoOrdinates(2, 6), Area.Magarpatta, 3.3f));
    this.locations.add(new Location(new CoOrdinates(9, 7), Area.Magarpatta,4.1f));

    this.locations.add(new Location(new CoOrdinates(4, 8), Area.Magarpatta,4.4f));
    this.locations.add(new Location(new CoOrdinates(4, 5), Area.Hinjawadi, 4.4f));
    this.locations.add(new Location(new CoOrdinates(6, 7), Area.Magarpatta, 4.6f));
    this.locations.add(new Location(new CoOrdinates(2, 4), Area.Vimannagar,4.7f));
    this.locations.add(new Location(new CoOrdinates(6, 6), Area.Magarpatta,4.9f));
    this.locations.add(new Location(new CoOrdinates(8, 9), Area.Vimannagar, 4.8f));
    this.locations.add(new Location(new CoOrdinates(8, 8), Area.Magarpatta,4.5f));
    this.locations.add(new Location(new CoOrdinates(1, 9), Area.Hinjawadi, 4.6f));
    this.locations.add(new Location(new CoOrdinates(4, 2), Area.Vimannagar, 4.8f));
    this.locations.add(new Location(new CoOrdinates(5, 6), Area.Magarpatta, 4.7f));
    this.locations.add(new Location(new CoOrdinates(6, 3), Area.Hinjawadi, 2.8f));
    this.locations.add(new Location(new CoOrdinates(4, 7), Area.Vimannagar, 3.8f));
    this.locations.add(new Location(new CoOrdinates(9, 9), Area.Hinjawadi, 1.8f));
    this.locations.add(new Location(new CoOrdinates(2, 2), Area.Hinjawadi, 3.3f));
    this.locations.add(new Location(new CoOrdinates(9, 8), Area.Magarpatta,4.1f));
  }

  public List<Location> getLocations() {
    return locations;
  }

}
