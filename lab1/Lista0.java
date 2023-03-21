package lab1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class TextAnalyser {
	
	List<String>text;
	String word;
	
	//It's index of line where was the last looking word
	int index;

	TextAnalyser()
	{
		text = new ArrayList<String>();
		index = -1;
	}
	
	Boolean LoadFile( String fname )
	{	
		try {
			BufferedReader bf = new BufferedReader(new FileReader(fname));
			String line;
			while((line = bf.readLine()) != null) {
				text.add(line);
			}
			bf.close();
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	Boolean SaveFile( String fname )
	{		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
			for(String s : text) {
				bw.write(s);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			return false;
		}

		return true;
	}
	
	Boolean SaveFileReversed( String fname )
	{	
		List<String>ReversedText = new ArrayList<>();
		for(int i = text.size() - 1; i >= 0; i--) {
			String line = "";
			String [] sentence = text.get(i).split(" ");
			String s = "";
			for(int j = 0; j < sentence.length/2; j++) {
				s = sentence[j];
				sentence[j] = sentence[sentence.length - 1 - j];
				sentence[sentence.length - 1 - j] = s;
			}
			ReversedText.add(String.join(" ", sentence));
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
			for(String s : ReversedText) {
				bw.write(s);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			return false;
		}

		return true;
	}
	
	int CountAppearences( String word )
	{
		int countAppearences = 0;
		for(String s : text) {
			String [] sentence = s.split("\\s");
			for(int i = 0; i < sentence.length; i++) {
				if(word.equals(sentence[i])) countAppearences++;
			}
		}

		return countAppearences;
	}
	
	String FindFirstContaining( String word )
	{		
		this.word = word;
		for(int i = 0; i < text.size(); i++) {
			String [] sentence = text.get(i).split("\\s");
			for(int j = 0; j < sentence.length; j++) {
				if(word.equals(sentence[j])) {
					index = i;
					return "Containing " + text.get(index);
				}
			}
		}
		return "";
	}
	
	String FindNext( )
	{	
		if(index == -1) return "";
		for(int i = index + 1; i < text.size(); i++) {
			String [] sentence = text.get(i).split("\\s");
			for(int j = 0; j < sentence.length; j++) {
				if(word.equals(sentence[j])) {
					index = i;
					return text.get(index);
				}
			}
		}
		return "";
	}
	
	String FindLongestByWords( )
	{	
		int max = 0;
		int index = 0;
		for(int i = 0; i < text.size(); i++) {
			String [] sentence = text.get(i).split("\\s");
			if(max < sentence.length) {
				max = sentence.length;
				index = i;
			}
		}
		return text.get(index);
	}
	
	String FindLongestByChars( )
	{	
		int max = 0;
		int k = 0;
		for(int i = 0; i < text.size(); i++) {
			int numberOfCharsInSentence = 0;
			String [] sentence = text.get(i).split("\\s");
			for(int j = 0; j < sentence.length; j++) {
				numberOfCharsInSentence += sentence[j].length();
			}
			if(max < numberOfCharsInSentence) {
				max = numberOfCharsInSentence;
				k = i;
			}
		}
		return text.get(k);
	}
	
	int Replace( String srd, String dst )
	{		
		int numberOfReplacedItems = 0;
		for(int i = 0; i < text.size(); i++) {
			String line = "";
			String [] sentence = text.get(i).split(" ");
			for(int j = 0; j < sentence.length; j++) {
				if(srd.equals(sentence[j])) {
					sentence[j] = dst;
					numberOfReplacedItems++;
				}
			}
			text.set(i, String.join(" ", sentence));
		}
		return numberOfReplacedItems;
	}
	
	Boolean RemoveLine( int index )
	{	
		if(index >= 0 && index < text.size()) {
			text.remove(index);
			return true;
		}
		else {
			return false;
		}
	}
	
	Boolean InsertAfter( int index, String line )
	{		
		if(index >= 0 && index <= text.size()) {
			text.add(index, line);
			return true;
		}
		else {
			return false;
		}
	}
	
}


public class Lista0 {
	private static Scanner in;	

	public static void main(String[] args) {		
		
		in = new Scanner( System.in );  		
        int command = 0;        
    	TextAnalyser analyser = new TextAnalyser();    	
        String in_fname, out_fname, word, src_word, dst_word;               
        
        while ( (command = read_command(true)) != 0 ) 
        {
        	switch ( command ) {
        		case 1: 
        			System.out.print( "Podaj nazwe pliku: ");
        			in_fname = read_str();
        			if( analyser.LoadFile( in_fname ) )
        				System.out.println("OK");
        			else
        				System.out.println("ERR");        			
        			break;
        		case 2: 
        			System.out.print( "Podaj nazwe pliku: ");
        			out_fname = read_str();
        			if( analyser.SaveFile( out_fname ) )
        				System.out.println("OK");
        			else
        				System.out.println("ERR");        			
        			break;
        		case 3: 
        			System.out.print( "Podaj nazwe pliku: ");
        			out_fname = read_str();
        			if( analyser.SaveFileReversed( out_fname ) )
        				System.out.println("OK");
        			else
        				System.out.println("ERR");        			
        			break;
        		case 4: 
        			System.out.print( "Podaj słowo  do zliczania: ");
        			word = read_str();
        			int count = analyser.CountAppearences(word);
        			System.out.println( Integer.toString(count) );
        			break;
        		case 5: 
        			System.out.print( "Podaj słowo  do wyszukania wystąpienia: ");
        			word = read_str();
        			String line = analyser.FindFirstContaining(word);
        			System.out.println( line );
        			break;
        		case 6: 
        			line = analyser.FindNext();
        			System.out.println( line );        			
        			break;
        		case 7: 
        			line = analyser.FindLongestByWords();
        			System.out.println( line );        			
        			break;
        		case 8: 
        			line = analyser.FindLongestByChars();
        			System.out.println( line );        			
        			break;
        		case 9: 
        			System.out.print( "Podaj słowa: zródłowe docelowe: ");
        			word = read_str();
        			String [] words = word.split(" +");
        			if ( words.length != 2) {
        				System.out.println( "B��dne dane" );
        				break;
        			}
        			src_word = words[0];
        			dst_word = words[1];
        			count = analyser.Replace( src_word,  dst_word );
        			System.out.println( Integer.toString(count) );        			
        			break;
        		case 10:
        			int index;
        			System.out.println( "Podaj indeks linii do usunięcia ");
        			index = read_int();
        			if( analyser.RemoveLine( index ) )
        				System.out.println("OK");
        			else
        				System.out.println("ERR");        			
        			break;
        		case 11:
        			System.out.println( "Podaj indeks linii do wstawienia ");
        			index = read_int();
        			System.out.println( "Wpisz nową linie ");
        			line = read_str();
        			if( analyser.InsertAfter( index, line ) )
        				System.out.println("OK");
        			else
        				System.out.println("ERR");        			
        			break;
        		default:
        			System.out.println( "Błędna komenda");      
        	}
        }
	}
	
	static int read_command( Boolean debug ) {
		if ( debug ) {
			System.out.println( "0 - koniec" );
			System.out.println( "1 - wczytaj plik <-- nazwa pliku");
			System.out.println( "2 - zapisz plik <-- nazwa pliku");
			System.out.println( "3 - zapisz plik odwrócony <-- nazwa pliku");
			System.out.println( "4 - zlicz wystąpienia słowa <-- słowo");		
			System.out.println( "5 - znajdz linie zawierającą słowo <-- słowo");
			System.out.println( "6 - znajdz kolejną linie zawierającą słowo <-- nazwa pliku");
			System.out.println( "7 - znajdz najdłuższą linie (słowa)");
			System.out.println( "8 - znajdz najdłuższą linie (znaki)");
			System.out.println( "9 - zamień słowo <-- slowo_z słowo_na");		
			System.out.println( "10 - usuń linie <-- nr linii");
			System.out.println( "11 - wstaw linie <-- nr linii   tekst linii");		
			
			System.out.print( "Podaj komende: ");
		}
		return read_int();
	}

	static String read_str() {
	   return ( in.nextLine() );
	}	

	static int read_int() {
		String s = in.nextLine();
		return Integer.parseInt( s );
	}
}
