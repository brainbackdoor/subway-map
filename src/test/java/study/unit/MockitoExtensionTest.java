package study.unit;

import com.brainbackdoor.subwaymap.line.application.LineService;
import com.brainbackdoor.subwaymap.line.domain.Line;
import com.brainbackdoor.subwaymap.line.domain.LineRepository;
import com.brainbackdoor.subwaymap.line.dto.LineResponse;
import com.brainbackdoor.subwaymap.station.application.StationService;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("단위 테스트 - mockito의 MockitoExtension을 활용한 가짜 협력 객체 사용")
@ExtendWith(MockitoExtension.class)
public class MockitoExtensionTest {
    @Mock
    private LineRepository lineRepository;
    @Mock
    private StationService stationService;

    @Test
    void findAllLines() {
        // given
        when(lineRepository.findAll()).thenReturn(Lists.newArrayList(new Line()));
        LineService lineService = new LineService(lineRepository, stationService);

        // when
        List<LineResponse> responses = lineService.findLineResponses();

        // then
        assertThat(responses).hasSize(1);
    }
}
