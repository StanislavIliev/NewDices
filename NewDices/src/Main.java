import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {

		HashMap<Integer, Integer> combination = new HashMap<Integer, Integer>();
		double winChance = 0;

		fillInCombinations(combination);

		for (Map.Entry<Integer, Integer> entry : combination.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			if (key == 7 || key == 11) {

				// chance of win on the first throw. Need to check how many 7 and 11
				// are reached and divide the total by the number of the all number of
				// probabilities 6*6 =36.

				winChance += (double) (combination.get(key)) / 36;
			}
			// as we need the chance of win, we do not care and do not check the other cases
			// of loose.

			if (key == 4 || key == 5 || key == 6 || key == 8 || key == 9 || key == 10) {
				winChance += winAtSecondChane(key, value);
			}

		}
		System.out.printf("The chance of the player to win is %.2f%%.%n", 100 * winChance);
	}

	// private method just to fill the Hashmap with all the possible totals like
	// keys,
	// and of course the value of each key-how many times can be reached out of
	// 6*6=36.

	private static void fillInCombinations(HashMap<Integer, Integer> combination) {

		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {
				int suma = i + j;
				if (combination.containsKey(suma)) {
					int current = combination.get(suma);
					current++;
					combination.put(suma, current);
				} else {
					combination.put(suma, 1);
				}
			}
		}
	}

	// private method which calculate the chance of win in each case 4,5,6,8,9,10.
	// Need to be added the chance of win on the first throw so to reach the result.

	private static double winAtSecondChane(Integer key, Integer value) {
		double chanceOfWin = 0;
		chanceOfWin = (double) value / 36 * value / (value + 6);
		return chanceOfWin;
	}
}