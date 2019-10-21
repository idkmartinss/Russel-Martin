import java.util.Scanner;

public class DeleteLinkedList {
	
	static int counter = 0;
	
	class Node {
		int data;
		Node next;
		
		public Node (int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public Node head = null;
	public Node tail = null;
	
	public void addNode(int data) {
		Node newNode = new Node(data);
		
		if(head == null)
		{
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void delNode(int data) {
		
		Node temp = head;
		Node prev = null;
		
		if (temp != null && temp.data == data) 
        { 
			prev = head;
            head = temp.next;
            prev.next = null;
        } 

        while (temp != null && temp.data != data) 
        { 
            prev = temp; 
            temp = temp.next; 
        }     

        if (temp == null) return; 
  
        prev.next = temp.next; 
	}
	
	public void display() {
		Node current = head;
		
		if(head == null) {
			System.out.println("List is empty");
		}
		
		System.out.println("Nodes of singly linked list: ");
		while (current != null)
		{
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String a[])
	{
		DeleteLinkedList sList = new DeleteLinkedList();
		Scanner input = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop == true)
		{
			System.out.println("[a] add   [b] delete");
			System.out.print("Enter choice: ");
			
			char choice = input.next().charAt(0);
			
			switch(choice)
			{
				case 'a':
				case 'A':
				{
					System.out.println("How many elements do you want to add? ");
					int numElements = input.nextInt();
					
					System.out.print("Enter values: ");
					for(int x =0; x < numElements; x++)
					{
						sList.addNode(input.nextInt());
						counter++;
					}
					break;
				}
				
				case 'b':
				case 'B':
				{
					System.out.print("Element you want to delete: ");
					int numDel = input.nextInt();
					
					for(int x = 0; x < counter; x++) {
						sList.delNode(numDel);
						counter--;
					}
					
					sList.delNode(numDel);
					counter--;
					break;
				}
				
			}
			sList.display();
		}
	}
	
}
