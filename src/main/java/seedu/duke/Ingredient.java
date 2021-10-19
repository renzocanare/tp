package seedu.duke;

public class Ingredient implements  Comparable<Ingredient> {

    private Ui ui = new Ui();
    private String ingredientName;
    private double ingredientWeight;
    private double ingredientWasteIngr;
    public double ingredientWasteDish;

    public Ingredient(String ingredientName, double ingredientWeight) {
        this.ingredientName = ingredientName;
        this.ingredientWeight = ingredientWeight;
        this.ingredientWasteIngr = 0;
    }

    public Ingredient(String ingredientName, double ingredientWeight, double ingredientWaste) {
        this.ingredientName = ingredientName;
        this.ingredientWeight = ingredientWeight;
        this.ingredientWasteIngr = ingredientWaste;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void updateIngredientWeight(double weightChange) {
        ingredientWeight += weightChange;
        ui.printStorage(ingredientName, ingredientWeight);
    }

    public void addWaste(Double waste) {
        ingredientWasteIngr += waste;
        double totalWaste = ingredientWasteIngr + ingredientWasteDish;
        ui.printWastage(ingredientName, totalWaste);
    }

    public double getWastage() {
        return ingredientWasteIngr + ingredientWasteDish;
    }

    @Override
    public String toString() {
        double totalWaste = ingredientWasteIngr + ingredientWasteDish;
        //Todo add constituents
        return ingredientName + '\n'
                + "   Storage: " + ingredientWeight + " kg" +  System.lineSeparator()
                + "   Wastage: " + totalWaste + " kg";
    }

    public String formatData() {
        return ingredientName + "|"  + ingredientWeight + "|" + ingredientWasteIngr;
    }


    public void addDishWaste(Double value) {
        ingredientWasteDish += value;
    }

    public String toGraph(double max) {
        double wastage = ingredientWasteDish + ingredientWasteDish;
        String bar = "[";
        int num = (int)(10 * wastage / max);
        for (int i = 0; i < 10; i++) {
            if (i < num) {
                bar = bar + "█";
            } else  {
                bar = bar + " ";
            }
        }
        bar = bar + "]";
        return ingredientName + System.lineSeparator()
                + "   Wastage: " + bar + " " + wastage + " kg";
    }

    @Override
    public int compareTo(Ingredient o) {
        return (int) (ingredientWasteIngr - o.ingredientWasteIngr);
    }
}
