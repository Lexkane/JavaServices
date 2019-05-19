import com.epam.lab.creator.RouteCreator;
import com.epam.lab.model.Station;
import com.epam.lab.model.WagonType;
import com.epam.lab.services.Purchaser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceTest {

    @Test
    public void checkPriceLux() {
        Purchaser purchaser = new Purchaser();
        WagonType wagonType = WagonType.LUX;
        List<Station> stations = new RouteCreator().createLvivKharkivStations();
        assertEquals(450.0, purchaser.calculatePrice(stations, wagonType));
    }

    @Test
    public void checkPriceKupe() {
        Purchaser purchaser = new Purchaser();
        WagonType wagonType = WagonType.KUPE;
        List<Station> stations = new RouteCreator().createLvivDniproStations();
        assertEquals(225.0, purchaser.calculatePrice(stations, wagonType));
    }

    @Test
    public void checkPricePlazkart() {
        Purchaser purchaser = new Purchaser();
        WagonType wagonType = WagonType.PLAZKART;
        List<Station> stations = new RouteCreator().createLvivDniproStations();
        assertEquals(150.0, purchaser.calculatePrice(stations, wagonType));
    }
}
