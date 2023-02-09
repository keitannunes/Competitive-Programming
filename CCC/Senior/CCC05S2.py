c_r = tuple(map(int,input().split(" ")))
pos = (0,0)
while True:
    relative = tuple(map(int, input().split(" ")))
    pos = (max(0,min(c_r[0],pos[0]+relative[0])),max(0,min(c_r[1],pos[1]+relative[1])))
    if relative == (0,0):
        break
    else:
        print(pos[0],pos[1])
