package com.brainbackdoor.subwaymap.station.dto;


import com.brainbackdoor.subwaymap.station.domain.Station;

public class StationRequest {
    private String name;

    public String getName() {
        return name;
    }

    public Station toStation() {
        return new Station(name);
    }
}
