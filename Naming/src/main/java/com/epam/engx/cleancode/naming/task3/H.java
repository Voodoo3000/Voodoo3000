package com.epam.engx.cleancode.naming.task3;

public class H {

	// print some Harshad numbers
	public static void main(String[] args) {
		long L = 1000; // limit the seq of Harshad numbers
		for (int i = 1; i <= L; i++) {
			if (i % loop(i) == 0) {
				System.out.println(i);
			}
		}
	}

	private static int loop(int N) {
		int S = 0;
		while (N != 0) {
            S += N % 10;
            N = N / 10;
        }
		return S;
	}

}
