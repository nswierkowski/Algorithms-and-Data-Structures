package TrieTree;

import java.util.HashMap;
import java.util.Map;

public class TrieTreeWithArray{

	private class Node {
		
		Node [] nextNodes;
		int length;
		
		Node() {
			length = 0;
			nextNodes = new Node[46];
		}
	
		Node [] getNodes() {
			return nextNodes;
		}
		
		void setNode(Node node, char c) {
			length++;
			nextNodes[thisCharIndex(c)] = node;
		}
		
		Node getNode(char c) {
			return nextNodes[thisCharIndex(c)];
		}
		
		Node getNode(int i) {
			return nextNodes[i];
		}
		
		char getChar(int i) {
			return (char) thisIntChar(i);
		}
		
		Node doYouKnowThisWord(char c) {
			return nextNodes[thisCharIndex(c)];
		}
		
		void remove(char c) {
			nextNodes[thisCharIndex(c)] = null;
		}
		
		boolean hasChild() {
			if(length > 0)  return true;
			return false;
		}
	
		boolean hasMoreThanOneChild() {
			if(length > 1)  return true;
			return false;
		}
		
		void setNextNode(Node node, char c) {
			length++;
			nextNodes[thisCharIndex(c)] = node;
		}
			
		private int thisCharIndex(char c) {
			int ascii = (int) c;
			if(ascii >= 97 &&  ascii <= 122) {
				return ascii - 97;
			}
			else if(ascii >= 48 &&  ascii <= 57) {
				return ascii - 22;
			}
			else if(ascii == 95) {
				return 36;
			}
			else {
				switch (c) {
					case 'ą':
						return 37; 
					case 'ć':
						return 38;
					case 'ę':
						return 39;
					case 'ł':
						return 40;
					case 'ń':
						return 41;
					case 'ó':
						return 42;
					case 'ś':
						return 43;
					case 'ź':
						return 44;
					case 'ż':
						return 45;	
					default:
						return 46;
				}
			}
		}

		private int thisIntChar(int i) {
			if(i < 26) {
				return (char) (i + 97);
			}
			else if(i < 36) {
				return (char) (i + 22);
			}
			else if(i == 95) {
				return (char) 36;
			}
			else {
				switch (i) {
					case 37:
						return 'ą'; 
					case 38:
						return 'ć';
					case 39:
						return 'ę';
					case 40:
						return 'ł';
					case 41:
						return 'ń';
					case 42:
						return 'ó';
					case 43:
						return 'ś';
					case 44:
						return 'ź';
					case 45:
						return 'ż';	
					default:
						return 46;
				}
			}
		}
	}
	
	private Node root;
	int length;
	
	public TrieTreeWithArray() {
		root = new Node();
		length = 0;
	}
	
	void DeleteAll() {
		root = null;
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
		char c = str.charAt(i);
		Node nextNode = node.doYouKnowThisWord(c);
		if(nextNode == null) {
			nextNode = new Node();
			node.setNextNode(nextNode, c);
			if(i == str.length() - 1) {
				return nextNode;
			}
		}
		else {
			if(i == str.length() - 1) {
				return null;
			}
		}
		i++;
		return insertWord(nextNode, str, i);
	}
	
	private Node tryDelete(Node node, Node lastTwoChildNode, char charNodes, String str, int i) {
		char c;
		Node nextNode = node.doYouKnowThisWord(c = str.charAt(i));
		if(nextNode != null) {
			if(nextNode.hasMoreThanOneChild()) {
				charNodes = (char) 0;
				lastTwoChildNode = nextNode;
			}
			else {
				if(charNodes == (char) 0) {
					charNodes = c;
				}
			}
			if(i == str.length()-1) {
				if(lastTwoChildNode == null) {
					root.remove(str.charAt(0));
				}
				else {
					if(charNodes != (char) 0 && lastTwoChildNode != null) {
						lastTwoChildNode.remove(charNodes);
					}
					else {
						lastTwoChildNode.remove(c);
					}
				}
			return root;
			}
		}	
		else {
			if(i > 0) return null;
		}
		i++;
		return tryDelete(nextNode, lastTwoChildNode, charNodes, str, i);
	}

	boolean DelString( String str ) {
		Node node = tryDelete(root, null, (char)0, str, 0);
		if(node == null) {
			length--;
			return true;
		}
		else {
			return false;
		}
	}
	// usuwa napis z drzewa, zwraca true jeśli
	// napis był w drzewie, false w przeciwnym
	// przypadku
	
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
		if(node.hasChild()) {
				String newString = "";
				for(int i = 0; i < 46; i++) {
					if(node.getNode(i) != null) newString += fillString(node.getNode(i), str+node.getChar(i)) + " ";
				}
				str = newString;
		}
		return str;
	}
	
}
