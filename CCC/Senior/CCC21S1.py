n = int(input()) #num of bottom pieces
sides = list(map(int,input().strip().split(" ")))
bottom = list(map(int,input().strip().split(" ")))
print(sum([bottom[x]*(sides[x]+sides[x+1])/2 for x in range(n)]))
