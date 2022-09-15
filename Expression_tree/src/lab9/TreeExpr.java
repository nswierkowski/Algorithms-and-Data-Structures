package lab9;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeExpr {
	// klasa do reprezentacji pojedynczego wyrażenia w postaci drzewa
	
	private class Node {		
		Node leftChild;
		Node rightChild;
		String key;
		
		Node() {}
		
		Node(String key) {
			this.key = key;
		}
		
		void setKey(String key) {
			this.key = key;
		}
		
		void addChild(Node node) {
			if(leftChild != null) rightChild = node;
			leftChild = node;
		}
		
		void setLeft(Node node) {
			leftChild = node;
		}
		
		void setRight(Node node) {
			rightChild = node;
		}
		
		float getValue(SymbolTable st) {
			switch(key) {
				case "+":
					return leftChild.getValue(st) + rightChild.getValue(st);
				case "-":
					return leftChild.getValue(st) - rightChild.getValue(st);
				case "*":
					return leftChild.getValue(st) * rightChild.getValue(st);
				case "/":
					return leftChild.getValue(st) / rightChild.getValue(st);
				case "^":
					return (float) Math.pow(leftChild.getValue(st), rightChild.getValue(st));	
				default:
					if(st.ValueOf(key) != null) return st.ValueOf(key);	
					else {
							Float value = Float.parseFloat(key);
							return value;
					}
			}
		}
		
		Node getLeft() {
			return leftChild;
		}
		
		Node getRight() {
			return rightChild;
		}
	}
	
	Node root;
	int index;
	
	public TreeExpr() {
		root = null;
		index = 0;
	}
	
	void Build(String prefix_expr) {
		root = nextNode(prefix_expr);
		index = 0;
	}
	
	Node nextNode(String prefix_expr) {
		prefix_expr = prefix_expr.replaceAll("[()]","");
		String [] array = prefix_expr.split("\\s+");
		Node node = new Node(array[index]);
		index++;
		if(array[index].equals("+") || array[index].equals("-") || array[index].equals("*") || array[index].equals("/") || array[index].equals("^")) {
			node.setLeft(nextNode(prefix_expr));
		}
		else {
			node.setLeft(new Node(array[index]));
		}
		
		index++;
		if(array[index].equals("+") || array[index].equals("-") || array[index].equals("*") || array[index].equals("/") || array[index].equals("^")) {
			node.setRight(nextNode(prefix_expr));
		}
		else {
			node.setRight(new Node(array[index]));
		}
		
		return node;
	}
	
	float Eval( SymbolTable st ) {
	// wylicza wartość wyrażenia na podstawie wyrażenia i
	// wartościowania zmiennych w tablicy SymbolTable
		return root.getValue(st);
	}
	
	public String toString() {
		return getAllKeys(root);
	}
	
	String getAllKeys(Node node) {
		if(node == null) return "";
		return node.key + getAllKeys(node.getLeft()) + getAllKeys(node.getRight());
	}
}
