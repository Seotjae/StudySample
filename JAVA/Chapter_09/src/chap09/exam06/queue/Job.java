package chap09.exam06.queue;

public class Job {
	
	private String command;
	private String to;
	
	public Job(String command, String to) {
		this.command = command;
		this.to = to;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	

}
