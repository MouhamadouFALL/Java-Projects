package sn.formation.java.oca.threadTask;

public class DemoTask {
	
	public static void main(String[] args) {
		
		// implementation de l'interface Runnable
		java.lang.Runnable task = () ->  System.out.println("Id : " + Thread.currentThread().getId() + " | Nom : " + Thread.currentThread().getName() + " | Priority : " + Thread.currentThread().getPriority() + " : I'm a task in a Thread");
		// ex�cuter la t�che
		task.run();
		
		// construire un autre thread
		Thread t = new Thread(task);
		t.start();
		
		if (t.isDaemon()) {
			t.start();
			System.out.println("Nom : " + t.currentThread().getName() + " | I'm not Daemon type");
		}
	}
}
