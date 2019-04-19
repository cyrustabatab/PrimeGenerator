import unittest
from prime_number_generator import PrimeNumber


class Test(unittest.TestCase):

    
    def setUp(self):
        self.generator = PrimeNumber.generate
        self.is_prime = PrimeNumber.isPrime
        self.first_million_primes = Test.get_first_n_primes("primes1.txt")
    
    @staticmethod
    def get_first_n_primes(f):
        primes = []
        with open(f,'r') as f:
            for line in f: 
                for prime in line.split():
                    primes.append(int(prime))
        
        return primes

    def test_simple_cases(self):

        self.assertTrue(self.is_prime(11))
        self.assertTrue(self.is_prime(2))
        self.assertTrue(self.is_prime(3))
        self.assertTrue(self.is_prime(7))
    
    def test_random_large_primes(self):
        self.assertTrue(self.is_prime(9533))
        self.assertTrue(self.is_prime(13297))

    def test_one_zero_and_negative(self):
        """check if 1 and 0 and negative numbers are False"""
        self.assertFalse(self.is_prime(1))
        self.assertFalse(self.is_prime(0))
        self.assertFalse(self.is_prime(-100))
        self.assertFalse(self.is_prime(-1))
    
    
    def test_all_first_million_primes_generated(self):

        self.assertEqual(self.generator(1,15485863),self.first_million_primes)
    
    def test_is_prime_for_first_one_hundred_thousand(self):
        return all([self.is_prime(n) for n in self.first_million_primes[:100000]])
    
    def test_not_prime_for_composite_up_to_millionth_prime(self):
        first_million_set = set(self.first_million_primes)
        
        return not any([self.isPrime(n) for n in self.first_million_primes if n not in first_million_set])

    def test_range_between_7900_and_7920(self):

        self.assertEqual(self.generator(7900,7920),[7901,7907,7919])
    
    def test_first_26(self):
        self.assertEqual(self.generator(1,101),[2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101])

if __name__ == "__main__":
    
    unittest.main(verbosity=2)
