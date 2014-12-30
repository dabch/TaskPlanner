package danielbuecheler.taskplanner.test

import org.junit;
import static org.junit.Assert.*;

class TaskTest{
	Task task;
	
	@Test
	public void testTaskConstructor(){
		task = new Task("Test-Task", 50, 2, Calendar.getInstance());
		assertEquals(task.name, "Test-Task");
	}
}
