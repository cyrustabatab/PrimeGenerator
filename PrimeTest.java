import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
public class PrimeTest {
	
	
	
	@Test
	public void testGenerateEasyPrimes() {
		
		PrimeGenerator pg = new PrimeGenerator();
		List<Integer> primes = pg.generate(1, 10);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(2,3,5,7));
		assertEquals(primes,expected);
	}

	
	@Test
	public void testGenerate7900To7920() {
		
		PrimeGenerator pg = new PrimeGenerator();
		List<Integer> primes = pg.generate(7900,7920);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(7901,7907,7919));
		assertEquals(primes,expected);
		primes = pg.generate(7920,7900);
		
		assertEquals(primes,expected);
	}
	
	@Test
	public void testGenerateFirst26WithNegativeStart() {
		
		PrimeGenerator pg = new PrimeGenerator();
		List<Integer> primes = pg.generate(-100,102);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
				97, 101));
		assertEquals(primes,expected);
	}
	
	@Test
	public void testGenerateOneNumberRange() {
		
		PrimeGenerator pg = new PrimeGenerator();
		List<Integer> primes = pg.generate(11,11);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(11));
		assertEquals(primes,expected);
		primes = pg.generate(25,25);
		assertTrue(primes.isEmpty());
	}
	
	@Test
	public void testGreaterStart() {
		
		PrimeGenerator pg = new PrimeGenerator();
		List<Integer> primes = pg.generate(20,11);
		List<Integer> expected = new ArrayList<Integer>(Arrays.asList(11,13,17,19));
		
		assertEquals(primes,expected);
	}
	
	@Test
	public void testEmptyRange() {
		PrimeGenerator pg = new PrimeGenerator();
		List<Integer> primes = pg.generate(-100, -10);
		
		assertTrue(primes.isEmpty());
		
		primes = pg.generate(-1000, 1);
		assertTrue(primes.isEmpty());
	
	}
	

}
