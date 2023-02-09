from math import floor
ottawa = int(input())
victoria = (ottawa-300)%2400
edmonton = (ottawa-200)%2400
winnipeg = (ottawa-100)%2400
halifax = (ottawa+100)%2400
john_mins = (ottawa-floor(ottawa/100)*100)+30
john_hours = (floor(ottawa/100)*100+100 + (john_mins//60)*100)%2400

print(f"{ottawa} in Ottawa")
print(f"{victoria} in Victoria")
print(f"{edmonton} in Edmonton")
print(f"{winnipeg} in Winnipeg")
print(f"{ottawa} in Toronto")
print(f"{halifax} in Halifax")
print(f"{john_hours+john_mins%60} in St. John's")
