package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

//dp problem
public class NumberTriangle1932 {
	static Integer[][] dpArray = new Integer[600][600];
	static Integer height;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		height = scan.nextInt();

		Integer[][] values = new Integer[height + 1][];

		for (int i = 1; i <= height; i++) {
			values[i] = new Integer[i + 1];
			for (int j = 1; j <= i; j++) {
				values[i][j] = scan.nextInt();
			}
		}
		// confirm
		/*
		 * for(int i=1;i<=height;i++){ for(int j=1;j<=i;j++){
		 * System.out.print(values[i][j]); } System.out.println(); }
		 */
		for (int i = 1; i <= height; i++) {
			Arrays.fill(dpArray[i], -1);
		}
		for (int j = 1; j <= height; j++) {
			calcSum(values, height, j);
		}

		Integer max = 0;
		for (int i = 1; i <= height; i++) {
			//System.out.println(dpArray[height][i]);
			if (max < dpArray[height][i]) {

				max = dpArray[height][i];
			}
		}
		System.out.println(max);
	}

	private static Integer calcSum(Integer[][] values, int row, int col) {
		// TODO Auto-generated method stub
		// base case;
		if (row < 1) {
			return 0;
		}
		if (dpArray[row][col] != -1) {
			return dpArray[row][col];
		}

		Integer max = 0;

		if (col == row) {
			max = calcSum(values, row - 1, col - 1);
		} else if (col == 1) {
			max = calcSum(values, row - 1, col);
		} else if (col > 1) {
			max = Math.max(calcSum(values, row - 1, col - 1),
					calcSum(values, row - 1, col));
		}

		dpArray[row][col] = max + values[row][col];

		return dpArray[row][col];
	}
}
