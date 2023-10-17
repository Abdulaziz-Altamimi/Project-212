import java.util.Scanner;
public class Phonebook {
	Scanner kb= new Scanner(System.in);
	private LinkedList<Contact> contactList;
	private LinkedList<Event> All_event; 


	Phonebook(){
		contactList=new LinkedList<Contact>();
		All_event=new LinkedList<Event>();
	}
	Phonebook(LinkedList<Contact> contacts){
		contactList= contacts;
	}

	/*
	 * to check if the new contact is already exists in the phonebook
	 */
	public boolean is_uniqe(Contact c) {
		if(contactList.empty())
			return true;
		contactList.findFirst();
		while(!contactList.Last()) {

			if(contactList.retrive().getContact_Name().equalsIgnoreCase(c.getContact_Name()) || 
					contactList.retrive().getPhone_number().equalsIgnoreCase(c.getPhone_number()) )
				return false;
			contactList.findNext();
		}
		if(contactList.retrive().getContact_Name().equalsIgnoreCase(c.getContact_Name()) || 
				contactList.retrive().getPhone_number().equalsIgnoreCase(c.getPhone_number()) )
			return false;
		return true; 	
	}


	public void insert_contact() {
		System.out.print("Enter the contact's name: ");
		String Fname=kb.next();
		String Lname=kb.next();
		System.out.print("Enter the contact's phone number: ");
		String num=kb.next();
		System.out.print("Enter the contact's email address: ");
		String EAddres=kb.next(); 
		System.out.print("Enter the contact's address: ");
		String Address=kb.nextLine(); 
		Address=kb.nextLine(); 
		System.out.print("Enter the contact's birthday: ");
		String BirthDay=kb.next();
		System.out.print("Enter any notes for the contact: "); 
		String notes=kb.nextLine();
		notes=kb.nextLine();
		Contact c = new Contact(Fname, Lname,num,EAddres,Address,BirthDay,notes);
		if(!is_uniqe(c)) {//to check if the contact already exists.
			System.out.println("contact already exists!");
			return;
		}
		contactList.insert(c);
		System.out.println("\nContact added successfully!\n");
	}


	public void Schedule_event() { 
		System.out.print("Enter event title: "); 
		String title=kb.nextLine(); 
		System.out.print("Enter contact name: "); 
		String name=kb.nextLine();

		System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
		String date=kb.nextLine();

		System.out.print("Enter event location: ");
		String location=kb.nextLine();

		Event e = new Event(title, date, location, name);
		Event exist = search_event(e.getEvent_title());//to check if the event is already exists
		Contact c=search_contact(name);// to check if the contact is in the contact list
		boolean is_conflict=conflict(e, c); // to check if there is a conflict in date and time
		if(exist==null&&contactList.is_exist(e.getContact_Name())&&!is_conflict) {
			All_event.insert_Event(e);
			c.getContact_events().insert_Event(e);
			System.out.println("\nEvent scheduled successfully! \n");
		}

		else
			System.out.println("\nCannot add event.\n");

	}



	public void search_contact() {
		if(contactList.empty())
			System.out.println("\nThe list is empty!\n");

		else {
			System.out.println("\nEnter search criteria: ");
			System.out.println("1. Name");
			System.out.println("2. Phone Number");
			System.out.println("3. Email Address");
			System.out.println("4. Address");
			System.out.println("5. Birthday");
			System.out.print("Enter your choice: ");
			int choice = kb.nextInt();
			String input="";
			switch(choice){
			case 1: 
				System.out.print("Enter the contact name: ");
				kb.nextLine();
				input =kb.nextLine();
				break;
			case 2:
				System.out.print("Enter the contact Phone number: ");
				input = kb.next();
				break;
			case 3:
				System.out.print("Enter the contact Email Address: ");
				input = kb.next();
				break;
			case 4:
				System.out.print("Enter the contact Address: ");
				kb.nextLine();
				input = kb.nextLine();
				break;
			case 5:
				System.out.print("Enter the contact Birthday: ");
				input = kb.next();
				break;

			}
			contactList.findFirst(); 
			while(!contactList.Last()) {
				if(input.equalsIgnoreCase(contactList.retrive().getAddress()) ||
						input.equalsIgnoreCase(contactList.retrive().getBirthDay()) ||
						input.equalsIgnoreCase(contactList.retrive().getContact_Name()) ||
						input.equalsIgnoreCase(contactList.retrive().getEmail_addres())|| 
						input.equalsIgnoreCase(contactList.retrive().getPhone_number())) { 
					System.out.println("\nContact found!\n"); 
					contactList.retrive().display(); 
				}

				contactList.findNext();
			}
			if(input.equalsIgnoreCase(contactList.retrive().getAddress()) ||
					input.equalsIgnoreCase(contactList.retrive().getBirthDay()) ||
					input.equalsIgnoreCase(contactList.retrive().getContact_Name()) ||
					input.equalsIgnoreCase(contactList.retrive().getEmail_addres())|| 
					input.equalsIgnoreCase(contactList.retrive().getPhone_number())) {
				System.out.println("\nContact found!\n");
				contactList.retrive().display(); 
			}
			if(!contactList.is_exist(input))
				System.out.println("\ncontact Not found\n");		
		}


	}

