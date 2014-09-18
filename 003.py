"""
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
"""
from math import sqrt
def isPrime(n):
	for i in range(2, int(sqrt(n) + 1)):
		if n % i == 0:
			return False
	return True

def get_next_prime(n):
	n += 1
	while not isPrime(n):
		n += 1
	return n
def largest_prime_factor(n):
	current_prime = 2
	while not isPrime(n):
		while n % current_prime == 0:
			n /= current_prime
		current_prime = get_next_prime(current_prime)
	return n

print largest_prime_factor(600851475143)