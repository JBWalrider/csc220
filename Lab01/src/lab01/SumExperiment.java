package lab01;

public class SumExperiment {
	
	public static int check_sum(int[] array){
		int a = 0;
		int b = array.length - 1;
		int sum = 0;
		for (int i = 0; i < array.length - 1; i++) {
			sum = array[a] + array[b];
			if (sum > 20) {
				b--;
			}
			else if (sum < 20) {
				a++;
			}
			else {
				return a;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] array1 = new int[]{5, 7, 8, 9, 10, 15, 16};
		if (check_sum(array1) != 0)
			System.err.println("TEST1 FAILED");
		
		int[] array2 = new int[]{3, 5, 8, 9, 10, 15, 16};
		if (check_sum(array2) != 1)
			System.err.println("TEST2 FAILED");

		
		int[] array3 = new int[]{3, 4, 6, 9, 10, 14, 15};
		if (check_sum(array3) != 2)
			System.err.println("TEST3 FAILED");
		
		int[] array4 = new int[]{6, 7, 8, 9, 10, 15, 16};
		if (check_sum(array4) != -1)
			System.err.println("TEST4 FAILED");
		
		System.out.println("Done!!!");
	}
}
