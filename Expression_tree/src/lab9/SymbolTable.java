package lab9;

import java.util.HashMap;

public class SymbolTable {
	// klasa do reprezentacji wartości zmiennych
	
	HashMap<String, Float> table = new HashMap<String, Float>();
	
	void Set( String ident, float value ) {
	// przypisuje wartość zmiennej
		table.put(ident, value);
	}
	
	Float ValueOf( String ident ) {
	// zwraca wartość zmiennej, jeśli zmienna nie zdefiniowana
	// to zwraca Float.NaN
		return table.get(ident);
	}
}

