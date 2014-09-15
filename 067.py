"""
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
"""
def read_line_into_row(line, arr, index):
	tokens = line.split(" ")
	for j, num in enumerate(tokens):
		arr[index][j] = int(num)

def solve(arr):
	for i in reversed(range(len(arr) - 1)):
		for j in range(i + 1):
			arr[i][j] += max(arr[i+1][j], arr[i+1][j+1])

f = open("p067_triangle.txt")
arr = [[0 for x in range(100)] for x in range(100)]
for i, line in enumerate(f):
	read_line_into_row(line, arr, i)
solve(arr)
print arr[0][0]