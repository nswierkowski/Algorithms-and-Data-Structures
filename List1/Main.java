package lab2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Scanner;


public class Main {

	static Scanner in;
	static Unbalanced2DArray<Integer> int2D;
	static Unbalanced2DArray<Student> student2D;
	
	/*if n is 1 - it means that this is array of int
	 *if n is 2 - it means that this is array of Student*/
	static int n; 
	
	public static void main(String[] args) {

		in = new Scanner( System.in );  		
	    int command = 0;
	    int inNumber, row_int;
	    
	    while ( (command = read_command(true)) != 0 ) 
	    {
	    	try {
	    	switch ( command ) {
	    		case 1: 
	    			System.out.print( "Wybierz obiekt z jakiego ma się składać tablica: \n 1) Integer \n 2) Student \n");
	    			n = read_int();
	    			System.out.print( "Wpisz liczbe wierszy tablicy: ");
	    			row_int = read_int();
	    			if(row_int <= 0) {
		    			System.out.print( "Błąd - liczba wierszy musi być większa od 0");
	    				break;
	    			}
	    			
	    			if(n == 1) {
	    				int2D = new Unbalanced2DArray<Integer>(row_int);
	    				System.out.print( "OK");
	    			}
	    			else if(n == 2) {
	    				student2D = new Unbalanced2DArray<Student>(row_int);
	    				System.out.print( "OK");
	    			}
	    			else {
	    				System.out.print( "ERR");
	    			}
	    			break;
	    		case 2: 
	    			System.out.print( "Ile wierszy chcesz wstawić: ");
	    			row_int = read_int();
	    			for(int i = 0; i < row_int; i++) {
	    				if(n == 1) {
		    				int2D.insertRow(i);
		    				System.out.print( "Wpisz ile kolumn ma mieć " + i + " wiersz: ");
		    				inNumber = read_int();
		    				int2D.setRowSize(i, inNumber);
		    			}
		    			else if(n == 2) {
		    				student2D.insertRow(i);
		    				System.out.print( "Wpisz ile kolumn ma mieć " + i + " wiersz: ");
		    				inNumber = read_int();
		    				student2D.setRowSize(i, inNumber);
		    			}
		    			else {
		    				System.out.print( "ERR");
		    				break;
		    			}  
	    			}
	    			break;
	    		case 3: 
	    			System.out.print( "Podaj numer wiersza: ");
	    			row_int = read_int();
	    			System.out.print( "Podaj długość jaką chcesz by miał ten wiersz: ");
	    			inNumber = read_int();
	    			if(n == 1) {
	    				int2D.setRowSize(row_int, inNumber);
	    				System.out.print( "OK");
	    			}
	    			else if(n == 2) {
	    				student2D.setRowSize(row_int, inNumber);
	    				System.out.print( "OK");
	    			}
	    			else {
	    				System.out.print( "ERR");
	    			}  			
	    			break;
	    		case 4: 
	    			System.out.print( "Podaj numer wiersz: ");
	    			row_int = read_int();
	    			System.out.print( "Podaj numer kolumny: ");
	    			inNumber = read_int();
	    			if(n == 1) {
	    				int2D.setAt(row_int, inNumber, 0);
	    				System.out.print( "OK");
	    			}
	    			else if(n == 2) {
	    				student2D.setAt(row_int, inNumber, new Student(0, 0));
	    				System.out.print( "OK");
	    			}
	    			else {
	    				System.out.print( "ERR");
	    			}  
	    			break;
	    		case 5: 
	    			System.out.print( "Podaj numer wiersz, jaki chcesz usunąć: ");
	    			row_int = read_int();
	    			if(n == 1) {
	    				int2D.deleteRow(row_int);
	    				System.out.print( "OK");
	    			}
	    			else if(n == 2) {
	    				student2D.deleteRow(row_int);
	    				System.out.print( "OK");
	    			}
	    			else {
	    				System.out.print( "ERR");
	    			}  
	    			break;
	    		case 6: 
	    			if(n == 1) {
	    				fillIntegersArray();
	    				System.out.print( "OK");
	    			}
	    			else if(n == 2) {
	    				fillStudentsArray();
	    				System.out.print( "OK");
	    			}
	    			else {
	    				System.out.print( "ERR");
	    			}          			
	    			break;
	    		case 7: 
	    			showArray();
	    			break;
	    		case 8: 
	    			showReverseArray();
	    			break;
	    		case 9: 
	    			System.out.print( "Index wiersza, który chcemy wstawić: ");
	    			inNumber = read_int();
	    			
	    			if(n == 1) {
	    				int2D.insertRow(inNumber);;
	    				System.out.print( "OK");
	    			}
	    			else if(n == 2) {
	    				student2D.insertRow(inNumber);;
	    				System.out.print( "OK");
	    			}
	    			else {
	    				System.out.print( "ERR");
	    			}  			
	    			break;
	    		case 10: 
	    			// Inicjalizacja
	    			Unbalanced2DArray arr = new Unbalanced2DArray( 3 ); //konstrukcjaobiektu o trzech wierszach
	    			arr.setRowSize( 0, 4 );
	    			arr.setRowSize( 1, 2 );
	    			arr.setRowSize( 2, 5 );
	    			try {
	    			for (int i = 0; i < 4; i++ ) arr.setAt( 0, i, i );
	    			} catch (ArrayIndexOutOfBoundsException e){
	    				System.out.println("ERR");
	    			}
	    			try {
	    			for (int i = 0; i < 2; i++ ) arr.setAt( 1, i, i*10 );
	    			} catch  (ArrayIndexOutOfBoundsException e){
	    				System.out.println("ERR");
	    			}
	    			try {
	    			for (int i = 0; i < 5; i++ ) arr.setAt( 2, i, i*100 );
	    			} catch  (ArrayIndexOutOfBoundsException e){
	    				System.out.println("ERR");
	    			}
	    			System.out.println( "Init OK" );
	    			try {
	    			arr.setAt( 1, 5, -1 );
	    			} catch (ArrayIndexOutOfBoundsException e){
	    				System.out.println("ERR");
	    			}
	    			
	    			try {
	    				arr.setAt( 0, 3, -1 );
		    			} catch (ArrayIndexOutOfBoundsException e){
		    				System.out.println("ERR");
		    			}
	    			
	    			try {
	    				arr.setAt( 1, 5, -1 );
		    			} catch (ArrayIndexOutOfBoundsException e){
		    				System.out.println("ERR");
		    			}
	    			try {
	    				arr.setAt( 10, 0, -1 );
		    			} catch (ArrayIndexOutOfBoundsException e){
		    				System.out.println("ERR");
		    			}
	    			System.out.println( "Section 1 finished" );
	    			Iterator it = arr.iterator();
	    			Iterator r_it = arr.rewIterator();
	    			while ( it.hasNext() ) {
	    			System.out.println( it.next() );
	    			}
	    			System.out.println( "Section 2 finished" );
	    			it = arr.iterator();
	    			try {
	    				it.remove();
		    			} catch (UnsupportedOperationException e){
		    				System.out.println("ERR");
		    			}
	    			System.out.println( "Section 3 finished" );
	    			it = arr.iterator();
	    			System.out.println( it.next());
	    			System.out.println( it.next());
	    			try {
	    				it.remove();
		    			} catch (UnsupportedOperationException e){
		    				System.out.println("ERR");
		    			}
	    			System.out.println( it.next());
	    			System.out.println( "Section 4 finished" );
	    			it = arr.iterator();
	    			while ( it.hasNext() ) {
	    			System.out.println( it.next() );
	    			}
	    			System.out.println( "Section 4 finished" );
	    			while ( r_it.hasNext() ) {
	    			System.out.println( r_it.next() );
	    			}
	    			System.out.println( "Section 5 finished" );
	    			r_it = arr.rewIterator();
	    			while ( r_it.hasNext() ) {
	    			System.out.println( r_it.next() );
	    			}
	    			System.out.println( "Section 5 finished" );
	    			it = arr.iterator();
	    			arr.setAt( 0, 0, -1 );
	    			Iterator it1 = arr.iterator();
	    			System.out.println( it.next() );
	    			System.out.println( "Section 6 finished" );
	    			System.out.println( it1.next() );
	    			System.out.println( "Section 7 finished" );
	    			break;
	    		default:
	    			System.out.println( "Błędna komenda");      
	    	}
	    	}
	    	catch(ArrayIndexOutOfBoundsException e) {
		    	System.out.println("Nie możliwe jest wykonanie takiego polecenia - podana tablica nie takiego indeksu");
		    }
	    	catch(ConcurrentModificationException e) {
		    	System.out.println("Nie możliwe jest wykonanie takiego polecenia - zmodyfikowano tablice i nie moge użyć iteratora");
		    }
	    }

	}