	/*
	 * searches contacts by name
	 */
	public Contact search_contact(String name) {
		if(contactList.empty())
			return null; 

		else {

			contactList.findFirst(); 
			while(!contactList.Last()) {
				if(name.equalsIgnoreCase(contactList.retrive().getContact_Name()) ) {	
					return contactList.retrive();
				}

				contactList.findNext();
			}
			if(name.equalsIgnoreCase(contactList.retrive().getContact_Name()) ) 	
				return contactList.retrive();

			return null; 
		}



	}

	public Event search_event(String Title) {
		if(All_event.empty()) 
			return null; 

		else {

			All_event.findFirst(); 
			while(!All_event.Last()) {
				if(Title.equalsIgnoreCase(All_event.retrive().getContact_Name()) ||
						Title.equalsIgnoreCase(All_event.retrive().getEvent_title()) ) {	
					return All_event.retrive();
				}

				All_event.findNext();
			}
			if(Title.equalsIgnoreCase(All_event.retrive().getContact_Name()) ||
					Title.equalsIgnoreCase(All_event.retrive().getEvent_title()) ) 	 
				return All_event.retrive();

			return null; 
		}
	}


	public void print_by_Fname() {
		System.out.print("\nEnter the First name: ");
		String name=kb.nextLine();
		if(contactList.empty())
			System.out.println("\nThe list is empty!\n");
		else {
			contactList.findFirst(); 
			while(!contactList.Last()) {
				if(name.equalsIgnoreCase(contactList.retrive().getFname())) {
					System.out.println("\nContact found!\n");
					contactList.retrive().display(); 
				}

				contactList.findNext();
			}
			if(name.equalsIgnoreCase(contactList.retrive().getFname())) {
				System.out.println("\nContact found!\n");
				contactList.retrive().display(); 
			}

		}


	}
	public void Print_All_Events() {
		if(All_event.empty())
			System.out.println("\nThere is no event\n ");
		else {
			All_event.findFirst(); 
			while(!All_event.Last()) {
				All_event.retrive().Display_event(); 
				All_event.findNext();
			}
			All_event.retrive().Display_event(); 
		}		
	}





	public void Delete_contact() {
		System.out.print("\nEnter the contact Name: ");
		String name=kb.nextLine();
		if(contactList.empty())
			System.out.println("\nThe Phonebook is empty\n");
		else {
			contactList.findFirst();
			while(!contactList.Last()){
				if(name.equalsIgnoreCase(contactList.retrive().getContact_Name())) {
					contactList.remove();
					System.out.println("\n"+name+" has been deleted\n"); 
				}
				if(!contactList.Last())//to not move the current to null if the element is the last.
					contactList.findNext();
			}
			if(name.equalsIgnoreCase(contactList.retrive().getContact_Name())) {
				contactList.remove();
				System.out.println(name+" has been deleted\n");
			}
			/*
			 * to delete the events stored in the contact.
			 */
			if(!All_event.empty()) {
				All_event.findFirst();
				while(!All_event.Last()) {
					if(All_event.retrive().getContact_Name().equalsIgnoreCase(name))
						All_event.remove();
					if(!All_event.Last())//to not move the current to null if the element is the last.
						All_event.findNext();
				}
				if(All_event.retrive().getContact_Name().equalsIgnoreCase(name))
					All_event.remove();
			}
		}

	}
	public void print_event_details( ) {
		if(All_event.empty()) 
			System.out.println("\nthere is no events!\n");



		else {
			System.out.println("\nEnter search criteria: ");
			System.out.println("1. contact name");
			System.out.println("2. Event tittle");
			System.out.print("Enter your choice: "); 
			int choice = kb.nextInt();
			String input="";
			switch(choice) {
			case 1:kb.nextLine();
			System.out.print("\nEnter the contact name: ");
			input=kb.nextLine();
			break; 



			case 2:kb.nextLine();
			System.out.print("\nEnter the Event Title: ");
			input=kb.nextLine();
			break;

			default:
				System.out.println("Wrong number");


			}

			All_event.findFirst();
			while(!All_event.Last()) {
				if(input.equalsIgnoreCase(All_event.retrive().getEvent_title())|| 
						input.equalsIgnoreCase(All_event.retrive().getContact_Name())) {
					System.out.println("\nEvent Found!\n");
					All_event.retrive().Display_event();
				}

				All_event.findNext();

			}
			if(input.equalsIgnoreCase(All_event.retrive().getEvent_title())|| 
					input.equalsIgnoreCase(All_event.retrive().getContact_Name())) {
				System.out.println("\nEvent Found!\n");
				All_event.retrive().Display_event();
			}




		}
	}
	/*
	 * this method returns a linkedlist of event that the contact has.
	 */

	public LinkedList<Event> Get_events_in_contacts(String name){
		Contact c=search_contact(name);//to search if the contact exist in the list.
		if(c!=null)
			return c.getContact_events();
		return new LinkedList<Event>();
	}


	public boolean conflict(Event e, Contact c) {
		if(c==null)
			return true;

		LinkedList<Event>contacts_events=Get_events_in_contacts(c.getContact_Name());//to get the linked list event of the contact by name

		if(contacts_events.empty())
			return false;

		contacts_events.findFirst();
		while(!contacts_events.Last()) {
			if(e.getEvent_date_time().equalsIgnoreCase(contacts_events.retrive().getEvent_date_time()))
				return true;
			contacts_events.findNext();
		}
		if(e.getEvent_date_time().equalsIgnoreCase(contacts_events.retrive().getEvent_date_time()))
			return true;
		return false;

	}







}
