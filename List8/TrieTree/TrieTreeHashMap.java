package TrieTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TrieTreeHashMap {

	private class Node {
		
		HashMap<Character, Node> nextNodes;
		
		Node() {
			nextNodes = new HashMap(45);
		}
		
		Node getNode(char c) {
			return nextNodes.get(c);
		}
		
		HashMap<Character, Node> getNodes() {
			return nextNodes;
		}
		
		void setNode(char c, Node node) {
			nextNodes.put(c, node);
		}
		
		int length() {
			return nextNodes.size();
		}
		
		Node doYouKnowThisWord(char c) {
			if(nextNodes.containsKey(c)) return nextNodes.get(c); 
			else return null;
		}
		
		boolean hasChild() {
			if(nextNodes.size() > 0) return true;
			return false;
		}
		
		boolean hasMoreThanOneChild() {
			if(nextNodes.size() > 1) return true;
			return false;
		}
		
		void remove(Node node) {
			nextNodes.remove(node);
		}
	}
	
	private Node root;
	int length;
	
	public TrieTreeHashMap() {
		root = new Node();
		length = 0;
	}
	
	void DeleteAll() {
		root = new Node();
		length = 0;
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
			nextNode = new Node();
			node.setNode(c, nextNode);
			if(i == str.length()-1) {
				return nextNode;
			}
		}
		else {
			if(i == str.length()-1) {
				return null;
			}
		}
		i++;
		return insertWord(nextNode, str, i);
	}
	
	boolean DelString( String str ) {
		// usuwa napis z drzewa, zwraca true jeśli
		// napis był w drzewie, false w przeciwnym
		// przypadku
		Node node = tryDelete(root, null, root, str, 0);
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
		char c;
		Node nextNode = node.doYouKnowThisWord(c = str.charAt(i));
		if(nextNode == null) {
			return null;
		}
		else {
			if(i == str.length()-1) return nextNode;
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
		HashMap<Character, Node> nextNodes = node.getNodes();
		if(node.hasChild()) {
				String newString = "";
				for(Map.Entry<Character, Node> entry : nextNodes.entrySet()) {
					newString += fillString(entry.getValue(), str + entry.getKey()) + " ";
				}
				str = newString;
		}
		return str;
	}
}
