package danielbuecheler.taskplanner;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;


public class TaskPlannerApp {

	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		System.out.println("Willkommen!");
//		System.out.println("Neuen Termin erstellen: ");
//		System.out.println("Name des Termins:");
//		String name = scn.nextLine();
//		System.out.println("Wichtigkeit in Prozent:");
//		double wichtigkeit = scn.nextDouble();
//		System.out.println("Ungefährer Zeitaufwand in Stunden:");
//		double zeitaufwand = scn.nextDouble();
//		System.out.println("Deadline:");
		Calendar dl = Calendar.getInstance();
		dl.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));
		dl.set(2014, 11, 11, 22, 40);
		System.out.println(dl.getTimeZone());
		System.out.println(dl.getTime());
		Aufgabe aufg = new Aufgabe("Foo", 22, 2.5, dl);
		System.out.println(aufg.getTimeToFinish());
	}

}