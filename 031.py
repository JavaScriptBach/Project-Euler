# coding=utf-8
"""
In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
"""
def count_ways(target, choices):
	return count_ways_recursive(target, choices, 0, {})

def count_ways_recursive(remaining, choices, choice_index, cache):
	if remaining < 0 or choice_index == len(choices):
		return 0
	if remaining == 0:
		return 1
	key1 = (remaining - choices[choice_index], choice_index)
	if key1 not in cache:
		cache[key1] = count_ways_recursive(remaining - choices[choice_index], choices, choice_index, cache)
	key2 = (remaining, choice_index + 1)
	if key2 not in cache:
		cache[key2] = count_ways_recursive(remaining, choices, choice_index + 1, cache)
	return cache[key1] + cache[key2]

print count_ways(200, [1, 2, 5, 10, 20, 50, 100, 200])