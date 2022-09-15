package lab9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	// klasa reprezentująca cały program
	
	List<TreeExpr> trees;
	SymbolTable st;
	TreeExpr t;
	
	public Program(){
		trees = new ArrayList();
		st = new SymbolTable();
		t = new TreeExpr();
	}
	
	void ReadFromFile( String fname ) {
		/* wczytuje program ze wskazanego pliku i buduje strukturę
		 danych reprezentującą kolejne instrukcje
		 z wykorzystaniem TreeExpr.
		 Dostępne komendy w pliku to 
		  - PRINT - służy do wyświetlania wartości konkretnego znaku
		  - DO - komenda oznaczająca przyjmij za następny znak wynik działania z następnej linii */ 
			try {
				Scanner sc = new Scanner(new FileReader(fname));
				while(sc.hasNext()) {
					String word = sc.next();
					if(word.equals("PRINT")) {
						String variable = sc.next();
						System.out.println(variable +" = "+ st.ValueOf(variable));
					}
					else if(word.equals("DO")) {
						String variable = sc.next();
						sc.nextLine();
						String prefix = sc.nextLine();
						t = new TreeExpr();
						t.Build(prefix);
						st.Set(variable, t.Eval(st));
					}
					else {
						sc.next();
						if(sc.hasNextFloat()) {
							Float f = sc.nextFloat();
							st.Set(word, f);
						}
						else {
							String expression = sc.nextLine();
							t = new TreeExpr();
							t.Build(expression);
							st.Set(word, t.Eval(st));
						}
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	
	void Execute() {
	// wykonuje wczytany program
		for(TreeExpr t : trees) System.out.println(t.Eval(st));
	}
}
