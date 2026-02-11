
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIn {
	static ArrayList<Person>  Persons = new ArrayList<>(); //for keeping person objects
	static ArrayList<Food> Foods = new ArrayList<>();      //for keeping food objects
	static ArrayList<Sports> sportss = new ArrayList<>();  //for keeping sports objects
	static ArrayList<String> personId = new ArrayList<>(); //for keeping person ids
	static ArrayList<String> foodId = new ArrayList<>();   //for keeping food ids
	static ArrayList<String> sportId = new ArrayList<>();  //for keeping sport ids


	public FileIn() throws IOException {
		
		try(Scanner people=new Scanner(new FileReader("people.txt"))){
			while(people.hasNextLine()) {
				String pline=people.nextLine(); // each line of people text
				String[] psplitted = pline.split("\t"); 
				String id=psplitted[0]; int weight=Integer.parseInt(psplitted[3]);
				personId.add(id);
				int height=Integer.parseInt(psplitted[4]); int date=Integer.parseInt(psplitted[5]);
			Persons.add(new Person(id,psplitted[1],psplitted[2],weight,height,date));
			
			
		}}	
		try(Scanner foodf=new Scanner(new FileReader("food.txt"))){
						while(foodf.hasNextLine()) {
							String fline=foodf.nextLine();
							String[] fsplitted = fline.split("\t");
							String id=fsplitted[0];  int cal=Integer.parseInt(fsplitted[2]);
							foodId.add(id);
							Foods.add(new Food(id,fsplitted[1],cal));
						
						}			}
		try(Scanner sportsf=new Scanner(new FileReader("sport.txt"))){
						while(sportsf.hasNextLine()) {
							String sline=sportsf.nextLine();
							String[] ssplitted = sline.split("\t");
							String id=ssplitted[0];  int cal=Integer.parseInt(ssplitted[2]);
							sportId.add(id);
							sportss.add(new Sports(id,ssplitted[1],cal));
						
	} }

	
} }
