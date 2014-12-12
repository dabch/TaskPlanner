package danielbuecheler.taskplanner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task {
	private String name;
	private String description;
	private double timeNeeded;
	private Calendar deadline;
	private double importance;
	private int finished;

	public Task(String name, double wichtigkeitProzent, double zeitaufwandStd, Calendar deadline) {
		this.name = name;
		this.description = "";
		this.importance = wichtigkeitProzent;
		this.timeNeeded = zeitaufwandStd;
		this.deadline = deadline;
		this.finished = 0;
	}
	
	public long getTimeToFinish() {
		SimpleDateFormat df = new SimpleDateFormat("dd HH:mm");
		Date dl = deadline.getTime();
		Date now = Calendar.getInstance().getTime();
		System.out.println(new Date(dl.getTime() - now.getTime()));
		return (dl.getTime() - now.getTime()) / 60000;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy, HH:mm");
		String returnString = this.getClass().getName() + "[name=" + name + ",beschreibung=" + description + ",zeitaufwand="
				+ timeNeeded + ",deadline=" + sdf.format(deadline.getTime()) + ",wichtigkeit=" + importance + ",fertigstellung=" + finished + "]";
		return returnString;
	}
	
	public double getTQ() {
		return importance * (timeNeeded / getTimeToFinish());
	}
}
