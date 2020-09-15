package mock;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SecurityCenterTest {
    /* 需求描述：
    编写SecurityCenter类的单元测试，单元测试switchOn方法，不依赖于DoorPanel的close的方法实现
    * */
    @Mock private DoorPanel doorPanel;
    private SecurityCenter securityCenter;


    @BeforeEach
    public void setUp() {
        doorPanel = Mockito.mock(DoorPanel.class);
        securityCenter = new SecurityCenter(doorPanel);
    }

    @Test
    public void shouldVerifyDoorIsClosed() {
//        MockDoorPanel mockDoorPanel = new MockDoorPanel();
//        SecurityCenter securityCenter = new SecurityCenter(mockDoorPanel);
//        securityCenter.switchOn();
        securityCenter.switchOn();
        Mockito.verify(doorPanel).close();
    }
}
