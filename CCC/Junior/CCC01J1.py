from math import ceil
h = int(input())
for x in range(h//2+1):
    print("*"*(2*x+1) + " "*(h*2-2*(2*x+1)) + "*"*(2*x+1))
for x in range(h//2-1,-1,-1):
    print("*"*(2*x+1) + " "*(h*2-2*(2*x+1)) + "*"*(2*x+1))
