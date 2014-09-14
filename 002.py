"""
Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
"""

def generate_fibs(limit):
	if limit < 1:
		return []
	output = [1]
	first = 1
	second = 2
	while second <= limit:
		output.append(second)
		third = first + second
		first = second
		second = third
	return output

fibs = generate_fibs(4000000)
answer = 0
for i in fibs:
	if i % 2 == 0:
		answer += i
print answer