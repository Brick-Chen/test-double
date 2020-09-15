package stub;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class GradeServiceTest {
    /* 需求描述：
    编写GradeService类的单元测试，单元测试calculateAverageGrades方法
    * */
    private static class StubGradeSystem extends GradeSystem {
        public List<Double> gradesFor(long studentId) {
            return Arrays.asList(80.0, 90.0, 100.0);
        }
    }

    @Mock
    GradeSystem mockGradeSystem;

    GradeService service;

    @BeforeEach
    public void setUp() {
        service = new GradeService(mockGradeSystem);
    }
    
    @Test
    public void shouldReturn90WhenCalculateStudentAverageGradeAndGradeIs80And90And100() {
        GradeSystem gradeSystem = new StubGradeSystem();
        GradeService gradeService = new GradeService(gradeSystem);
        double result = gradeService.calculateAverageGrades(1);
        Assertions.assertEquals(90.0, result);
    }

    @Test
    public void should_return_90_using_stub_test_with_mockito() {
        List<Double> points = new ArrayList<>();
        points.add(80.0);
        points.add(90.0);
        points.add(100.0);
        Mockito.when(mockGradeSystem.gradesFor(1)).thenReturn(points);
        double score = service.calculateAverageGrades(1);
        Assertions.assertEquals(90.0, score);
    }

}
