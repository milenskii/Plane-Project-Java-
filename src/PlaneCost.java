import java.util.Scanner;

public class PlaneCost {
	private int staff_costs;
	private int fuel;
	private int fuel_capacity;
	
	public PlaneCost(){
		staff_costs = 0;
		fuel = 0;
		fuel_capacity = 0;
	}
	
	public PlaneCost(int staff, int f, int fuel_cap){
		staff_costs = staff;
		fuel = f;
		fuel_capacity = fuel_cap;
	}
	
	public void setStaff_costs(int staff){
		staff_costs = staff;
	}
	public int getStaff_costs(){
		return staff_costs;
	}
	
	public void setFuel(int f){
		fuel = f;
	}
	public int getFuel(){
		return fuel;
	}
	
	public void setFuel_capacity(int fuel_cap)
	{
		fuel_capacity = fuel_cap;
	}
	public int getFuel_capacity(){
		return fuel_capacity;
	}
	
	public void enterPlaneCosts()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Staff Costs:");
		staff_costs = scan.nextInt();
		System.out.println("Enter Fuel:");
		fuel = scan.nextInt();
		System.out.println("Enter fuel capacity:");
		fuel_capacity = scan.nextInt();
	}
	
	public void printAllCosts(){
		System.out.println("-----------------------------------");
		System.out.println("             Plane Costs           ");
		System.out.println("-----------------------------------");
		System.out.println("Staff Costs:\t" + staff_costs);
		System.out.println("Fuel: \t" + fuel);
		System.out.println("Fuel capacity:" + fuel_capacity);
	}
}
