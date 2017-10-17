package com.vidushi.takshila.linkedlist;



class Node<T> {
	
	Node next;
	T data;
	
	Node(T data, Node node){
			this.next = node;
			this.data = data;
    }
}


public class SinglyLinkedlist implements IList{
	
        private Node head = null;
        private Node rear;
		public void insertAtFirst(Object data) {
			if(head == null) {
				head = new Node(data,null);
				return;
			  }
			Node node = head;
			head= new Node(data,node);
			
		}
		
		public void insertAtIndex(Object data, int index) {
			if(head == null) {
				head = new Node(data,null);
				return;
			  }

		}
		
		public void insertInLast(Object data) {
			if(head == null) {
				head = new Node(data,null);
				rear = head;
			  }else{
				 rear.next =  new Node(data,null);
			  }
			
		}
		
		public void removeFirst() {
			
			if(head==null){
				System.out.println("nothing to be removed");
				return;
			}
			head = head.next;
			
		}
		
		public void removeLast() {
			if(rear !=null){
				rear.next =null;
			}
			
		}
		

		
		public Object get(int index) {
			
			return null;
		}

		public void traverse() {
	     if(head == null){
	    	 System.out.println("list is empty");
	    	 return;
	     }
			while(head.next!=null){
				System.out.println("data is"+head.data);
				head = head.next;
			}
		}

	
	
	
}


