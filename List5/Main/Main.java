package Main;

import java.util.Random;

import ArraysLinkedListStack.ArraysLinkedLinkStack;
import IStack.EmptyStackException;
import IStack.FullStackException;
import LinkedListStack.LinkedListStack;
import StackWithUnneededElements.StackWithUnnecessaryElements;

public class Main {

	static volatile long startTime;
	static volatile long endTime;
	
	public static void main(String[] args){	
		
		try {
			System.out.println(" Pierwsza funkcja: ");
			checkLinkedList(10000000, 9000000);
			checkArrayLinkedList(10000000, 9000000);
			checkListWithUnnecessaryElements(10000000, 9000000);
			System.out.println("\n Druga funkcja: ");
			test2LL(9999999);
			test2ALL(9999999);
			test2SWUE(9999999);
		} catch (FullStackException e) {
			e.printStackTrace();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		
	}

	static void checkLinkedList(int N, int M) throws FullStackException{
		LinkedListStack firstStack = new LinkedListStack();
		LinkedListStack secondStack = new LinkedListStack();
		LinkedListStack thirdStack = new LinkedListStack();
		
		Random g = new Random();
		int k;
		for(int i = 0; i < N; i++) {
			 k = g.nextInt(3) + 1;
			 switch (k) {
			 	case 1: 
			 		firstStack.push(g.nextInt());
			 		break;
			 	case 2:	
			 		secondStack.push(g.nextInt());
			 		break;
			 	default:
			 		thirdStack.push(g.nextInt());
			 }
		}
		
		startTime = System.currentTimeMillis();
		for(int i = 0; i < M; i++) {
			int temp1 = g.nextInt(3) + 1;
			int element = 0;
			int temp2 = g.nextInt(3) + 1;
			try {
				switch (temp1) {
			 		case 1: 
			 			element = (int) firstStack.pop();
			 			break;
			 		case 2:	
			 			element = (int) secondStack.pop();
			 			break;
			 		default:
			 			element = (int) thirdStack.pop();
				}
			} catch (EmptyStackException e) {}
			
			switch (temp2) {
		 	case 1: 
		 		firstStack.push(element);
		 		break;
		 	case 2:	
		 		secondStack.push(element);
		 		break;
		 	default:
		 		thirdStack.push(element);
			}
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("Stos jako jako lista wiązana wykonał ćwiczenie w " + (0.001*(endTime - startTime)) + " sekund");
	}
	
	
	static void checkArrayLinkedList(int N, int M) throws FullStackException{
		ArraysLinkedLinkStack firstStack = new ArraysLinkedLinkStack();
		ArraysLinkedLinkStack secondStack = new ArraysLinkedLinkStack();
		ArraysLinkedLinkStack thirdStack = new ArraysLinkedLinkStack();
		
		Random g = new Random();
		int k;
		for(int i = 0; i < N; i++) {
			 k = g.nextInt(3) + 1;
			 switch (k) {
			 	case 1: 
			 		firstStack.push(g.nextInt());
			 		break;
			 	case 2:	
			 		secondStack.push(g.nextInt());
			 		break;
			 	default:
			 		thirdStack.push(g.nextInt());
			 }
		}
		
		startTime = System.currentTimeMillis();
		for(int i = 0; i < M; i++) {
			int temp1 = g.nextInt(3) + 1;
			int element = 0;
			int temp2 = g.nextInt(3) + 1;
			try {
				switch (temp1) {
			 		case 1: 
			 			element = (int) firstStack.pop();
			 			break;
			 		case 2:	
			 			element = (int) secondStack.pop();
			 			break;
			 		default:
			 			element = (int) thirdStack.pop();
				}
			} catch (EmptyStackException e) {}
			
			switch (temp2) {
		 	case 1: 
		 		firstStack.push(element);
		 		break;
		 	case 2:	
		 		secondStack.push(element);
		 		break;
		 	default:
		 		thirdStack.push(element);
			}
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("Stos, jako jako lista związana tablic, wykonał ćwiczenie w " + (0.001*(endTime - startTime)) + " sekund");
	}
	
	static void checkListWithUnnecessaryElements(int N, int M) throws FullStackException{
		StackWithUnnecessaryElements firstStack = new StackWithUnnecessaryElements();
		StackWithUnnecessaryElements secondStack = new StackWithUnnecessaryElements();
		StackWithUnnecessaryElements thirdStack = new StackWithUnnecessaryElements();
		
		Random g = new Random();
		int k;
		for(int i = 0; i < N; i++) {
			 k = g.nextInt(3) + 1;
			 switch (k) {
			 	case 1: 
			 		firstStack.push(g.nextInt());
			 		break;
			 	case 2:	
			 		secondStack.push(g.nextInt());
			 		break;
			 	default:
			 		thirdStack.push(g.nextInt());
			 }
		}
		
		startTime = System.currentTimeMillis();
		for(int i = 0; i < M; i++) {
			int temp1 = g.nextInt(3) + 1;
			int element = 0;
			int temp2 = g.nextInt(3) + 1;
			try {
				switch (temp1) {
			 		case 1: 
			 			element = (int) firstStack.pop();
			 			break;
			 		case 2:	
			 			element = (int) secondStack.pop();
			 			break;
			 		default:
			 			element = (int) thirdStack.pop();
				}
			} catch (EmptyStackException e) {}
			
			switch (temp2) {
		 	case 1: 
		 		firstStack.push(element);
		 		break;
		 	case 2:	
		 		secondStack.push(element);
		 		break;
		 	default:
		 		thirdStack.push(element);
			}
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("Stos, jako jako lista wiązana z niepotrzebnymi elementami, wykonał ćwiczenie w " + (0.001*(endTime - startTime)) + " sekund");
	}
	
	public static void test2LL(int N) throws FullStackException, EmptyStackException {
		LinkedListStack firstStack = new LinkedListStack();
		LinkedListStack secondStack = new LinkedListStack();
		LinkedListStack thirdStack = new LinkedListStack();
		
		Random g = new Random();
		for(int i = 0; i < N; i++) {
			firstStack.push(g.nextInt());
		}
		
		int k = g.nextInt(3);
		int element = 0;
		startTime = System.currentTimeMillis();
		for(int i = 0; i < N; i++) {
			element = (int) firstStack.pop();
			if(k % 2 == 0) {
				secondStack.push(element);
			}
			else {
				thirdStack.push(element);
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Stos, jako jako lista wiązana z niepotrzebnymi elementami, wykonał ćwiczenie w " + (0.001*(endTime - startTime)) + " sekund");
	}
	
	public static void test2ALL(int N) throws FullStackException, EmptyStackException {
		ArraysLinkedLinkStack firstStack = new ArraysLinkedLinkStack();
		ArraysLinkedLinkStack secondStack = new ArraysLinkedLinkStack();
		ArraysLinkedLinkStack thirdStack = new ArraysLinkedLinkStack();
		
		Random g = new Random();
		for(int i = 0; i < N; i++) {
			firstStack.push(g.nextInt());
		}
		
		int k = g.nextInt(3);
		int element = 0;
		startTime = System.currentTimeMillis();
		for(int i = 0; i < N; i++) {
			element = (int) firstStack.pop();
			if(k % 2 == 0) {
				secondStack.push(element);
			}
			else {
				thirdStack.push(element);
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Stos, jako jako lista wiązana z niepotrzebnymi elementami, wykonał ćwiczenie w " + (0.001*(endTime - startTime)) + " sekund");
	}
	
	public static void test2SWUE(int N) throws FullStackException, EmptyStackException {
		StackWithUnnecessaryElements firstStack = new StackWithUnnecessaryElements();
		StackWithUnnecessaryElements secondStack = new StackWithUnnecessaryElements();
		StackWithUnnecessaryElements thirdStack = new StackWithUnnecessaryElements();
		
		Random g = new Random();
		for(int i = 0; i < N; i++) {
			firstStack.push(g.nextInt());
		}
		
		int k = g.nextInt(3);
		int element = 0;
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < N; i++) {
			element = (int) firstStack.pop();
			if(k % 2 == 0) {
				secondStack.push(element);
			}
			else {
				thirdStack.push(element);
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Stos, jako jako lista wiązana z niepotrzebnymi elementami, wykonał ćwiczenie w " + (0.001*(endTime - startTime)) + " sekund");
	}
}
