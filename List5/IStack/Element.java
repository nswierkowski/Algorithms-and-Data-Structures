package IStack;

public class Element<E> {
 
		private E value;
		private Element next;
		
		public E getValue() {
			return value;
		}
		
		public void setValue(E value) {
			this.value = value;
		}
		
		public Element getNext() {
			return next;
		}
		
		public void setNext(Element next) {
			this.next = next;
		}
		
		public Element(E data){
			this.value = data;
		}

		public boolean equals(Element e) {
			if(value.equals(e.getValue()) && next.getValue().equals(e.getNext().getValue()) ) return true;
			return false;
		}
	}

