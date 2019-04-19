import unittest
import math
import sys



class PrimeNumber:


    @staticmethod
    def generate(startingValue,endingValue):
        #sieve of erasthonees
    
        marked = set()
        marked.add(1)
        
        for n in range(2,int(math.ceil(math.sqrt(endingValue + 1)))):
            if n in marked:
                continue

            for j in range(n*n,endingValue + 1,n):
                if j % n == 0:
                    marked.add(j)


        #generator 
        return [n for n in range(startingValue,endingValue + 1) if n not in marked]
        



    @staticmethod
    def isPrime(value):
        
        if value <= 1:
            return False

        if value == 2:
            return True

        if value % 2 == 0:
            return False
        
        
        i = 3
        while i**2 <= value:
            if value % i == 0:
                return False
            i += 1
        
        return True



def handle_arguments(arg1,arg2):
    
    #if arguments are less than or equal to zero raise it to 1
    if arg1 <= 0:
        arg1 = 1

    if arg2 <= 0:
        arg2 = 1

    arg1 = int(math.ceil(arg1))
    arg2 = int(math.ceil(arg2))
    
    arg1 = min(arg1,arg2)
    arg2 = max(arg1,arg2)

    return arg1,arg2



if __name__ == "__main__":
    
    #python prime_number_generator.py 1 10
    if len(sys.argv) != 3:
        print("Please enter start and end range(python prime_number_generator n1 n2)")
        sys.exit()
    
    try:
        arg1 = float(sys.argv[1]) #i will allow for users to enter decimals such as 45.2 and will ceil it
        arg2 = float(sys.argv[2])
    except:
        raise ValueError("Please enter INTEGERS for the ranges")
    else:
        start,end = handle_arguments(arg1,arg2)


    
    primes = PrimeNumber.generate(start,end)
    
    print(primes)


        

