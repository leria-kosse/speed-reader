package edu.grinnell.csc207.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class ThirdGreatestTests {
	
	@Test
	public void exampleUnitTest() {
		int[] arr = { 3, 8, 4, 7, 2 };
		assertEquals(4, Functions.thirdGreatest(arr));
	}
	
	// TODO: add additional unit tests here!
	
	@Property
	public boolean examplePropertyTest(@ForAll @IntRange(min = 1, max = 1000) int sz,
									   @ForAll int k) {
		int[] arr = new int[sz];
		for (int i = 0; i < sz; i++) {
			arr[i] = k;
		}
		return Functions.thirdGreatest(arr) == k;
	}
		
	// TODO: add additional property tests here!
}
