package maker;

import drink.DrinkType;
import junit.framework.TestCase;
import order.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMakerServiceTest extends TestCase {

    @InjectMocks
    private CoffeeMakerService coffeeMakerService;

    @Mock
    private CoffeeMachineProcessor coffeeMachineProcessor;

    @Test
    public void shouldCommandWhenEnoughMoneyInserted() {
        coffeeMakerService.receiveMoney(80);
        Order order = new Order(DrinkType.COFFEE, 1);

        coffeeMakerService.command(order);

        Mockito.verify(coffeeMachineProcessor, Mockito.only()).processDrinkOrder(order);
    }

    @Test
    public void shouldNotCommandWhenNotEnoughMoneyInserted() {
        coffeeMakerService.receiveMoney(10);
        Order order = new Order(DrinkType.COFFEE, 1);
        String message = "Missing money : 50";

        coffeeMakerService.command(order);

        Mockito.verify(coffeeMachineProcessor, Mockito.never()).processDrinkOrder(order);
        Mockito.verify(coffeeMachineProcessor, Mockito.only()).display(message);
    }
}