import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

import java.io.*;
public class PlaneInfo extends PlaneCost {
	private int id;
	private String manufacturer;
	private String model;
	private int seats;
	private int min_length_landing;
	private int average_speed;
	
	// constructors
	
	public PlaneInfo()
	{
		this.id = 0;
		this.manufacturer = "";
		this.model = "";
		this.seats = 0;
		this.min_length_landing = 0;
		this.average_speed = 0;
	}
	
	public PlaneInfo(int newId, String newManufacturer, String newModel,int newSeats, 
			int newMin_length_landing, int newAverage_speed,int staff, int f, int fuel_cap)
	{
		super(staff,f,fuel_cap);
		id = newId;
		manufacturer = newManufacturer;
		model = newModel;
		seats = newSeats;
		min_length_landing = newMin_length_landing;
		average_speed = newAverage_speed;
	}
	
	//setters and getters
	
	public void setId(int newId){
		id = newId;
	}
	public int getId()
	{
		return id;
	}
	
	public void setManufacturer(String newManufacturer){
		manufacturer = newManufacturer;
	}
	public String getManufacturer()
	{
		return manufacturer;
	}
	
	public void setModel(String newModel){
		model = newModel;
	}
	public String getModel(){
		return model;
	}
	
	public void setSeats(int newSeats){
		seats = newSeats;
	}
	public int getSeats(){
		return seats;
	}
	
	public void setMin_length_landing(int newMin_length_landing){
		min_length_landing = newMin_length_landing;
	}
	public int getMin_length_landing(){
		return min_length_landing;
	}
	
	public void setAverage_speed(int newAverage_speed)
	{
		average_speed = newAverage_speed;
	}
	public int getAverage_speed(){
		return average_speed;
	}
	
	
	public void enterPlanes(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter ID:");
		id = scan.nextInt();
		System.out.println("Enter Manufacturer:");
		manufacturer = scan.next();
		System.out.println("Enter model of plane:");
		model = scan.next();
		System.out.println("Enter number of seats:");
		seats = scan.nextInt();
		System.out.println("Enter the min. length of landing in km:");
		min_length_landing = scan.nextInt();
		System.out.println("Enter the average speed in km/h:");
		average_speed = scan.nextInt();
	}
	

	public void printAllInfo()
	{
		System.out.println("-----------------------------------");
		System.out.println("             Plane                 ");
		System.out.println("-----------------------------------");
		System.out.println("Plane ID:\t" +id);
		System.out.println("Manufacturer: \t" +manufacturer);
		System.out.println("Plane model:\t" +model);
		System.out.println("Number of seats:" +seats);
		System.out.println("Min. length landing:" +min_length_landing);
		System.out.println("Average speed:\t" +average_speed);
		System.out.println("Staff Costs:\t" + super.getStaff_costs());
		System.out.println("Fuel: \t" + super.getFuel());
		System.out.println("Fuel capacity:" + super.getFuel_capacity());
	}
	
	public void searchPlane(String manufacturer, String model){
		ArrayList<PlaneInfo> planeList = new ArrayList<PlaneInfo>();
		planeList.add(new PlaneInfo(111,"WizzAir","Boing 777",100,120,200,100,200,1000));
		planeList.add(new PlaneInfo(222,"Lufthansa","Boing 777",100,120,200,100,220,1200));
		planeList.add(new PlaneInfo(333,"AirUSA","Boing 377",60,100,150,110,220,1000));
		planeList.add(new PlaneInfo(333,"BulgariaAir","Boing 377",60,100,150,110,220,1000));
		for(int i = 0; i < planeList.size(); i ++)
		{
			if(manufacturer == planeList.get(i).getManufacturer() && model == planeList.get(i).getModel())
			{
				planeList.get(i).printAllInfo();
				break;
			}
			else{
				
				System.out.println("Plane not found!");
			}
		}
	}
	
	public void writeToFile(){
		try {
				File fout = new File("out.txt");
				if (!fout.exists())
                {
                    fout.createNewFile();
                }
                    FileOutputStream fos = new FileOutputStream(fout,true);
					BufferedWriter buffwriter = new BufferedWriter(new OutputStreamWriter(fos));
					buffwriter.write("-----------------------------------");
					buffwriter.newLine();
					buffwriter.write("             Plane                ");
					buffwriter.newLine();
					buffwriter.write("-----------------------------------");
					buffwriter.newLine();
					buffwriter.write("ID:" + id + System.getProperty( "line.separator" ));
					buffwriter.write("Manufacturer:" + manufacturer);
					buffwriter.newLine();
					buffwriter.write("Model:" + model);
					buffwriter.newLine();
					buffwriter.write("Number of seats:"+ seats + System.getProperty( "line.separator" ));
					buffwriter.write("Min length of landing:" + min_length_landing + System.getProperty( "line.separator" ));
					buffwriter.write("Average speed:" + average_speed + System.getProperty( "line.separator" ));
					buffwriter.write("Staff Costs:" + super.getStaff_costs() + System.getProperty("line.separator"));
					buffwriter.write("Fuel:" + super.getFuel() + System.getProperty("line.separator"));
					buffwriter.write("Fuel capacity:" + super.getFuel_capacity() + System.getProperty("line.separator"));
					buffwriter.close();
			}
		catch (IOException e){
				e.printStackTrace();
		}
	}
	
	public void readFromFile()
	{
		try{
		BufferedReader buffReader = new BufferedReader(new FileReader("out.txt"));
		String currentLine = buffReader.readLine();
		while ((currentLine = buffReader.readLine()) != null){
		       System.out.println(currentLine);
		      }
     
		buffReader.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		return;
	}
	
}
