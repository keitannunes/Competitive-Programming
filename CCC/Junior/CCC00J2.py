def check_ends(string):
    if len(string) == 1:
        if string in "018":
            return True
        else:
            return False
    if len(string) == 0:
        return True
    if string[0] in "018":
        if string[0] == string[-1]:
            return check_ends(string[1:-1])
        else:
            return False
    elif string[0] == "6" and string[-1] == "9" or string[0] == "9" and string[-1] == "6":
        return check_ends(string[1:-1])
    else:
        return False

running_sum = 0
for x in range(int(input()),int(input())+1):
    if check_ends(str(x)):
        running_sum += 1
print(running_sum)
