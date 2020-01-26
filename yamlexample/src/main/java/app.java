
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Map;

@SpringBootApplication
public class app {

    public static void main(String[] args) {

        ScopingConfiguration twoVehiclesModel = ScopingConfigurations.getInstance("two_vehicles");

    }
}
