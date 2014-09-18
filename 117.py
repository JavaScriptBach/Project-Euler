"""
Using a combination of black square tiles and oblong tiles chosen from: red tiles measuring two units, green tiles measuring three units, and blue tiles measuring four units, it is possible to tile a row measuring five units in length in exactly fifteen different ways.

				
			
			
			
			
		
		
		
		
		
		
	
	
	
	
 
How many ways can a row measuring fifty units in length be tiled?

NOTE: This is related to Problem 116.
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

answer = count_ways(50, [1, 2, 3, 4])
print answer