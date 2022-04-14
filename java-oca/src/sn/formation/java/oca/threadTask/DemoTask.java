package sn.formation.java.oca.threadTask;

public class DemoTask {
	
	public static void main(String[] args) {
		
		// implementation de l'interface Runnable
		java.lang.Runnable task = () ->  System.out.println("Id : " + Thread.currentThread().getId() + " | Nom : " + Thread.currentThread().getName() + " | Priority : " + Thread.currentThread().getPriority() + " : je suis une tâche");
		// exécuter la tâche
		task.run();
		
		// construire un autre thread
		Thread t = new Thread(task);
		t.start();
		
		if (t.isDaemon())
			t.start();
		else {
			System.out.println("Id : " + Thread.currentThread().getId() + " | Nom : " + Thread.currentThread().getName() + " | Priority : " + Thread.currentThread().getPriority() + " : je suis une tâche");
		}
	}
}
