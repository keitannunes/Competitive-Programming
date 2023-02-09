rhymes = []
for i in range(int(input())):
    last_words = [input().lower().split(" ")[-1] for x in range(4)]
    #syllables = [x.split("a")[-1].split("e")[-1].split("i")[-1].split("o")[-1].split("u")[-1] if any(j in "aeiou" for j in x) else x for x in last_words]
    syllables = []
    for x in last_words:
        if x[-1] in "aeiou":
            syllables.append(x[-1])
        elif any(j in "aeiou" for j in x):
            last_index = 0
            for vowel in "aeiou":
                try:
                    if x.rindex(vowel) > last_index:
                        last_index = x.rindex(vowel)
                except:
                    continue
            syllables.append(x[last_index:])
        else:
            syllables.append(x)

    if syllables[0] == syllables[1] == syllables[2] == syllables[3]:
        rhymes.append("perfect")
    elif syllables[0] == syllables[1] and syllables[2] == syllables[3]:
        rhymes.append("even")
    elif syllables[0] == syllables[2] and syllables[1] == syllables[3]:
        rhymes.append("cross")
    elif syllables[0] == syllables[3] and syllables[1] == syllables[2]:
        rhymes.append("shell")
    else:
        rhymes.append("free")
for i in rhymes: print(i)
