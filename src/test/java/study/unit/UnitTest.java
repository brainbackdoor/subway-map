package study.unit;

import com.brainbackdoor.subwaymap.line.domain.Line;
import com.brainbackdoor.subwaymap.station.domain.Station;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("단위 테스트")
public class UnitTest {
    @DisplayName("단위 테스트 1")
    @Test
    void update() {
        // given
        String newName = "구분당선";

        Station upStation = new Station("강남역");
        Station downStation = new Station("광교역");
        Line line = new Line("신분당선", "RED", upStation, downStation, 10);
        Line newLine = new Line(newName, "GREEN");

        // when
        line.update(newLine);

        // then
        assertThat(line.getName()).isEqualTo(newName);
    }
}
