import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class PhoneBook {
	public BST<Contact>ContactBST;
	public LinkedList<Event> All_event;

	Scanner kb= new Scanner(System.in);

	public PhoneBook() {
		ContactBST=new BST<Contact>();
		All_event=new LinkedList<Event>();
	}


	public void add_contact() {
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
		if(ContactBST.checkPhone(num)|| !ContactBST.insert(c.getContact_Name(), c))
			System.out.println("\nThe contact already exists.\n"); 

		else
			System.out.println("\nContact added successfully!\n");
	}


	public void print_F() {
		System.out.print("\nEnter the First name: ");
		String name=kb.nextLine();
		ContactBST.print_fname(name);
	}

	public void search() {
		if(ContactBST.empty())
			System.out.println("\nThe BST is empty!\n");

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
			System.out.println("\n");
			ContactBST.search(input);

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
			System.out.println("\n");
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
			Contact c = search_contact(input);
			if(c!=null) {
				if(!c.getContact_events().empty()) { 

					c.getContact_events().findFirst();
					while(!c.getContact_events().Last()) {
						c.getContact_events().retrive().setContact_Name(c.getContact_Name());
						c.getContact_events().findNext();
					}
					c.getContact_events().retrive().setContact_Name(c.getContact_Name());
				}
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


	public void Schedule_event() { 

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");

		System.out.print("Enter event title: "); 
		kb.nextLine();
		String title=kb.nextLine(); 
		System.out.print("Enter contact name: "); 
		String name=kb.nextLine();

		System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
		String date=kb.nextLine();
		try {
			Date eventDateTime = dateFormat.parse(date);

			// Validate year, month, day, hours, and minutes
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(eventDateTime);

			int enteredYear = calendar.get(Calendar.YEAR);
			if (enteredYear < 2023 || enteredYear > 2030) {
				throw new ParseException("Invalid year. Please enter a year between 2023 and 2030.", 6);
			}
		} catch (ParseException e) {
			// Handle parsing exception (invalid input format, year, month, day, hours, or minutes)
			System.out.println("\n"+e.getMessage()+"\n");
			return;
		}

		System.out.print("Enter event location: ");
		String location=kb.nextLine();

		Event e = new Event(title, date, location, name, "Appointment"); 
		//boolean flag=true;
		Event exist = search_event(e.getEvent_title());//to check if the event is already exists
		Contact c=search_contact(name);// to check if the contact is in the contact BST
		boolean is_conflict=conflict(e, c); // to check if there is a conflict in date and time
		//if(type.equalsIgnoreCase("Appointment")) 
		//	if( exist!=null) 
		//flag=false;

		if(exist==null&&ContactBST.findkey(e.getContact_Name())&&!is_conflict) { 
			All_event.insert_Event(e);
			c.getContact_events().insert_Event(e);
			e.getEvents_contacts().insert_Contact(c);
			System.out.println("\nEvent scheduled successfully! \n");
		}
		else {
			if(!ContactBST.findkey(e.getContact_Name())) 
				System.out.println("\nContact not fount");
			if(is_conflict)
				System.out.println("\nthe Contact has conflict");
			if(exist!= null)
				System.out.println("\nThe event has same title");
			System.out.println("\nCannot add event.\n");
		}

	}
	public Contact search_contact(String name) {
		if(ContactBST.empty())
			return null;

		boolean found=ContactBST.findkey(name);
		if(found)
			return ContactBST.retrieve();
		return null;
	}
	public void Schedule_event1() { 
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		String name;
		Event e1;
		System.out.println("\nEnter type: ");
		System.out.println("1. event");
		System.out.println("2. appointment");
		System.out.print("Enter your choice: "); 
		int choice = kb.nextInt();
		String type="";
		switch(choice) {
		case 1:
			type="Event";
			break; 
		case 2:
			type="Appointment";
			break;

		default:
			System.out.println("Wrong number");


		}
		if(type.equalsIgnoreCase("Appointment") ) {
			Schedule_event();
			return;
		}

		System.out.print("Enter event title: "); 
		kb.nextLine();
		String title=kb.nextLine(); 
		e1 = new Event(title);
		do {
			System.out.print("Enter contact name (Write "+"done"+" to Stop): "); 
			name=kb.nextLine();


			if(ContactBST.findkey(name)) {
				Contact c1 = search_contact(name);
				e1.getContact_Names().insert(c1.getContact_Name());
				if(name.equalsIgnoreCase("done"));
			} 
			else if(name.equalsIgnoreCase("done"))
				System.out.println();

			else
				System.out.println("Contact does not exist.");
		}while(!name.equalsIgnoreCase("done"));

		System.out.print("Enter event date and time (MM/DD/YYYY HH:MM): ");
		String date=kb.nextLine();
		try {
			Date eventDateTime = dateFormat.parse(date);

			// Validate year, month, day, hours, and minutes
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(eventDateTime);

			int enteredYear = calendar.get(Calendar.YEAR);
			if (enteredYear < 2023 || enteredYear > 2030) {
				throw new ParseException("Invalid year. Please enter a year between 2023 and 2030.", 6);
			}
		} catch (ParseException e) {
			// Handle parsing exception (invalid input format, year, month, day, hours, or minutes)
			System.out.println("\n"+e.getMessage()+"\n");
			return;
		}

		System.out.print("Enter event location: ");
		String location=kb.nextLine();

		Event e = new Event(title, date, location, e1.getContact_Names(), type); 
		Event exist = search_event(e.getEvent_title()); //to check if the event is already exists
		e.getContact_Names().findFirst();
		if(e.getContact_Names().empty()) {
			System.out.println("\nYou don't Enter any Name\n");
			return;
		}
		while(!e.getContact_Names().Last()) {
			Contact c= search_contact(e.getContact_Names().retrive()); 
			boolean is_conflict=conflict(e, c);
			if(!is_conflict) {
				c.getContact_events().insert_Event(e);
				e.getEvents_contacts().insert_Contact(c);
			}
			else {
				System.out.println("\n"+c.getContact_Name()+" Has a conflict with this Event.");
			}
			e.getContact_Names().findNext();

		}
		Contact c= search_contact(e.getContact_Names().retrive());
		boolean is_conflict=conflict(e, c);
		if(!is_conflict) { 
			c.getContact_events().insert_Event(e);
			e.getEvents_contacts().insert_Contact(c);
		}
		else {
			System.out.println("\n"+c.getContact_Name()+" Has a conflict with this Event.");
		}

		if(!e.getEvents_contacts().empty()&&exist==null) { 
			All_event.insert_Event(e);
			System.out.println("\nEvent scheduled successfully! \n");
		}

		else {
			if(exist!= null)
				System.out.println("\nThe event has same title");
			System.out.println("Cannot add event.\n");
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



	public boolean conflict(Event e, Contact c) {
		if(c==null)
			return true; 

		LinkedList<Event>contacts_events=c.getContact_events();//to get the linked list event of the contact by name

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

	public void Delete_contact() {
		System.out.print("Enter the contact name: ");
		String name=kb.nextLine();
		if(ContactBST.empty())
			System.out.println("\nThe Phonebook is empty\n");
		else {
			if(!ContactBST.findkey(name)) {
				System.out.println("\nThe contact does not exists!.\n");
				return;
			}

			Contact c = search_contact(name);
			if(c.getContact_events().empty()) {
				ContactBST.removeKey(name); 
				return;
			}
			All_event.findFirst();
			while(!All_event.Last()) {
				if(All_event.retrive().getType().equalsIgnoreCase("Appointment")) {
					if(All_event.retrive().getContact_Name().equalsIgnoreCase(name)) {
						All_event.remove();
					}
					if(!All_event.Last())//to not move the current to null if the element is the last.
						All_event.findNext();
				}
				else {
					All_event.retrive().getContact_Names().findFirst();
					while(!All_event.retrive().getContact_Names().Last()) {
						if(All_event.retrive().getContact_Names().retrive().equalsIgnoreCase(name)) {
							All_event.retrive().getContact_Names().remove();
						}
						if(!All_event.retrive().getContact_Names().Last()) {
							All_event.retrive().getContact_Names().findNext();
						}
					}
					if(All_event.retrive().getContact_Names().retrive().equalsIgnoreCase(name)) {
						All_event.retrive().getContact_Names().remove();
					}
					if(All_event.retrive().Contact_Names.empty())
						All_event.remove();
				}
				if(!All_event.Last())//to not move the current to null if the element is the last.
					All_event.findNext();
			}
			if(All_event.retrive().getType().equalsIgnoreCase("Appointment")) {
				All_event.remove();
				if(!All_event.Last())//to not move the current to null if the element is the last.
					All_event.findNext();
			}
			else {
				All_event.retrive().getContact_Names().findFirst();
				while(!All_event.retrive().getContact_Names().Last()) {
					if(All_event.retrive().getContact_Names().retrive().equalsIgnoreCase(name)) {
						All_event.retrive().getContact_Names().remove();
					}
					if(!All_event.retrive().getContact_Names().Last()) {
						All_event.retrive().getContact_Names().findNext();
					}
				}
				if(All_event.retrive().getContact_Names().retrive().equalsIgnoreCase(name)) {
					All_event.retrive().getContact_Names().remove();
				}
				if(All_event.retrive().Contact_Names.empty())
					All_event.remove();

				if(ContactBST.findkey(name)) {
					System.out.println("\nThe Contact has deleted\n");
					ContactBST.removeKey(name);
				}
			}

		}
	}


}
