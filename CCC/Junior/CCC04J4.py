def encrypt(key, string):
    counter = 0
    result = ''
    for i in string:
        if i.isalpha():
            result += chr((ord(i)+ord(key[counter % len(key)])) % 26 + 65)
            counter += 1
    return result


print(encrypt(input(), input()))
