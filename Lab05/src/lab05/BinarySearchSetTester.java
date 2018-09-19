package lab05;

public class BinarySearchSetTester {

	public static void main(String[] args) {
		BinarySearchSet b = new BinarySearchSet();
		String s = "";
		if (!(b.isEmpty())) System.err.println("Not empty");
		if (!(b.size()==0)) System.err.println("Not correct size");
		b.grow();
		s = "0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,12,0";
		//System.out.println(s);
		//System.out.println(b);
		if (!(b.size()==0)) System.err.println("Not correct after grow");
		if (!(b.toString().equals(s))) System.err.println("Not correct after initialization");
		double arr1[] = new double[]{5.0,6.2,8.4,2.8,1.8,9.5,7.6};
		for (double d : arr1) {b.sequential_add(d);}
		s = "1.8,2.8,5.0,6.2,7.6,8.4,9.5,0.0,0.0,0.0,0.0,0.0,12,7";
		//System.out.println(s);
		//System.out.println(b);
		if (!(b.toString().equals(s))) System.err.println("Not correct after adding arr1");
		double arr2[] = new double[]{5.1,6.3,8.5,2.9,1.9,9.6,7.7,0.2};
		for (double d : arr2) {b.sequential_add(d);}
		s = "0.2,1.8,1.9,2.8,2.9,5.0,5.1,6.2,6.3,7.6,7.7,8.4,8.5,9.5,9.6,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,24,15";
		//System.out.println(s);
		//System.out.println(b);
		if (!(b.toString().equals(s))) System.err.println("Not correct after adding arr2");
		for (double d : arr2) {b.remove(d);}
		s = "1.8,2.8,5.0,6.2,7.6,8.4,9.5,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,24,7";
		//System.out.println(s);
		//System.out.println(b);
		if (!(b.toString().equals(s))) System.err.println("Not correct after removing arr2");
		System.out.println("Testing done.");
	}

}