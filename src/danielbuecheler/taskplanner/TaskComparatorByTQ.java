package danielbuecheler.taskplanner;

import java.util.Comparator;

/**
 * This Comparator compares Tasks by their so-called TQ. If you ought to do t1
 * before t2, the return value will be positive, if t2 should be done before t1
 * it will be negative.
 * 
 * @author Daniel Bücheler / Marvin Heinzelmann
 */
public class TaskComparatorByTQ implements Comparator<Task> {

	// TODO update when Task gets additional attributes
	@Override
	public int compare(Task t1, Task t2) {
		return (int) ((t2.getTQ() - t1.getTQ()) * 10000);
	}

}
