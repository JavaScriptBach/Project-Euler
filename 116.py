"""
A row of five black square tiles is to have a number of its tiles replaced with coloured oblong tiles chosen from red (length two), green (length three), or blue (length four).

If red tiles are chosen there are exactly seven ways this can be done.

			
			
			
			
		
		
		
 
If green tiles are chosen there are three ways.

		
		
		
 
And if blue tiles are chosen there are two ways.

	
	
Assuming that colours cannot be mixed there are 7 + 3 + 2 = 12 ways of replacing the black tiles in a row measuring five units in length.

How many different ways can the black tiles in a row measuring fifty units in length be replaced if colours cannot be mixed and at least one coloured tile must be used?

NOTE: This is related to Problem 117.
"""

def count_ways(length, choices):
	return count_ways_recursive(length, choices, {})

def count_ways_recursive(remaining, choices, cache):
	if remaining < 0:
		return 0
	if remaining == 0:
		return 1
	answer = 0
	for choice in choices:
		if remaining - choice not in cache:
			cache[remaining - choice] = count_ways_recursive(remaining - choice, choices, cache)
		answer += cache[remaining - choice]
	return answer

answer = count_ways(50, [1, 2]) + count_ways(50, [1, 3]) + count_ways(50, [1, 4]) - 3
print answer
