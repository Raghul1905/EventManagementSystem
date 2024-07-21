public class Participant {
	private int participant_id;
	private String name;
	private String email;
	private String phone_number;
	public Participant(String name, String email, String phone_number) {
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
	}
	public int getParticipant_id() {
		return participant_id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
}
