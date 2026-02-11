

public class Food {
	private String id;
	private String name;
	private int calorie;
	
	public Food(String ids,String names,int calories) {
		id=ids;
		name=names;
		calorie=calories;
		}	

	public String getName() {
		return name;
	}

	public int getCalorie() {
		return calorie;
	}

}
