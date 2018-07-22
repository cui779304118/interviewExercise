package com.cuiwei.designPattern;

/**
 * 当构造参数较多时，可以使用构造器模式，即用一个构造类来接受参数，然后把构造类实例作为目标类的参数
 */
public class BuilderPatternTest {

    public static void main(String[] args) {
    Nutrition nutrition = new Nutrition.NutritionBuilder(11,12)
            .calories(200).carbohydrate(34).fat(434).builder();
        System.out.println(nutrition.toString());
    }
}
interface Builder<T>{
    public T builder();
}

class Nutrition{
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public String toString(){
        return "servingSize" +"["+servingSize+"]" +
                ",servings" +"["+servings+"]" +
                ",calories" +"["+calories+"]" +
                ",fat" +"["+fat+"]" +
                ",sodium" +"["+sodium+"]" +
                ",carbohydrate" +"["+carbohydrate+"]";
    }

    public Nutrition(NutritionBuilder builder){
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static class NutritionBuilder implements Builder<Nutrition>{
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public NutritionBuilder(int servingSize, int servings){
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public NutritionBuilder calories(int calories){
            this.calories = calories;
            return this;
        }
        public NutritionBuilder fat(int fat){
            this.fat = fat;
            return this;
        }
        public NutritionBuilder sodium(int sodium){
            this.sodium = sodium;
            return this;
        }
        public NutritionBuilder carbohydrate(int carbohydrate){
            this.carbohydrate = carbohydrate;
            return this;
        }

        public Nutrition builder(){
            return new Nutrition(this);
        }
    }
}
