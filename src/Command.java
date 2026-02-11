
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Command { 
	
	public void monitoring(String arg) throws IOException{
		
	String star="***************\n";
	
	try(Scanner commands=new Scanner(new FileReader(arg))
			){
		FileWriter monitoring= new FileWriter("monitoring.txt");
		
		ArrayList<Integer> personIndexlist =new ArrayList<Integer>();//for keeping people who mentioned in command text
		
		while(commands.hasNextLine()) {
			String cline=commands.nextLine();
			String[] csplitted = cline.split("\t");
			String first= csplitted[0]; // first element of command line
			
			if(first.equals("printList")) {
				for(int pIndex:personIndexlist) {
					monitoring.write(FileIn.Persons.get(pIndex).toString()+"\n");
					
				}
							
			}
			else if(first.equals("printWarn")) {
				int count=0; //to look up is there anyone need warn
				
				for(int pIndex:personIndexlist) {
					int totalCal=FileIn.Persons.get(pIndex).calorieTotal();
					int dailyNeed=FileIn.Persons.get(pIndex).getCalorieNeed();
					
					if(totalCal>dailyNeed) {
						monitoring.write(FileIn.Persons.get(pIndex).toString()+"\n");
						count++;
					}
				}
				if(count==0) {
					monitoring.write("there\tis\tno\tsuch\tperson\n");
				}
				
			}
			else if(first.startsWith("print(")) { //print(id) command
				String idno = first.substring(first.indexOf("(")+1, first.indexOf(")")); //taking the id in ()		
				int index=FileIn.personId.indexOf(idno);
				monitoring.write(FileIn.Persons.get(index).toString()+"\n");
				
			}
			else { // for eating a food or doing a sport commands
				String personId = first;
				int personIndex=FileIn.personId.indexOf(personId);
				if(!(personIndexlist.contains(personIndex))){ 
						personIndexlist.add(personIndex);}
				if(csplitted[1].startsWith("1")){
					
				String foodId = csplitted[1];
				int foodIndex=FileIn.foodId.indexOf(foodId);
				int foodscal=FileIn.Foods.get(foodIndex).getCalorie();
				int portion=Integer.parseInt(csplitted[2]);
				FileIn.Persons.get(personIndex).takeCal(foodscal, portion);
				monitoring.write(personId+"\thas\ttaken\t"+(foodscal*portion)+"kcal\tfrom\t"+FileIn.Foods.get(foodIndex).getName()+"\n");
				
				}
				else if(csplitted[1].startsWith("2")) {
					String sportId = csplitted[1];
					int sportIndex=FileIn.sportId.indexOf(sportId);
					int sportBurn=FileIn.sportss.get(sportIndex).getCalorieBurned();
					double duration=Integer.parseInt(csplitted[2]);
					long totalBurnedcal=Math.round(sportBurn*(duration/60));
					FileIn.Persons.get(personIndex).burnCal(totalBurnedcal);
					monitoring.write(personId+"\thas\tburned\t"+totalBurnedcal+"kcal\tthanks to\t"+FileIn.sportss.get(sportIndex).getName()+"\n");

		
				}
			}
			if(commands.hasNextLine()) {
				monitoring.write(star); //to write ***....
			}
		}
		monitoring.close();
	}
}}


