package archive;

import java.util.LinkedList;

public class Class3 {

	/**
	 * problem - find intersection of two linkedlist
	 */

	public static void main(String[] args) {

		Node firstNode = new Node(2);
		Node secondNode = new Node(9);
		Node thirdNode = new Node(8);
		firstNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		
		System.out.println(firstNode);
	}

	static class Node {
		Node next;
		int value;

		public Node(int value) {
			super();
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return String.valueOf(value) + " -> " + next.toString();
		}

	}

}
