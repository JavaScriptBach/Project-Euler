"""
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
"""
def prime_sieve(limit):
	a = [True] * limit                          # Initialize the primality list
	a[0] = a[1] = False

	for (i, isprime) in enumerate(a):
		if isprime:
			for n in xrange(i*i, limit, i):     # Mark factors non-prime
				a[n] = False
	return a
sieve = prime_sieve(2000000)
answer = 0
for num, isprime in enumerate(sieve):
	if isprime:
		answer += num
print answer