
public class Event implements Comparable<Event>{
	private String Event_title;
	private String Event_date_time;
	private String Event_Location;
	private String Contact_Name;
	public LinkedList<String> Contact_Names=new LinkedList<String>(); 
	private String Type;
	private LinkedList<Contact> events_contacts; 
	
	public Event(String title ) {
		Event_title=title;
	}
	public Event(String title ,String Event_date_time,String Event_Location,LinkedList<String> Contact_name,String Type) {
		this.Event_title=title;
		this.Event_date_time=Event_date_time;
		this.Event_Location=Event_Location;
		this.Contact_Names=Contact_name; 
		this.Type=Type;
		events_contacts= new LinkedList<Contact>();
	}
	public Event(String title ,String Event_date_time,String Event_Location,String Contact_name,String Type) {
		this.Event_title=title;
		this.Event_date_time=Event_date_time;
		this.Event_Location=Event_Location;
		this.Contact_Name=Contact_name;  
		this.Type=Type;
		events_contacts= new LinkedList<Contact>();
	}

	public int compareTo(Event object) {

		return Event_title.compareTo(object.getEvent_title());   
	}  


	public void Display_event() {
		System.out.println("\nEvent_title: "+Event_title); 
		System.out.println("Event_date_time: "+Event_date_time);
		System.out.println("Event_Location: "+Event_Location);
		//System.out.println("Contact_Name: "+Contact_Name+"\n");
		if(Contact_Names.empty())
			System.out.println("Contact_Name: "+Contact_Name+"\n");
		else {
			Contact_Names.findFirst();
			while(!Contact_Names.Last()) {
				System.out.println("Contact_Name: "+Contact_Names.retrive());
				Contact_Names.findNext();
			}
			if(Contact_Names.retrive()!=null)
				System.out.println("Contact_Name: "+Contact_Names.retrive());
			
		}

	}
	public String getEvent_title() {
		return Event_title;
	}
	public void setEvent_title(String event_title) {
		Event_title = event_title;
	}
	public String getEvent_date_time() {
		return Event_date_time;
	}
	public void setEvent_date_time(String Event_date_time) {
		this.Event_date_time = Event_date_time;
	}

	public String getEvent_Location() {
		return Event_Location;
	}
	public void setEvent_Location(String event_Location) {
		Event_Location = event_Location;
	}
	public String getContact_Name() {
		return Contact_Name;
	}
	public void setContact_Name(String contact_name) {
		Contact_Name = contact_name;
	}
	public LinkedList<String> getContact_Names() {
		return Contact_Names;
	}
	public void setContact_Names(LinkedList<String> contact_name) { 
		Contact_Names = contact_name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public LinkedList<Contact> getEvents_contacts() {
		return events_contacts;
	}
	public void setEvents_contacts(LinkedList<Contact> events_contacts) {
		this.events_contacts = events_contacts;
	}
	


}
