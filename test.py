import unittest
from prime_number_generator import PrimeNumber




class Test(unittest.TestCase):


    def setUp(self):
        self.generator = PrimeNumber.generate
        self.is_prime = PrimeNumber.isPrime


    def test_simple_cases(self):

        self.assertTrue(self.is_prime(11))
        self.assertTrue(self.is_prime(2))
        self.assertTrue(self.is_prime(3))
        self.assertTrue(self.is_prime(7))
    
    def test_2(self):
        self.assertTrue(self.is_prime(7907))

    def test_one_zero_and_negative(self):
        """check if 1 and 0 and negative numbers are False"""
        self.assertFalse(self.is_prime(1))
        self.assertFalse(self.is_prime(0))
        self.assertFalse(self.is_prime(-100))
        self.assertFalse(self.is_prime(-1))


    def test_range_between_7900_and_7920(self):

        self.assertEqual(self.generator(7900,7920),[7901,7907,7919])
    
    def test_first_26(self):
        self.assertEqual(self.generator(1,101),[2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101])

if __name__ == "__main__":
    

    unittest.main(verbosity=2)
