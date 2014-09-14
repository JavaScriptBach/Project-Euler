"""
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
"""

def arithmetic_series(first_term, last_term, num_terms):
	return (first_term + last_term) * num_terms / 2

def sum_multiples(multiple, limit):
	last_term = (limit - 1) / multiple * multiple
	num_terms = (last_term - multiple) / multiple + 1
	return arithmetic_series(multiple, last_term, num_terms)
answer = sum_multiples(3, 1000) + sum_multiples(5, 1000) - sum_multiples(15, 1000)
print answer