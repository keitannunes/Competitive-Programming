#https://dmoj.ca/problem/ccc05j3

dirs = []
streets = []
while True:
    input_dir = input()
    if input_dir == "R":
        dirs.append("LEFT")
    else:
        dirs.append("RIGHT")
    input_street = input()
    if input_street == "SCHOOL":
        break
    else:
        streets.append(input_street)
for i in range(len(dirs)-1,-1,-1):
    if i != 0:
        print(f"Turn {dirs[i]} onto {streets[i-1]} street.")
    else:
        print(f"Turn {dirs[i]} into your HOME.")
