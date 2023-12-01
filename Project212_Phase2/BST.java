
public class BST<T> {
	BSTNode<T> root, current;
	
	public BST() {
		root = current = null; 
	}
	public boolean empty() {
		return root == null; 
	}
	public boolean full() {
		return false; 
	} 
	public T retrieve () {
		return current.data;
	}



	public boolean findkey(String tkey) {
		BSTNode<T> p =root;
		BSTNode<T> q =root;
		if(empty())
			return false;
		while(p != null) {
			q = p;
			if(tkey.compareToIgnoreCase(p.key) == 0) {
				current = p;
				return true;
			}
			else if(tkey.compareToIgnoreCase(p.key) < 0)
				p = p.left;
			else p = p.right;
		} 
		current = q;
		return false;
	}




	public boolean insert(String k, T val) { 
		BSTNode<T> p, q = current;
		if(findkey(k)) {
			current = q;  
			return false;  
		}
		p = new BSTNode<T>(k, val);
		if (empty()) {
			root = current = p;
			return true;
		} 
		else {

			if (k.compareToIgnoreCase(current.key) <0 )
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}


	}




	public boolean checkPhone(String num) {
		if(root==null)
			return false;

		return checkPhone((BSTNode<Contact>)root, num); 
	}




	private boolean checkPhone(BSTNode<Contact>p,String num) {
		if(p==null)
			return false;
		boolean Exist_left= checkPhone(p.left, num); 
		if(Exist_left)
			return true;

		if(p.data.getPhone_number().equalsIgnoreCase(num))
			return true;

		return checkPhone(p.right, num); 
	}



	public void print_fname(String name) {
		if(root==null) {
			System.out.println("The BST is empty");
			return;
		}
		print_fname((BSTNode<Contact>)root,name); 
	}



	private void print_fname(BSTNode<Contact>p,String name) {
		if(p==null) {
			return;

		}
		print_fname(p.left,name);
		if(p.data.getFname().equalsIgnoreCase(name)) {
			p.data.display();

		}


		print_fname(p.right,name);

	}
	
	
	
	public void search(String info) {
		if(root==null) {
			System.out.println("The BST is empty");
			return;
		}
		search((BSTNode<Contact>)root,info); 
	}

	private void search(BSTNode<Contact>p,String info) {
		if(p==null) {
			return;

		}
		search(p.left,info);
		if(info.equalsIgnoreCase(p.data.getContact_Name())||
				info.equalsIgnoreCase(p.data.getPhone_number())||	
				info.equalsIgnoreCase(p.data.getAddress())||
				info.equalsIgnoreCase(p.data.getBirthDay())||
				info.equalsIgnoreCase(p.data.getEmail_addres())) {
			p.data.display(); 

		}


		search(p.right,info);

	}
	
	

	




	public boolean removeKey(String k) {
		// Search for k
		String k1 = k;
		BSTNode<T> p = root;
		BSTNode<T> q = null; // Parent of p
		while (p != null) {
			if (k1.compareToIgnoreCase( p.key) <0) {
				q =p;
				p = p.left;
			}
			else if (k1.compareToIgnoreCase( p.key) > 0) {
				q = p;
				p = p.right;
			}
			else { 
				// Found the key
				// Check the three cases
				if ((p.left != null) && (p.right != null)) { 
					// Case 3: two children
					// Search for the min in the right subtree
					BSTNode<T> min = p.right;
					q = p;
					while (min.left != null) {
						q = min;
						min = min.left;
					}
					p.key = min.key;
					p.data = min.data;
					k1 = min.key;
					p = min;
					// Now fall back to either case 1 or 2
				}
			}
			// The subtree rooted at p will change here
			if (p.left != null) { // One child
				p = p.left;
			} else { // One or no children
				p = p.right;
			}
			if (q == null) { // No parent for p, root must change
				root = p;
			} else {
				if (k1.compareToIgnoreCase( q.key) <0) {
					q.left = p;
				} else {
					q.right = p;
				}
			}
			current = root;
			return true;
		}

		return false; // Not found
	}

	






}





