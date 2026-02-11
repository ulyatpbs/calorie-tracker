
public class Person {

	private String id;
	private String name;
	private String gender;
	private int weight;
	private int height;
	private int date;
	private int calorieNeed;
	private int calorieTaken;
	private int calorieBurned;
	private int age;
	private int result;
	public Person(String ids,String names,String genders,int weights,int heights,int dates){
		id=ids;
		name=names;
		gender=genders;
		weight=weights;
		height=heights;
		date=dates;
	    age=2022-date;
	    if (gender.equals("male")) {
			//66 + (13.75 𝑥 𝑤𝑒𝑖𝑔ℎ𝑡 (𝑘𝑔)) + (5 𝑥 ℎ𝑒𝑖𝑔ℎ𝑡 (𝑐𝑚)) – (6.8 𝑥 𝑎𝑔𝑒)  
			calorieNeed=(int) Math.round(66+(13.75*weight)+(5*height)-(6.8*age));
			}
		else if(gender.equals("female")) {
			//= 665 + (9.6 𝑥 𝑤𝑒𝑖𝑔ℎ𝑡 (𝑘𝑔)) + (1.7 𝑥 ℎ𝑒𝑖𝑔ℎ𝑡 (𝑐𝑚)) – (4.7 𝑥 𝑎𝑔𝑒)
			calorieNeed=(int) Math.round(665+(9.6*weight)+(1.7*height)-(4.7*age));
			
		}				
	}
	public void takeCal(int cal,int portion) {
		calorieTaken+=cal*portion;
	}
	public void burnCal(long calburned) {
		calorieBurned+=(int)calburned;
		
	}
	public int calorieTotal() {
		int calorieTotal=calorieTaken-calorieBurned;
		return calorieTotal;
	}
	
	public String getId() {
		return id;
	}

	public int getCalorieNeed() {
		return calorieNeed;
	}
 
	@Override
	public String toString() { //this method returns calorie statuses of person
		result=calorieNeed-calorieTotal();
		String resultWithsign = "0"; 
		if(result>0) {resultWithsign="-"+result;}
		else if(result<0) {resultWithsign="+"+(-result);}
		return  name + "\t" + age  + "\t" + calorieNeed  + "kcal\t" + calorieTaken + "kcal\t" 
	+ calorieBurned  + "kcal\t"+ resultWithsign+"kcal";
	}
	
	
}
