package TrieTree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import TrieTree.*;

public class Main {

	static List<String> words;
	static List<String> choosenwords;
	
	public static void main(String[] args) {
		insert();
		
		System.out.println("Dla 100: ");
		Array(100);
		
		System.out.println("Dla 200: ");
		Array(200);
		
		System.out.println("Dla 400: ");
		Array(400);
		
		System.out.println("Dla 800: ");
		Array(800);
		
		System.out.println("Dla 1600: ");
		Array(1600);
		
		System.out.println("Dla 3200: ");
		Array(3200);
		
		System.out.println("Dla 6400: ");
		Array(6400);
		
		System.out.println("Dla 12800: ");
		Array(12800);
		
		System.out.println("Dla 25600: ");
		Array(25600);
		
		System.out.println("Dla 51200: ");
		Array(51200);
		
		System.out.println("Dla 102400: ");
		Array(102400);
		
		System.out.println("Dla 204800: ");
		Array(204800);
		
		System.out.println("Dla 409600: ");
		Array(409600);
		
		System.out.println("Dla 819200: ");
		Array(819200);
		
		System.out.println("Dla 1638400: ");
		Array(1638400);
		
		System.out.println("\n\n ArrayList");
		System.out.println("Dla 100: ");
		ArrayList(100);
		
		System.out.println("Dla 200: ");
		ArrayList(200);
		
		System.out.println("Dla 400: ");
		ArrayList(400);
		
		System.out.println("Dla 800: ");
		ArrayList(800);
		
		System.out.println("Dla 1600: ");
		ArrayList(1600);
		
		System.out.println("Dla 3200: ");
		ArrayList(3200);
		
		System.out.println("Dla 6400: ");
		ArrayList(6400);
		
		System.out.println("Dla 12800: ");
		ArrayList(12800);
		
		System.out.println("Dla 25600: ");
		ArrayList(25600);
		
		System.out.println("Dla 51200: ");
		ArrayList(51200);
		
		System.out.println("Dla 102400: ");
		ArrayList(102400);
		
		System.out.println("Dla 204800: ");
		ArrayList(204800);
		
		System.out.println("Dla 409600: ");
		ArrayList(409600);
		
		System.out.println("Dla 819200: ");
		ArrayList(819200);
		
		System.out.println("Dla 1638400: ");
		ArrayList(1638400);
		
		System.out.println("\n\n HashMap");
		System.out.println("Dla 100: ");
		HashMap(100);
		
		System.out.println("Dla 200: ");
		HashMap(200);
		
		System.out.println("Dla 400: ");
		HashMap(400);
		
		System.out.println("Dla 800: ");
		HashMap(800);
		
		System.out.println("Dla 1600: ");
		HashMap(1600);
		
		System.out.println("Dla 3200: ");
		HashMap(3200);
		
		System.out.println("Dla 6400: ");
		HashMap(6400);
		
		System.out.println("Dla 12800: ");
		HashMap(12800);
		
		System.out.println("Dla 25600: ");
		HashMap(25600);
		
		System.out.println("Dla 51200: ");
		HashMap(51200);
		
		System.out.println("Dla 102400: ");
		HashMap(102400);
		
		System.out.println("Dla 204800: ");
		HashMap(204800);
		
		System.out.println("Dla 409600: ");
		HashMap(409600);
		
		System.out.println("Dla 819200: ");
		HashMap(819200);
		
		System.out.println("Dla 1638400: ");
		HashMap(1638400);
//		ar();
	}
	
//	static void staticArray() {
//		TrieTree tt = new TrieTree();
//		System.out.println(tt.AddString("al"));
//		System.out.println(tt.AddString("polska"));
//		System.out.println(tt.AddString("alicja"));
//		String [] strings = tt.Triee2Array();
//		for(int i = 0; i < strings.length; i++) {
//			System.out.println(strings[i]);
//		}
//
//		System.out.println(tt.DelString("al"));
//		strings = tt.Triee2Array();
//		for(int i = 0; i < strings.length; i++) {
//			System.out.println(strings[i]);
//		}
//		
//		System.out.println(tt.AddString("al"));
//		strings = tt.Triee2Array();
//		for(int i = 0; i < strings.length; i++) {
//			System.out.println(strings[i]);
//		}
//		System.out.println(tt.isDefined("al"));
//		System.out.println(tt.isDefined("a"));
//		System.out.println(tt.isDefined("z"));
//		
//		System.out.println("\n");
//	}
	
