

def get_first_10000_primes(f):
    primes = []
    with open(f,'r') as f:
        for line in f: 
            for prime in line.split():
                primes.append(int(prime))
    print(primes) 
    return primes


primes = get_first_10000_primes("primes1.txt")
