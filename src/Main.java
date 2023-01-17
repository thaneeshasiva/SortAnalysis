
public class Main {

	public static void main(String[] args) {
		StopWatch stopwatch = new StopWatch();

		int[][] random;
		int[][] nearlySorted;
		int[][] reversed;
		int[][] fewUnique;

		for (int i = 1; i <= 5; i++) {
			// instantiate size of array (10 ^ i)
			random = new int[10][(int) (Math.pow(10, i))];
			nearlySorted = new int[10][(int) (Math.pow(10, i))];
			reversed = new int[10][(int) (Math.pow(10, i))];
			fewUnique = new int[10][(int) (Math.pow(10, i))];

			// generate arrays; for each data distribution, there are 10 arrays containing
			for (int j = 0; j < 10; j++) {
				random[j] = ArrayGen.randomizedArray((int) (Math.pow(10, i)));
				nearlySorted[j] = ArrayGen.nearlySortedArray((int) (Math.pow(10, i)));
				reversed[j] = ArrayGen.reversedArray((int) (Math.pow(10, i)));
				fewUnique[j] = ArrayGen.fewUniqueArray((int) (Math.pow(10, i)));
			}

			// calculate elapsed time for each sort
			double elapsedTime;
			double averageTime = 0;

			System.out.println("Array Size: " + (int) (Math.pow(10, i)));

			for (int k = 0; k < 10; k++) {
				stopwatch.start();
				Sorts.mergeSort(nearlySorted[k]);
				stopwatch.stop();

				elapsedTime = stopwatch.getElapsedTime();
				averageTime += elapsedTime; 
				System.out.println("Insertion Sort Trial #" + (k + 1) + ": " + elapsedTime + " picoseconds");
			}

			averageTime /= 10;
			System.out.println("Average Time: " + averageTime + " picoseconds\n");

		}
	}
}
