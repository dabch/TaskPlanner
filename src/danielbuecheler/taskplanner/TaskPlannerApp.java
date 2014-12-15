package danielbuecheler.taskplanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;


public class TaskPlannerApp {
	private List<Task> taskList; //In dieser Liste werden die Termine, sp‰ter evtl. nach TQ sortiert, gespeichert
	
	public static void main(String[] args) {
		taskList = new ArrayList<>;
		Scanner scn = new Scanner(System.in);
		System.out.println("Willkommen!");
		System.out.println("Neuen Termin erstellen: ");
		System.out.println("Name des Termins:");
		String name = scn.nextLine();
		System.out.println("Wichtigkeit in Prozent:");
		double wichtigkeit = scn.nextDouble();
		System.out.println("Ungef√§hrer Zeitaufwand in Stunden:");
		double zeitaufwand = scn.nextDouble();
		System.out.println("Deadline:");
		Calendar dl = Calendar.getInstance();
		SimpleDateFormat formatInputDate = new SimpleDateFormat("dd.MM.yy, HH:mm");
		scn.nextLine();
		String dlStr = scn.nextLine();
		try {
			dl.setTime(formatInputDate.parse(dlStr));
		} catch (ParseException e) {}
		System.out.println(dl.getTimeZone());
		System.out.println(dl.getTime());
		Task aufg = new Task(name, wichtigkeit, zeitaufwand, dl);
		System.out.println(aufg);
		System.out.println(aufg.getTimeToFinish());
		System.out.printf("TQ: %.2f",  aufg.getTQ());
		scn.close();
		addToTaskList(aufg);
	}
	
	public void addToTaskList(Task t){
		taskList.add(t);
		//TODO: Diesen Code anpassen, sodass Tasks nach TQ sortiert eingeordnet werden
	}
}