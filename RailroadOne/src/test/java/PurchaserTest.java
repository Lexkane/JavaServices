import com.epam.lab.model.Station;
import com.epam.lab.services.Purchaser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PurchaserTest {
  private static Purchaser purchaser;

  @BeforeAll
   static void initialize() {
    purchaser = new Purchaser();
  }

  @Test
  public void testFindAppropriateTrainsEmpty() {


  }

  @Test
  public void testFindAppropriateTrainsNotEmpty() {

  }

}
