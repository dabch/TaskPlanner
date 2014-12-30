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
		this.importance = wichtigkeitProzent / 100;
		this.timeNeeded = zeitaufwandStd * 60;
		this.deadline = deadline;
		this.finished = 0;
	}

	/**
	 * @return name of the task
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return Zeit, die noch verbleibt bis zur Deadline in Minuten
	 */
	public long getTimeToFinish() {
		Date dl = deadline.getTime();
		Date now = Calendar.getInstance().getTime();
		return (dl.getTime() - now.getTime()) / 60000;
	}

	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy HH:mm");
		String returnString = this.getClass().getName() + "[name=" + name + ",beschreibung=" + description
				+ ",zeitaufwand=" + timeNeeded + ",deadline=" + sdf.format(deadline.getTime()) + ",wichtigkeit="
				+ importance + ",fertigstellung=" + finished + "]";
		return returnString;
	}

	public double getTQ() {
		double ttf = getTimeToFinish();
		double urgent = timeNeeded / ttf;
		double tq = importance * (urgent);
		return tq;
	}
}
