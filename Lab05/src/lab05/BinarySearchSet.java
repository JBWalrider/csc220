package lab05;

public class BinarySearchSet {
	public double[] storage;
	private int capacity;
	private int numItems;
	public BinarySearchSet() {
		storage = new double[6];
		for (double d : storage) {d = 0.0;}
		capacity = storage.length;
		numItems = 0;
	}
	public boolean isEmpty() {
		return numItems == 0;
	}
	public int size() {
		return numItems;
	}
	public void grow() {
		double temp[] = new double[storage.length];
		for (int i = 0; i < storage.length; i++) {temp[i] = storage[i];}
		storage = new double[temp.length*2];
		for (int i = 0; i < storage.length; i++) {storage[i] = i<temp.length ? temp[i] : 0.0;}
		capacity *= 2;
	}
	
	public boolean remove(double value) {
		boolean found = false;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == value) {found = true;}
			if (found) {storage[i] = i >= numItems - 1 ? 0.0 : storage[i+1];}
		}
		if (found) {numItems--;}
		return found;
	}
	public boolean sequential_add(double newVal) {
		boolean found = false;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] == newVal) {found = true;}
		}
		if (!found) {
			if (numItems == capacity) {grow();}
			for (int i = numItems; i > -1; i--) {
				if (i == 0) {storage[0] = newVal; numItems++; break;}
				if (storage[i-1] < newVal) {storage[i] = newVal; numItems++; break;}
				else {storage[i] = storage[i-1];}
			}
		}
		return !found;
	}
	
	public String toString() {
		String s = "";
		for (double d : storage) s+=(d + ",");
		s+=(capacity + "," + numItems);
		return s;
	}
}