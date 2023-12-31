package com.brainbackdoor.subwaymap.map.application;

import com.brainbackdoor.subwaymap.line.application.LineService;
import com.brainbackdoor.subwaymap.line.domain.Line;
import com.brainbackdoor.subwaymap.map.domain.SubwayPath;
import com.brainbackdoor.subwaymap.map.dto.PathResponse;
import com.brainbackdoor.subwaymap.map.dto.PathResponseAssembler;
import com.brainbackdoor.subwaymap.station.application.StationService;
import com.brainbackdoor.subwaymap.station.domain.Station;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MapService {
    private LineService lineService;
    private StationService stationService;
    private PathService pathService;

    public MapService(LineService lineService, StationService stationService, PathService pathService) {
        this.lineService = lineService;
        this.stationService = stationService;
        this.pathService = pathService;
    }

    public PathResponse findPath(Long source, Long target) {
        List<Line> lines = lineService.findLines();
        Station sourceStation = stationService.findById(source);
        Station targetStation = stationService.findById(target);
        SubwayPath subwayPath = pathService.findPath(lines, sourceStation, targetStation);

        return PathResponseAssembler.assemble(subwayPath);
    }
}
