
public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> current;



	public LinkedList() {
		head=current=null;
	}

	@Override
	public boolean Last() {

		return current.next==null;
	}
	@Override
	public boolean Full() {

		return false;
	}
	@Override
	public boolean empty() {

		return head==null;
	}
	@Override
	public void findFirst() {
		current=head;

	}
	@Override
	public void findNext() {
		current=current.next;

	}
	@Override
	public T retrive() {

		return current.data;
	}
	@Override
	public void ubdate(T Data) {
		current.data= Data;

	}
	/*
	 *this is an insert method that inserts a new contact to the phonebook in order by name
	 */
	public void insert(T Data) {
		Node<T> temp= new Node<T>(Data);
		
		if(empty())
			head=current=temp;

		else {
			//if the head is smaller than the data we make the date head
			if(((Contact)Data).compareTo((Contact)head.data)<0) {
				temp.next=head;
				head=temp;
				return;
			} 
			else {
				Node<T> counter=head;
				Node<T> placeHolder=null;//to get the place of which we want to insert
				while(counter!=null&& ((Contact)counter.data).compareTo((Contact)Data)<=0) {
					placeHolder=counter;
					counter=counter.next; 
				}
				placeHolder.next=temp;
				temp.next=counter; 
				current=temp;//to move the current to the new added contact
				
			}

		}

	}
	public void insert_Event(T Data) {
		Node<T> temp= new Node<T>(Data);
		
		if(empty())
			head=current=temp; 

		else {
			//if the head is smaller than the data we make the date head
			if(((Event)Data).compareTo((Event)head.data)<0) {
				temp.next=head;
				head=temp;
				return;
			} 
			else {
				Node<T> counter=head;
				Node<T> placeHolder=null;//to get the place of which we want to insert
				while(counter!=null&& ((Event)counter.data).compareTo((Event)Data)<=0) {
					placeHolder=counter;
					counter=counter.next; 
				}
				placeHolder.next=temp;
				temp.next=counter; 
				current=temp;//to move the current to the new added contact 
				
			}

		}

	}
	@Override
	/*
	 * this method will delete a contact from the phonebook
	 * and if the contact that we removed is the last on the list the current will go back to the head
	 */
	public void remove() {
		if (current == head) {
			head = head.next;
		}
		else {
			Node<T> tmp = head;
			while (tmp.next != current)
				tmp = tmp.next;
			tmp.next = current.next;
		}
		if (current.next == null)
			current = head;
		else
			current = current.next;
	}
	/*
	 * this method will search for a contact by either the name,address,email address,birthday and phone number 
	 * and return true if the contact is found, false otherwise
	 */
	public boolean is_exist(String info) {
		Node<T> tmp = current;
        current = head;

		while(current!=null) {
			Contact temp= (Contact)current.data;
			if(info.equalsIgnoreCase(temp.getAddress()) ||
					info.equalsIgnoreCase(temp.getBirthDay()) ||
					info.equalsIgnoreCase(temp.getContact_Name()) ||
					info.equalsIgnoreCase(temp.getEmail_addres())|| 
					info.equalsIgnoreCase(temp.getPhone_number()))
				return true;
            current = current.next;
		}
		 current = tmp;
	        return false; 
	}		
	}





