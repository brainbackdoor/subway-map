package com.brainbackdoor.subwaymap.map.dto;


import com.brainbackdoor.subwaymap.map.domain.SubwayPath;
import com.brainbackdoor.subwaymap.station.dto.StationResponse;

import java.util.List;
import java.util.stream.Collectors;

public class PathResponseAssembler {
    public static PathResponse assemble(SubwayPath subwayPath) {
        List<StationResponse> stationResponses = subwayPath.getStations().stream()
                .map(StationResponse::of)
                .collect(Collectors.toList());

        int distance = subwayPath.calculateDistance();

        return new PathResponse(stationResponses, distance);
    }

    private PathResponseAssembler() {
    }
}
