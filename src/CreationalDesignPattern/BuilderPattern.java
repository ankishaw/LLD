package CreationalDesignPattern;

import java.util.List;

class BurgerMeal{
    //Required
    private final String bunType;
    private final String patty;

    //Optional
    private final boolean hasCheese;
    private final List<String> toppings;
    private final String side;
    private final String drink;

    //Private Constructor
    private BurgerMeal(BurgerBuilder builder){
        this.bunType = builder.bunType;
        this.patty = builder.patty;
        this.hasCheese = builder.hasCheese;
        this.toppings = builder.toppings;
        this.side = builder.side;
        this.drink = builder.drink;
    }

    public static class BurgerBuilder{
        //Required
        private final String bunType;
        private final String patty;

        //Optional
        private boolean hasCheese;
        private List<String> toppings;
        private String side;
        private String drink;

        public BurgerBuilder(String bunType, String patty){
            this.bunType = bunType;
            this.patty = patty;
        }

        public BurgerBuilder withCheese(boolean hasCheese){
            this.hasCheese = hasCheese;
            return this;
        }
        public BurgerBuilder withToppings(List<String> toppings){
            this.toppings = toppings;
            return this;
        }
        public BurgerBuilder withSide(String side){
            this.side = side;
            return this;
        }
        public BurgerBuilder withDrink(String drink){
            this.drink = drink;
            return this;
        }

        public BurgerMeal build(){
            return new BurgerMeal(this);
        }
    }
}
public class BuilderPattern {
    public static void main(String[] args){
        BurgerMeal burgerMeal = new BurgerMeal.BurgerBuilder("Wheat", "Veg").build();
        BurgerMeal burgerMealWithCheese = new BurgerMeal.BurgerBuilder("Wheat", "Veg").withCheese(true).build();
    }
}
