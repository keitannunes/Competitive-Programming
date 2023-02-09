from math import ceil
num = int(input())
den = int(input())

def gcd(a,b):
    if a == 0:
        return b
    elif b == 0:
        return a
    return gcd(b,a%b)

if num%den == 0:
    print(num//den)
elif num//den == 0:
    gcd = gcd(num%den,den)
    print(f"{(num%den)//gcd}/{den//gcd}")
else:
    gcd = gcd(num%den,den)
    print(f"{num//den} {(num%den)//gcd}/{den//gcd}")
