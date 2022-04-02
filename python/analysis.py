# This script is used to generate the pie chart
import matplotlib.pyplot as plt
import random

# Open file
file = open("assets\\englishtags.txt") # PUT TAG FILE HERE

# Dump file
dict = {}
for line in file.readlines():
    # Make sure line is not empty
    if line != "\n":
        # Get values from line
        splits = line.split("=")

        name = splits[0]
        value = int(splits[1].rstrip())

        # Add line to dict
        dict[name] = value

# Setup matplotlib
x = []
y = []
for val in dict:
    x.append(dict[val])
    y.append(val)

# Only get certain amount
newX = []
newY = []
max = 9
for a in range(0, len(x)):
    if len(newX) <= max:
        newX.append(x[a])
        newY.append(y[a])
    else:
        for b in range(0, len(newX)):
            if x[a] > newX[b]:
                newX[b] = x[a]
                newY[b] = y[a]
                break

print(newX)
print(newY)

# Colour func
def colour (y):
    colours = []
    r = lambda: random.randint(0,255)
    for col in y:
        random.seed(col)
        colours.append('#%02X%02X%02X' % (r(),r(),r()))

    return colours


plt.pie(newX, labels=newY, labeldistance=1.15, wedgeprops = {'linewidth' : 1, 'edgecolor' : 'white'}, colors=colour(newY))
plt.show()