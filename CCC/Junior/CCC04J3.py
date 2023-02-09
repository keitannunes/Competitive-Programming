n = int(input())
m = int(input())
adj = [input() for x in range(n)]
noun = [input() for x in range(m)]
for x in range(n):
    for y in range(m):
        print(f"{adj[x]} as {noun[y]}")
