import com.epam.lab.creator.TrainCreator;
import com.epam.lab.model.Train;
import org.junit.jupiter.api.*;

import java.util.List;

public class TrainCreatorTest {
    private TrainCreator creator = new TrainCreator();

    @Test
    public void testCreateTrains() {
        List<Train> trains = creator.createTrains();

        trains.forEach(System.out::println);
    }
}