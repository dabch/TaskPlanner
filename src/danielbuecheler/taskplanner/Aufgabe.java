package danielbuecheler.taskplanner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Aufgabe {
	private String name;
	private String description;
	private double timeNeeded;
	private Calendar deadline;
	private double importance;
	private int finished;

	public Aufgabe(String name, double wichtigkeitProzent, double zeitaufwandStd, Calendar deadline) {
		this.name = name;
		this.description = "";
		this.importance = wichtigkeitProzent;
		this.timeNeeded = zeitaufwandStd;
		this.deadline = deadline;
		this.finished = 0;
	}
	
	public int getTimeToFinish() {
		long millisDL = deadline.getTimeInMillis();
		long millisNow = Calendar.getInstance().getTimeInMillis();
		System.out.println(millisDL);
		System.out.println(millisNow);
		System.out.println((millisDL - millisNow) / 1000 / 60 / 60);
		return 0;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy, HH:mm");
		String returnString = this.getClass().getName() + "[name=" + name + ",beschreibung=" + description + ",zeitaufwand="
				+ timeNeeded + ",deadline=" + sdf.format(deadline.getTime()) + ",wichtigkeit=" + importance + ",fertigstellung=" + finished + "]";
		return returnString;
	}
}
