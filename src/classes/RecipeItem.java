package classes;

public class RecipeItem
{
	private FoodItem food;
	private String amount;
	private Measurement measure;
	
	public RecipeItem(FoodItem givenFood, String givenAmount, Measurement givenMeasurement)
	{
		food = givenFood;
		amount = givenAmount;
		measure = givenMeasurement;
	}
	
	public FoodItem getFoodItem()
	{
		return food;
	}
	
	public Measurement getMeasurement()
	{
		return measure;
	}
	
	public String getAmount()
	{
		return amount;
	}
	
	public void setFoodItem(FoodItem newFood)
	{
		food = newFood;
	}
	
	public void setMeasurement(Measurement newMeasurement)
	{
		measure = newMeasurement;
	}
	
	public void setAmount(String newAmount)
	{
		amount = newAmount;
	}
}
