package lab01;

public class CoinFlipExperiment {
	
	public static void main(String[] args) {
		int amount = coinFlipExperiment();
		System.out.println("Win/loss amount: " + amount);
	}
	
	public static int coinFlipExperiment() {
		int amount = 0;
		for (int i = 0; i < 100; i++) {
			if (Math.random() < 0.505) {
				amount++;
			}
			else {
				amount--;
			}
		}
	return amount;
	}
	
}
