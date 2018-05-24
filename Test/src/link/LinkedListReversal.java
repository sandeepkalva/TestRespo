package link;

public class LinkedListReversal {

	static Node head;
	static Node current = null;
	public static void main(String[] args) {

		insert(1);
		insert(2);
		insert(3);
		insert(4);
		insert(5);

//		print();
//
//		head=reverse(head,2);
//		System.out.println();
//		print();
//		
		head=recursiveReverse(head,null);
		print();
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
