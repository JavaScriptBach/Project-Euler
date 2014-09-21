"""
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
"""
def prime_sieve(limit):
	a = [True] * limit                          # Initialize the primality list
	a[0] = a[1] = False

	for (i, isprime) in enumerate(a):
		if isprime:
			for n in xrange(i*i, limit, i):     # Mark factors non-prime
				a[n] = False
	return a
sieve = prime_sieve(1000000) # ought to be enough by the prime number theorem.
prime = 0
for num, isprime in enumerate(sieve):
	if isprime:
		prime += 1
		if prime == 10001:
			print num
			break