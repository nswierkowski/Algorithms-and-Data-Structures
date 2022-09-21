package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

public class Graph {

	private List<String> vertices;
	private float [][] probability;
	private String first;
	private String last;
	private LinkedList<Integer> path;
	
	public Graph() {
		first = "<s>";
		last = "</s>";
		vertices = new ArrayList<String>();
		vertices.add(first);
		vertices.add(last);
		probability = new float[50][50];
		path = new LinkedList<Integer>();
	}
	
	public void newPath() {
		path = new LinkedList<Integer>();
	}
	
	private void resize() {
		float[][] newArray = new float[probability.length*2][probability.length*2];
		for(int i = 0; i < vertices.size(); i++) {
			for(int j = 0; j < vertices.size(); j++) {
				newArray[i][j] = probability[i][j];
			}
		}
		probability = newArray;
	}
	
	public void repair() {
		for(int i = 0; i < vertices.size(); i++) {
			double sum = 0.0;
			for(int j = 0; j < vertices.size(); j++) {
				sum += probability[i][j];
			}
			if(sum != 1.0) {
				for(int j = 0; j < vertices.size(); j++) {
					probability[i][j] = (float) (probability[i][j]*(1.0/sum));
				}
			}
		}
	}
	
	public String get(int i) {
		return vertices.get(i);
	}
	
	public void addEdge(String parent, String child, float f) {
		if(vertices.contains(parent)) {
			int indexOfParent = vertices.indexOf(parent);
			int indexOfChild = 0;
			if(vertices.contains(child)) {
				indexOfChild = vertices.indexOf(child);
			}
			else {
				if(vertices.size() == probability.length) resize();
				vertices.add(child);
				indexOfChild = vertices.size() - 1;
			}
			probability[indexOfParent][indexOfChild] = f;
		}
		else {
			if(vertices.size() == probability.length) resize();
			vertices.add(parent);
			int indexOfParent = vertices.size() - 1;
			int indexOfChild = 0;
			if(vertices.contains(child)) {
				indexOfChild = vertices.indexOf(child);
			}
			else {
				vertices.add(child);
				indexOfChild = vertices.size() - 1;
			}
			probability[indexOfParent][indexOfChild] = f;
		}
	}
	
	public void show() {
		int i = 0;
		for(String s : vertices) {
			System.out.println(i+". "+s);
			i++;
		}	
	}
	
	public TreeSet<String> getNext(String str) {
		int index = indexOf(str);
		if(index == -1) return null;
		TreeSet<String> listOfNext = new TreeSet<String>();
		for(int i = 0; i < vertices.size(); i++) {
			if(probability[index][i] != 0.0 && !listOfNext.contains(vertices.get(i))) {
				listOfNext.add(vertices.get(i));
				if(index != i) listOfNext.addAll(getNext(vertices.get(i)));
			}
		}
		return listOfNext;
	}

	public int indexOf(String str) {
		for(int i = 0; i < vertices.size(); i++) {
			if(str.equals(vertices.get(i))) return i; 
		}
		return -1;
	}
	
	public boolean lookForCycle() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		return lookingForCycleDFS(list, 0);
	}
	
	private boolean lookingForCycleDFS(LinkedList<Integer> list, int indexOfActualVerticle) {
		for(int i = 0; i < vertices.size(); i++) {
			if(probability[indexOfActualVerticle][i] != 0) {
				if(list.contains(i)) {
					return true;
				}
				else {
					list.add(0, i);
					boolean isThereCycle = lookingForCycleDFS(list, i);
					if(isThereCycle) {
						return isThereCycle;
					}
					else {
						list.remove((int) 0);
					}
				}
			}
		}
		return false;
	}
	
	public String path() {
		list();
		if(path == null) return null;
		String s = "";
		int lastVer = -1;
		double chance = 1.0;
		for(Integer i : path) {
			if(lastVer != -1) {
				chance *= probability[i][lastVer];
			}
			s = vertices.get(i) + " " + s; 
			lastVer = i;
		}
		s = chance +" "+ s;
		return s;
	}
	
	private void list() {
		if(path != null && path.isEmpty()) {
			path.push(0);
			path = nextPath(path, 0, false);
		}
		else if(path != null) {
			path = nextPath(path, 0, true);
		}
	}
	
	private LinkedList<Integer> nextPath(LinkedList<Integer> stack, int indexOfActualVerticle, boolean a) {
		int index = 0;
		if(stack.size() > 1 && a) {
			index = stack.pop();
			indexOfActualVerticle = stack.peek();
		}
		for(int i = index + 1; i < vertices.size(); i++) {
			if(probability[indexOfActualVerticle][i] != 0) {
				if(1 == i) {
					stack.push(i);
					return stack;
				}
				else {
					stack.push(i);
					return nextPath(stack, i, false);
				}
			}
		}
		if(0 == indexOfActualVerticle) {
			return null;
		}
		else {
			return nextPath(stack, indexOfActualVerticle, true);
		}
	}
	
	public int[][] allEdges(){
		int [][] edges = new int[vertices.size()][];
		for(int i = 0; i < vertices.size(); i++) {
			List<Integer> nextVertices = new ArrayList<Integer>();
			for(int j = 0; j < vertices.size(); j++) {
				if(probability[i][j] != 0) nextVertices.add(j);
			}
			edges[i] = new int [nextVertices.size()];
			for(int k = 0; k < edges[i].length; k++) {
				edges[i][k] = nextVertices.get(k);
			}
		}
		return edges;
	}
	
	public String[][] allEdgesString(){
		String [][] edges = new String[vertices.size()][];
		for(int i = 0; i < vertices.size(); i++) {
			List<String> nextVertices = new ArrayList<String>();
			nextVertices.add(vertices.get(i) + ": ");
			for(int j = 0; j < vertices.size(); j++) {
				if(probability[i][j] != 0) nextVertices.add(vertices.get(j));
			}
			edges[i] = new String [nextVertices.size()];
			for(int k = 0; k < edges[i].length; k++) {
				edges[i][k] = nextVertices.get(k);
			}
		}
		return edges;
	}

}