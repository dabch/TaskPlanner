package danielbuecheler.taskplanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;


public class TaskPlannerApp {
	private static List<Task> taskList; //in this (Array)List the Tasks will be saved (later maybe sorted by TQ)
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		taskList = new ArrayList<>();
		while(true) {
			System.out.println("Willkommen!");
			System.out.println("Neuen Termin erstellen: ");
			System.out.println("Name des Termins:");
			String name = scn.nextLine();
			System.out.println("Wichtigkeit in Prozent:");
			double wichtigkeit = scn.nextDouble();
			System.out.println("UngefÃ¤hrer Zeitaufwand in Stunden:");
			double zeitaufwand = scn.nextDouble();
			System.out.println("Deadline:");
			Calendar dl = Calendar.getInstance();
			SimpleDateFormat formatInputDate = new SimpleDateFormat("dd.MM.yy HH:mm");
			scn.nextLine();
			String dlStr = scn.nextLine();
			try {
				dl.setTime(formatInputDate.parse(dlStr));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Task aufg = new Task(name, wichtigkeit, zeitaufwand, dl);
			System.out.println(aufg);
			addToTaskList(aufg);
			for(Task task : taskList) {
				System.out.printf("Name: %s, TQ: %.2f%n", task.getName(), task.getTQ());
			}
		}
	}
	
	public static void addToTaskList(Task t){
		taskList.add(t);
		Collections.sort(taskList, new TaskComparatorByTQ());
	}
}
