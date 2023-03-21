package lab2;


public class Student {
	
		int indexNo;
		double scholarship;
		
		public Student(int no, double amount){
			indexNo = no;
			scholarship = amount;
		}
		
		public void increaseScholarship(double amount){
			scholarship += amount;
		}
		
		public void showData(){
			System.out.printf("%6d %8.2f\n",indexNo,scholarship);
		}
		
		public String toString() {
			return indexNo + " " +scholarship;
		}
	}

