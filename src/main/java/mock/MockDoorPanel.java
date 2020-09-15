package mock;

import java.util.stream.Stream;

public class MockDoorPanel extends DoorPanel {
    void close() {
        Stream.of("East Door", "West Door", "North Door", "South Door")
                .forEach((door) -> {
                    /*
                    第一步：调用第三方服务连接开关门系统接口...
                    第二步：调用第三方服务检查门的开关状态...
                    第三步：调用第三方服务检查门开关系统是否正常
                    第四步：请求关门
                    第五步：自动关门
                    第六步：检查门是否成功关闭
                    第七步：检查门关闭后其他系统是否正常
                    */
                    System.out.println("request connection");
                    System.out.println(door + " is open");
                    System.out.println("system is running");
                    System.out.println("request close the door");
                    System.out.println("closing");
                    System.out.println("check whether door is closed");
                    System.out.println(door + "is closed");
                });
    }
}
