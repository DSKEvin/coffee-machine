import org.junit.Before;
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

        Mockito.verify(drinkMaker, Mockito.only()).makeDrink(drinkMakerOrder);
    }

    @Test
    public void shouldCommandCoffeeWithStickWhenOneSugar() {
        String drinkMakerOrder = "C:1:0";
        this.command(DrinkType.COFFEE, 1);

        Mockito.verify(drinkMaker, Mockito.only()).makeDrink(drinkMakerOrder);
    }

    @Test
    public void shouldCommandTeaWithStickWhenTwoSugar() {
        String drinkMakerOrder = "T:2:0";
        this.command(DrinkType.TEA, 2);

        Mockito.verify(drinkMaker, Mockito.only()).makeDrink(drinkMakerOrder);
    }

    @Test
    public void shouldCommandChocolateWithoutStickWhenNoSugar() {
        String drinkMakerOrder = "H::";
        this.command(DrinkType.CHOCOLATE, 0);

        Mockito.verify(drinkMaker, Mockito.only()).makeDrink(drinkMakerOrder);
    }


    private void command(DrinkType drinkType, int sugarNumber) {
        coffeeMachineProcessor.processDrinkOrder(new Order(drinkType, sugarNumber));
    }

}
