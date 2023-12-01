
public class LinkedList<T> {
	private Node<T> head;
	private Node<T> current;



	public LinkedList() {
		head=current=null;
	}


	public boolean Last() {

		return current.next==null;
	}

	public boolean Full() {

		return false;
	}

	public boolean empty() {

		return head==null;
	}

	public void findFirst() {
		current=head;

	}

	public void findNext() {
		current=current.next;

	}

	public T retrive() {

		return current.data;
	}

	public void update(T Data) {
		current.data= Data;

	}
	public void insert (T val) {
        Node<T> tmp;
        if (empty()) {
            current = head = new Node<T> (val);
        }
        else {
            tmp = current.next;
            current.next = new Node<T> (val);
            current = current.next;
            current.next = tmp;
        }
    }

	public void insert_Contact(T Data) { 
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


}
