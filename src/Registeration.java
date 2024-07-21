public class Registeration {

	private int event_id;
	private int participant_id;
	private String date;
	public Registeration(int event_id, int participant_id, String date) {

		this.event_id = event_id;
		this.participant_id = participant_id;
		this.date = date;

	}

	public int getEvent_id() {
		return this.event_id;
	}
	public int getParticipant_id() {
		return this.participant_id;
	}
	public String getDate() {
		return this.date;
	}

	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}
	public void setDate(String date) {
		this.date = date;
	}



}
