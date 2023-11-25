
public class test {

	public static void main(String[] args) {
		Contact c1 = new Contact("ahmad","Khalid ","123"," "," "," "," ");
		Contact c2 = new Contact("ahmad","Bdr ","23","23"," "," "," ");
		Contact c3 = new Contact("ahmad","Ali ","56","56"," "," "," ");
		Contact c4 = new Contact("ahmad","Z","78","78",""," "," ");
		Contact c5 = new Contact("ahmad","Y","78","78",""," "," ");
		
		BST<Contact> b1 = new BST<Contact>();
		b1.insert("ahmad Khalid", c1);
		b1.insert("ahmad Bdr", c2);
		b1.insert("ahmad Ali", c3);
		b1.insert("ahmad Z", c4);
		b1.insert("ahmad Y", c5);
		//System.out.println(b1.checkPhone("78"));
		//b1.print_fname("ahmad");
		b1.removeKey("ahmad Khalid");
		b1.print_fname("ahmad");
		//b1.p();

	}

}
