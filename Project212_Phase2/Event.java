
public class Event implements Comparable<Event>{
private String Event_title;
private String Event_date_time;
private String Event_Location;
private String Contact_Name; 
public Event(String title ) {
	Event_title=title;
}
public Event(String title ,String Event_date_time,String Event_Location,String Contact_name) {
	this.Event_title=title;
	this.Event_date_time=Event_date_time;
	this.Event_Location=Event_Location;
	this.Contact_Name=Contact_name;	
}

public int compareTo(Event object) {
	
	return Event_title.compareTo(object.getEvent_title());   
}  


public void Display_event() {
	System.out.println("\nEvent_title: "+Event_title); 
	System.out.println("Event_date_time: "+Event_date_time);
	System.out.println("Event_Location: "+Event_Location);
	System.out.println("Contact_Name: "+Contact_Name+"\n");
	
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


















}
