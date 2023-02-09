input_arr = []
while True:
    input_str = input()
    if input_str == "99999":
        break
    input_arr.append(input_str)

direction = "" #Not really necessary but pycharm will scream at me without
for input_str in input_arr:
    first2_sum = sum([int(input_str[x]) for x in range(2)])
    if first2_sum % 2 == 0 and first2_sum != 0:
        direction = "right"
    elif first2_sum % 2 == 1:
        direction = "left"
    print(f"{direction} {input_str[2:]}")
