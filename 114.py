"""
A row measuring seven units in length has red blocks with a minimum length of three units placed on it, such that any two red blocks (which are allowed to be different lengths) are separated by at least one black square. There are exactly seventeen ways of doing this.

						
				
				
				
				
				
		
			
			
			
			
		
		
		
	
	

 
How many ways can a row measuring fifty units in length be filled?

NOTE: Although the example above does not lend itself to the possibility, in general it is permitted to mix block sizes. For example, on a row measuring eight units in length you could use red (3), black (1), and red (4).
"""

def count_ways(length):
	return count_ways_recursive(length, {})

def count_ways_recursive(remaining, cache):
	if remaining == 0:
		return 1
	# Try a black block
	if remaining - 1 not in cache:
		cache[remaining - 1] = count_ways_recursive(remaining - 1, cache)
	answer = cache[remaining - 1]
	# Try a red block followed by a black block
	for choice in range(4, remaining + 1):
		if remaining - choice not in cache:
			cache[remaining - choice] = count_ways_recursive(remaining - choice, cache)
		answer += cache[remaining - choice]
	# Try a red block that extends all the way to the end
	if remaining >= 3:
		answer += 1
	return answer

answer = count_ways(50)
print answer