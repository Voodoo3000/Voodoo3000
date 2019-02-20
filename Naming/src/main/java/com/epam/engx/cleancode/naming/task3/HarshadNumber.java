package com.epam.engx.cleancode.naming.task3;

public class HarshadNumber {

	// print some Harshad numbers
	public static void main(String[] args) {
		long sequenceLimit = 1000;
		for (int i = 1; i <= sequenceLimit; i++) {
			if (i % getSequentialNumber(i) == 0) {
				System.out.println(i);
			}
		}
	}

	private static int getSequentialNumber(int iterationNumber) {
		int sequence = 0;
		while (iterationNumber != 0) {
            sequence += iterationNumber % 10;
            iterationNumber = iterationNumber / 10;
        }
		return sequence;
	}

}
