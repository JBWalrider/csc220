package lab05;

public class BinarySearchSetTester {

	static<T>void out(T o) {System.out.println(o);}
	static<T>void err(T o) {System.err.println(o);}
	static<T>void slp() {try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}}
	
	
	public static void main(String[] a) {
        //double[] te = new double[6];
        //for (int i = 0; i < 6; i++) {te[i] = Math.random()*20; System.out.print(te[i] + ","); System.out.println();}
		//BinarySearchSet b = new BinarySearchSet(te);
		BinarySearchSet b = new BinarySearchSet();
        String s = "";
        if (!(b.isEmpty())) err("Not empty");
		if (!(b.size()==0)) err("Not correct size");
		b.grow();
		s = "0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,12,0";
		if (!(b.size()==0)) err("Not correct after grow");
		if (!(b.toString().equals(s))) err("Not correct after initialization");
		double arr1[] = new double[]{5.0,6.2,8.4,2.8,1.8,9.5,7.6};
		//for (double d : arr1) if (!(b.sequential_add(d)) && !(b.contains(d))) err("Not returning true for arr1");
		for (double d : arr1) if (!(b.binary_add(d)) || !(b.contains(d))) err("Not returning true for arr1");
		for (double d : new double[]{3.3,6.4}) if (b.contains(d)) err("contains: Should not contain element " + d);
		if (!(b.containsAll(arr1))) err("containsAll: Should contain elements in arr1");
		if (b.containsAll(new double[]{3.3,6.4,5.0})) err("containsAll: Should not contain elements (arr1 test)");
		s = "1.8,2.8,5.0,6.2,7.6,8.4,9.5,0.0,0.0,0.0,0.0,0.0,12,7";
		//if (!(b.toString().equals(s))) err("Not correct after adding arr1");
		double arr2[] = new double[]{5.1,6.3,8.5,2.9,1.9,9.6,7.7,0.2,1.9};
		//for (double d : arr2) if (!(b.sequential_add(d)) && !(b.contains(d)) && !(d == 1.9)) err("Not returning true for arr2");
		for (double d : arr2) if (!(b.binary_add(d)) && !(b.contains(d)) && !(d == 1.9)) err("Not returning true for arr2");
		for (double d : new double[]{3.3,6.4}) if (b.contains(d)) err("contains: Should not contain element " + d);
		if (!(b.containsAll(arr2))) err("containsAll: Should contain elements in arr2");
		if (b.containsAll(new double[]{3.3,6.4,5.0})) err("containsAll: Should not contain elements (arr2 test)");
		s = "0.2,1.8,1.9,2.8,2.9,5.0,5.1,6.2,6.3,7.6,7.7,8.4,8.5,9.5,9.6,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,24,15";
		//if (!(b.toString().equals(s))) err("Not correct after adding arr2");
		for (double d : arr2) {b.remove(d);}
		s = "1.8,2.8,5.0,6.2,7.6,8.4,9.5,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,24,7";
		//if (!(b.toString().equals(s))) err("Not correct after removing arr2");
		for (double d : arr1) {b.remove(d);}
		s = "0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,24,0";
		//if (!(b.toString().equals(s))) err("Not correct after removing arr1");
		out("Testing done.");
	}

}