while True:
    area = int(input())
    if area:
        factors = []
        for i in range(1,area+1):
            if area % i == 0:
                factors.append(i)
        a = factors[len(factors)//2]
        b = area//a
        print(f"Minimum perimeter is {a * 2 + b * 2} with dimensions {b} x {a}")
    else: break