	static int read_command( Boolean debug ) {
		if ( debug ) {
			System.out.println( "0 - koniec" );
			System.out.println( "1 - stworz tablice <-- wybór obiektu z którego będzie składać sie tablica");
			System.out.println( "2 - wstaw kilka wierszy i ustaw ich szerokość");	
			System.out.println( "3 - zmień długość wybranego wiersza");
			System.out.println( "4 - wstaw element");
			System.out.println( "5 - usuń wiersz");		
			System.out.println( "6 - wypełnij natywnie tablice");
			System.out.println( "7 - pokaż zawartość tablicy");
			System.out.println( "8 - pokaż zawartość tablicy odwrotnie");	
			System.out.println( "9 - wstaw jeden wiersz");
			System.out.println( "10 - test");
		
			System.out.print( "Podaj komende: ");
		}
		return read_int();
	}
	
	static void fillIntegersArray(){
		int k = 0;
		for(int i = 0; i < int2D.length(); i++) {
			for(int j = 0; j < int2D.getArray()[i].length(); j++) {
				int2D.setAt(i, j, k);
				k++;
			}
		}
	}
	
	static void fillStudentsArray(){
		int k = 0;
		for(int i = 0; i < student2D.length(); i++) {
			for(int j = 0; j < student2D.getArray()[i].length(); j++) {
				student2D.setAt(i, j, new Student(k, k*50));
				k++;
			}
		}
	}
	
	static String read_str() {
		   return ( in.nextLine() );
	}	

	static int read_int() {
			String s = in.nextLine();
			return Integer.parseInt( s );
	}
	
	public static void showArray() {
		if(n == 1) {
			for(Integer i : int2D) {
				System.out.println(i);
			}
		}
		else if(n == 2) {
			for(Student i : student2D) {
				System.out.println(i);
			}
		}
		else {
			System.out.println("ERR");
		}
	}
	
	public static void showReverseArray() {
		if(n == 1) {
			for(Iterator<Integer> it = int2D.rewIterator(); it.hasNext();)
			{
				System.out.println(it.next());
			}
		}
		else if(n == 2) {
			for(Iterator<Student> it = student2D.rewIterator(); it.hasNext();)
			{
				System.out.println(it.next());
			}
		}
		else {
			System.out.println("ERR");
		}
	}
	
}
