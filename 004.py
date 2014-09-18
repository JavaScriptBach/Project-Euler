#coding=utf-8
"""
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
"""
def is_palindrome(num):
	string = str(num)
	for i in range(0, len(string) / 2):
		if string[i] != string[len(string) - 1 - i]:
			return False
	return True
num = 0
for i in range(100, 1000):
	for j in range(100, 1000):
		if is_palindrome(i * j) and i * j > num:
			num = i * j
print num