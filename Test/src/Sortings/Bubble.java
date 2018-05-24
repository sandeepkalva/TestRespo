package Sortings;

import java.util.Arrays;
import java.util.Random;

public class Bubble {
	public static void main(String[] args) {
		int[] data = new Random().ints(1,20).limit(10).toArray();
		sort(data);
		print(data);
	}

	private static void print(int[] data) {
		Arrays.stream(data).forEach(i->System.out.print(i+", "));
	}

	private static void sort(int[] data) {
		for(int i =0 ;i<data.length;i++) {
			for(int j=0;j<data.length;j++) {
				if(data[i]>data[j]) {
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
	}
}
