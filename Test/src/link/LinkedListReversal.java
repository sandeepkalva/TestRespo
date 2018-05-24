package link;

public class LinkedListReversal {

	static Node head;
	static Node current = null;
	public static void main(String[] args) {

		insertData();

		head=reverse(head,2);
		System.out.println();
		print();
		
		head=recursiveReverse(head,null);
		print();
		System.out.println("Size: "+size());
		Node middleNode = middle();
		System.out.println("Middel Node:"+middleNode.val);
	
	}

	private static void insertData() {
		System.out.println("Inserting Random Data");
//		Random r = new Random();
//		r.ints(1,30).limit(10).forEach(i->insert(i));
		for(int i =1;i<12;i++)
			insert(i);
		System.out.println("Linkedlist :");
		print();
	}

	private static Node middle() {
		Node n=head;
		for(Node n2 = head;n2!=null && n2.next!=null;n2=n2.next.next) {
			n=n.next;
		}
		return n;
		
	}

	private static int size() {
		int size =0;
		for(Node n=head ;n!=null ;n=n.next) {
			size++;
		}
		return size;
	}

	private static Node recursiveReverse(Node head,Node prev) {
		Node next,curr = head;
		if(head == null)
			return prev;
		next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
		return recursiveReverse(curr,prev);
		
	}

	private static Node reverse(Node node,int i) {
		Node prev = null ,next = null;
		int count =0;
		for(Node curr = node;curr!=null&&count<i;) {

			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			count++;
		}
		if(next!=null)
			node.next = reverse(next,i);
		return prev;
	}

	private static void reverse() {
		Node prev = null ,next = null;
		for(Node curr = head;curr!=null;) {
			System.out.println(curr.val);
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;

		}
		head = prev;

	}

	private static void print() {
	
		for(Node n = head;n!=null;n=n.next)
			System.out.print(n.val+"->");
		System.out.println("\n----------");
	}

	private static void insert(int i) {
		Node n = new Node(i, null);

		if(head == null)
			current= head = n;
		else {
			current.next = n;
			current =n;
		}
	}

}

class Node{
	int val;
	Node next;


	public Node(int val, Node next) {
		super();
		this.val = val;
		this.next = next;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}


}
