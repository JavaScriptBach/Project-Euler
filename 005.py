"""
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
"""
def highest_power(factor, limit):
	answer = 0
	for num in range(factor, limit + 1):
		current = 0
		while num % factor == 0:
			num /= factor
			current += 1
		if current > answer:
			answer = current
	return answer
primes = [2, 3, 5, 7, 11, 13, 17, 19]
powers = []
for prime in primes:
	powers.append(highest_power(prime, 20))
answer = 1
for i in range(0, len(primes)):
	next = primes[i] ** powers[i]
	answer *= next
print answer