package TrieTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrieTreeLinkedList {

	private class Node {
		
		LinkedList<Node> nextNodes;
		char letter;
		boolean isThisAWord;
		
		Node() {
			letter = (char) 0;
			nextNodes = new LinkedList();
			isThisAWord = false;
		}
		
		Node(char letter) {
			this.letter = letter;
			nextNodes = new LinkedList();
			isThisAWord = false;
		}
		
		void setIsThisWord(boolean x) {
			isThisAWord = x;
		}
		
		Node getNodes(char c) {
			return thisCharNodes(c);
		}
		
		LinkedList<Node> getNextNodes() {
			return nextNodes;
		}
		
		void setNode(Node node) {
			nextNodes.add(node);
		}
		
		Node getNode(int i) {
			return nextNodes.get(i);
		}
		
		int length() {
			return nextNodes.size();
		}
		
		Node doYouKnowThisWord(char c) {
			if(letter != (char) 0) if(letter == c) return this; 
			return thisCharNodes(c);
		}
		
		boolean hasChild() {
			if(nextNodes.size() > 0) return true;
			return false;
		}
		
		boolean hasMoreThanOneChild() {
			if(nextNodes.size() > 1) return true;
			return false;
		}
		
		void setLetter(char letter) {
			this.letter = letter;
		}
		
		void remove(Node node) {
			nextNodes.remove(node);
		}
		
		boolean equals(Node node) {
			return letter == node.letter;
		}

		public String toString() {
			return Character.toString(letter);
		}
		
		private Node thisCharNodes(char c) {
			for(int i = 0; i < nextNodes.size(); i++) {
				if(nextNodes.get(i).letter == c) return nextNodes.get(i);
			}
			return null;
		}
	}
	
	private Node root;
	int length;
	static int index;
	
	public TrieTreeLinkedList() {
		root = new Node();
		length = 0;
		index = 0;
	}
	
	void DeleteAll() {
		root = new Node();
		length = 0;
		index = 0;
	} 
	// kasuje całe drzewo, przywraca stan pusty
	
	boolean AddString( String str ) {
		Node node = insertWord(root, str, 0);
		if(node != null) {
			length++;
			return true;
		}
		else {
			return false;
		}
	}
	// dodaje nowy napis do drzewa, zwraca true
	// jesli napis jeszcze nie był w drzewie, false
	// w przeciwnym przypadku
	
	private Node insertWord(Node node, String str, int i) {
		char c;
		Node nextNode = node.doYouKnowThisWord((c = str.charAt(i)));
		if(nextNode == null) {
			nextNode = new Node(c);
			node.setNode(nextNode);
			if(i == str.length()-1) {
				nextNode.setIsThisWord(true);
				return nextNode;
			}
		}
		else {
			if(i == str.length()-1) return null;
		}
		i++;
		return insertWord(nextNode, str, i);
	}
	
	boolean DelString( String str ) {
		// usuwa napis z drzewa, zwraca true jeśli
		// napis był w drzewie, false w przeciwnym
		// przypadku
		Node node = tryDelete(root, null, null, str, 0);
		if(node == null) {
			length--;
			return true;
		}
		else {
			return false;
		}
	}
	
	private Node tryDelete(Node node, Node firstOneChildNode, Node lastTwoChildNode, String str, int i) {
		Node nextNode = node.doYouKnowThisWord(str.charAt(i));
		if(nextNode != null) {
			if(nextNode.hasMoreThanOneChild()) {
				firstOneChildNode = null;
				lastTwoChildNode = nextNode;
			}
			else {
				if(firstOneChildNode == null) firstOneChildNode = nextNode;
			}
			if(i == str.length()-1) {
				if(lastTwoChildNode == null) return null;
				lastTwoChildNode.remove(firstOneChildNode);
				return root;
			}
		}
		else {
			if(i > 0) return null;
		}
		i++;
		return tryDelete(nextNode, firstOneChildNode, lastTwoChildNode, str, i);
	}
	
	boolean isDefined( String str ) {
		Node node  = whereThisStringShouldBe(root, str, 0);
		if(node == null) {
			return false;
		}
		else {
			return true;
		}
	}	
	// sprawdza czy wskazany napis jest w drzewie;
	
	private Node whereThisStringShouldBe(Node node, String str, int i) {
		Node nextNode = node.doYouKnowThisWord(str.charAt(i));
		if(nextNode == null) {
			return null;
		}
		else if(nextNode.letter == str.charAt(i)){
			if(i == str.length()-1) return nextNode;
		}
		else {
			return null;
		}
		i++;
		return whereThisStringShouldBe(nextNode, str, i);
	}
	
	String [] Triee2Array() {
		String [] treeArray;
		String str = "";
		str = fillString(root, str);
		treeArray = str.split("\\s+");
		return treeArray;
	}
	// tworzy tablicę wszystkich napisów
	// reprezentowanych w drzewie

	
	private String fillString(Node node, String str) {
		if(node.letter != (char) 0) str += node.letter;
		if(node.isThisAWord == true && !node.hasChild()) return str + " ";
		else if(node.isThisAWord == true && node.hasMoreThanOneChild()) {
			String newString = "";
			LinkedList<Node> nextNodes = node.getNextNodes();
			for(Node n : nextNodes) {
				newString += fillString(n, str) + " ";
			}
			str = newString;
		}
		else if(node.isThisAWord == true && node.hasChild()) {
			str += fillString(node.getNode(0), "");
		}
		else {
			if(node.hasChild()) {
				if(node.hasMoreThanOneChild()) {
					String newString = "";
					LinkedList<Node> nextNodes = node.getNextNodes();
					for(Node n : nextNodes) {
						newString += fillString(n, str) + " ";
					}
					str = newString;
				}
				else {
					str = fillString(node.getNode(0), str) + " ";
				}
			}
		}
		return str;

	}
}
