
public class Sports {
	private String id;
	private String name;
	private int calorieBurned;
	
	
	public Sports(String ids,String names,int calories) {
		id=ids;
		name=names;
		calorieBurned=calories;
			
	}

	public String getName() {
		return name;
	}


	public int getCalorieBurned() {
		return calorieBurned;
	}

}
