import drink.DrinkType;
import maker.CoffeeMachineProcessor;
import maker.DrinkMaker;
import order.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeMachineProcessorTest {

    @InjectMocks
    private CoffeeMachineProcessor coffeeMachineProcessor;

    @Mock
    private DrinkMaker drinkMaker;

    @Test
    public void shouldCommandCoffeeWithoutStickWhenNoSugar() {
        String drinkMakerOrder = "C::";
        this.command(DrinkType.COFFEE, 0);

        Mockito.verify(drinkMaker, Mockito.only()).send(drinkMakerOrder);
    }

    @Test
    public void shouldCommandCoffeeWithStickWhenOneSugar() {
        String drinkMakerOrder = "C:1:0";
        this.command(DrinkType.COFFEE, 1);

        Mockito.verify(drinkMaker, Mockito.only()).send(drinkMakerOrder);
    }

    @Test
    public void shouldCommandTeaWithStickWhenTwoSugar() {
        String drinkMakerOrder = "T:2:0";
        this.command(DrinkType.TEA, 2);

        Mockito.verify(drinkMaker, Mockito.only()).send(drinkMakerOrder);
    }

    @Test
    public void shouldCommandChocolateWithoutStickWhenNoSugar() {
        String drinkMakerOrder = "H::";
        this.command(DrinkType.CHOCOLATE, 0);

        Mockito.verify(drinkMaker, Mockito.only()).send(drinkMakerOrder);
    }

    @Test
    public void shouldCommandOrangeJuiceWithoutStickWhenNoSugar() {
        String drinkMakerOrder = "O::";
        this.command(DrinkType.ORANGE_JUICE, 0);

        Mockito.verify(drinkMaker, Mockito.only()).send(drinkMakerOrder);
    }

    @Test
    public void shouldCommandOrangeJuiceWithStickWhenOneSugar() {
        String drinkMakerOrder = "O:1:0";
        this.command(DrinkType.ORANGE_JUICE, 1);

        Mockito.verify(drinkMaker, Mockito.only()).send(drinkMakerOrder);
    }

    @Test
    public void shouldCommandHotCoffeeWithStickWhenOneSugar() {
        String drinkMakerOrder = "Ch:1:0";
        this.commandHot(DrinkType.COFFEE, 1);

        Mockito.verify(drinkMaker, Mockito.only()).send(drinkMakerOrder);
    }

    @Test
    public void shouldNotCommandHotOrangeJuiceWithoutStickWhenNoSugar() {
        String drinkMakerOrder = "O::";
        this.commandHot(DrinkType.ORANGE_JUICE, 0);

        Mockito.verify(drinkMaker, Mockito.only()).send(drinkMakerOrder);
    }

    private void command(DrinkType drinkType, int sugarNumber) {
        coffeeMachineProcessor.processDrinkOrder(new Order(drinkType, sugarNumber, false));
    }

    private void commandHot(DrinkType drinkType, int sugarNumber) {
        coffeeMachineProcessor.processDrinkOrder(new Order(drinkType, sugarNumber, true));
    }
}
