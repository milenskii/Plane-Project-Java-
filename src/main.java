
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class main extends PlaneInfo {
	public static void main(String[] args){
//		PlaneInfo pi = new PlaneInfo();
//		pi.searchPlane("Bulgaria Air");
		PlaneInfo plane = new PlaneInfo();
		plane.enterPlanes();
		plane.enterPlaneCosts();
		plane.writeToFile();
		plane.readFromFile();
		System.out.println("Results for search");
		plane.searchPlane("WizzAir", "Boing 777");
	}
}