	static void arList() {
		TrieTreeWithArrayList tt = new TrieTreeWithArrayList();
		System.out.println(tt.AddString("alko"));
		System.out.println(tt.AddString("ale"));
		System.out.println(tt.AddString("polska"));
		System.out.println(tt.AddString("alicja"));
		String [] strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}

		System.out.println(tt.DelString("al"));
		strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		
		System.out.println(tt.AddString("al"));
		strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println(tt.isDefined("al"));
		System.out.println(tt.isDefined("a"));
		System.out.println(tt.isDefined("z"));
		
		System.out.println("\n");
	}
	
	static void sortedArray() {
		TrieTreeSortedArray tt = new TrieTreeSortedArray();
		System.out.println(tt.AddString("alko"));
		System.out.println(tt.AddString("ale"));
		System.out.println(tt.AddString("polska"));
		System.out.println(tt.AddString("alicja"));
		String [] strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}

		System.out.println(tt.DelString("al"));
		strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		
		System.out.println(tt.AddString("al"));
		strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println(tt.isDefined("al"));
		System.out.println(tt.isDefined("a"));
		System.out.println(tt.isDefined("z"));
		
		System.out.println("\n");
	}
	
	static void linkedList() {
		TrieTreeLinkedList tt = new TrieTreeLinkedList();
		System.out.println(tt.AddString("alko"));
		System.out.println(tt.AddString("ale"));
		System.out.println(tt.AddString("polska"));
		System.out.println(tt.AddString("alicja"));
		String [] strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}

		System.out.println(tt.DelString("al"));
		strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		
		System.out.println(tt.AddString("al"));
		strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println(tt.isDefined("al"));
		System.out.println(tt.isDefined("a"));
		System.out.println(tt.isDefined("z"));
		
		System.out.println("\n");
	}
	
	static void hashMap() {
		TrieTreeHashMap tt = new TrieTreeHashMap();
		System.out.println(tt.AddString("alko"));
		System.out.println(tt.AddString("ale"));
		System.out.println(tt.AddString("polska"));
		System.out.println(tt.AddString("alicja"));
		String [] strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}

		System.out.println(tt.DelString("al"));
		strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		
		System.out.println(tt.AddString("al"));
		strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println(tt.isDefined("al"));
		System.out.println(tt.isDefined("a"));
		System.out.println(tt.isDefined("z"));
		
		System.out.println("\n");
	}
	
	static void ar() {
		TrieTreeWithArray tt = new TrieTreeWithArray();
		System.out.println(tt.AddString("alko"));
		System.out.println(tt.AddString("ale"));
		System.out.println(tt.AddString("polska"));
		System.out.println(tt.AddString("alicja"));
		String [] strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}

		System.out.println(tt.DelString("polska"));
		strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		
		System.out.println(tt.AddString("al"));
		strings = tt.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println(tt.isDefined("al"));
		System.out.println(tt.isDefined("a"));
		System.out.println(tt.isDefined("z"));
		
		System.out.println("\n");
	}
	
	static void check() {
		List<String> words = new ArrayList<String>();
		File file = new File("text.txt");
		TrieTreeWithArray ttwa = new TrieTreeWithArray();
		TrieTreeWithArrayList ttal = new TrieTreeWithArrayList();
		TrieTreeHashMap tthp = new TrieTreeHashMap();
		try {
			String word;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			while((word = br.readLine()) != null) {
//				System.out.println(ttwa.AddString(word));
//				System.out.println(tthp.AddString(word));
//				System.out.println(ttal.AddString(word));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String [] strings = ttwa.Triee2Array();
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println("\n");
		
		String [] strings2 = tthp.Triee2Array();
		for(int i = 0; i < strings2.length; i++) {
			System.out.println(strings2[i]);
		}
		System.out.println("\n");

		String [] strings3 = ttal.Triee2Array();
		for(int i = 0; i < strings3.length; i++) {
			System.out.println(strings3[i]);
		}
		System.out.println("\n");

	}
	
	static void insert() {
		words = new ArrayList<String>();
		File file = new File("slowa.txt");
		try {
			String word;
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
			while((word = br.readLine()) != null) {
				words.add(word);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void Array(int numberOfWords) {
		TrieTreeWithArray ttwa = new TrieTreeWithArray();
		Random g = new Random();
		long startAddingTime;
		long endAddingTime;
		long addingTime = 0;
		long startSearchingTime;
		long endSearchingTime;
		long searchingTime = 0;
		for(int j = 0; j < 20; j++) {
			addingTime = 0;
			for(int i = 0; i < numberOfWords; i++) {
				String str = words.get(g.nextInt(words.size()));
				startAddingTime = System.currentTimeMillis();
				ttwa.AddString(str);
				endAddingTime = System.currentTimeMillis();
				addingTime += endAddingTime - startAddingTime;
			}
			System.out.print(addingTime*0.001 + "	");
		
			searchingTime = 0;
			for(int i = 0; i < numberOfWords; i++) {
				String str = words.get(g.nextInt(words.size()));
				startSearchingTime = System.currentTimeMillis();
				ttwa.isDefined(str);
				endSearchingTime = System.currentTimeMillis();
				searchingTime += endSearchingTime - startSearchingTime;
			}
			System.out.println(searchingTime*0.001);
		}
		System.out.println("\n");
	}
	
	static void ArrayList(int numberOfWords) {
		Random g = new Random();
		long startAddingTime;
		long endAddingTime;
		long addingTime = 0;
		long startSearchingTime;
		long endSearchingTime;
		long searchingTime = 0;
		for(int j = 0; j < 20; j++) {
			TrieTreeWithArrayList ttwa = new TrieTreeWithArrayList();
			addingTime = 0;
			for(int i = 0; i < numberOfWords; i++) {
				String str = words.get(g.nextInt(words.size()));
				startAddingTime = System.currentTimeMillis();
				ttwa.AddString(str);
				endAddingTime = System.currentTimeMillis();
				addingTime += endAddingTime - startAddingTime;
			}
			System.out.print(addingTime*0.001 + "	");
		
			searchingTime = 0;
			for(int i = 0; i < numberOfWords; i++) {
				String str = words.get(g.nextInt(words.size()));
				startSearchingTime = System.currentTimeMillis();
				ttwa.isDefined(str);
				endSearchingTime = System.currentTimeMillis();
				searchingTime += endSearchingTime - startSearchingTime;
			}
			System.out.println(searchingTime*0.001);
			ttwa.DeleteAll();
		}
		System.out.println("\n");
	}
	
	static void HashMap(int numberOfWords) {
		Random g = new Random();
		long startAddingTime;
		long endAddingTime;
		long addingTime = 0;
		long startSearchingTime;
		long endSearchingTime;
		long searchingTime = 0;
		for(int j = 0; j < 20; j++) {
			TrieTreeHashMap ttwa = new TrieTreeHashMap();
			addingTime = 0;
			for(int i = 0; i < numberOfWords; i++) {
				String str = words.get(g.nextInt(words.size()));
				startAddingTime = System.currentTimeMillis();
				ttwa.AddString(str);
				endAddingTime = System.currentTimeMillis();
				addingTime += endAddingTime - startAddingTime;
			}
			System.out.print(addingTime*0.001 + "	");
		
			searchingTime = 0;
			for(int i = 0; i < numberOfWords; i++) {
				String str = words.get(g.nextInt(words.size()));
				startSearchingTime = System.currentTimeMillis();
				ttwa.isDefined(str);
				endSearchingTime = System.currentTimeMillis();
				searchingTime += endSearchingTime - startSearchingTime;
			}
			System.out.println(searchingTime*0.001);
			ttwa.DeleteAll();
		}
		System.out.println("\n");
	}
}

