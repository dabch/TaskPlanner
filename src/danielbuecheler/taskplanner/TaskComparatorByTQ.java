package danielbuecheler.taskplanner;

import java.util.Comparator;

public class TaskComparatorByTQ implements Comparator<Task> {
	
	// TODO update when Task gets additional attributes
	@Override
	public int compare(Task t1, Task t2) {
		return (int) (t1.getTQ() - t2.getTQ());
	}

}
