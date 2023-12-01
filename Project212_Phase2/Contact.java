
public class Contact implements Comparable<Contact> {
	private String Fname;
	private String Lname;
	private String Contact_Name;
    private String phone_number;
    private String email_addres; 
    private String address;
    private String birthDay;
    private String note;
    private LinkedList<Event> contacts_events;
    
    public Contact() { 
    	
    }
    public Contact(String Fname,String Lname, String phone_number, String email_addres, String address, String birthDay,
            String note) {
        
        this.Fname = Fname;
        this.Lname = Lname;
        Contact_Name= Fname.concat(" "+Lname); 
        this.phone_number = phone_number;
        this.email_addres = email_addres;
        this.address = address;
        this.birthDay = birthDay;
        this.note = note;
        contacts_events=new LinkedList<Event>();
    }
    
 public int compareTo(Contact object) {
    	
    	return Contact_Name.compareTo(object.getContact_Name()); 
    }  
 
 public void display() {
 	System.out.println("Name: "+Fname+" "+Lname);
 	System.out.println("Phone Number: "+phone_number);
 	System.out.println("Email Address: "+email_addres);
 	System.out.println("Address: "+address);
 	System.out.println("Birthday: "+birthDay);
 	System.out.println("Notes: "+note);
 	System.out.println();
 }
 
 public String getFname() {
     return this.Fname;
 }
 public String getLname() {
     return this.Lname;
 }
 public String getContact_Name() {
     return this.Contact_Name;
 }

 public String getPhone_number() {
     return this.phone_number;
 }

 public String getEmail_addres() {
     return this.email_addres;
 }

 public String getAddress() {
     return this.address;
 }

 public String getBirthDay() {
     return this.birthDay;
 }

 public String getNote() {
     return this.note;
 }
	public void setFName(String contact_Name) {
		Fname = contact_Name;
	}
	public void setLName(String contact_Name) {
		Lname = contact_Name;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public void setEmail_addres(String email_addres) {
		this.email_addres = email_addres;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public LinkedList<Event> getContact_events() {
			return contacts_events;
	} 
		public void setContact_events(LinkedList<Event> contact_events) {
			this.contacts_events = contact_events; 
		}


}
