"""
Georgia Institute of Technology - CS1301
Homework 08 - Object Oriented Programming
"""

class Mario:

    def __init__(self, name):
        self.name = name
        self.lives = 3
        self.coins = 0
        self.isAlive = True
    def gainCoins(self, arg=None):
        if arg is None:
            self.coins += 5
        else:
            self.coins += arg
    def loseLife(self):
        if self.lives > 0:
            self.lives = self.lives - 1
            if self.lives == 0:
                self.isAlive = False
        else:
            self.isAlive = False
    def gainLife(self):
        if self.lives > 0 and self.lives < 3:
            self.lives += 1
        elif self.lives == 3:
            self.coins += 10
        else:
            pass
    def __str__(self):
        return "Hi! I am " + self.name + ". I have " + str(self.lives) + " lives left and " + str(self.coins) + " coins."
    # the following method is provided to you
    def __eq__(self, other):
        return (self.name == other.name and
                self.lives == other.lives and
                self.coins == other.coins and
                self.isAlive == other.isAlive)

    # the following method is provided to you
    def __repr__(self):
        return f"Mario({self.name})"


##########################################################


class Bowser:

    def __init__(self, name):
        self.name = name
        self.lives = 5
        self.isAlive = True
    def loseLife(self):
        if self.lives > 0:
            self.lives = self.lives - 1
            if self.lives == 0:
                self.isAlive = False
        else:
            self.isAlive = False
    def __str__(self):
        return "Hi! I am " + self.name + " and I have " + str(self.lives) + " lives left."
    # the following method is provided to you
    def __eq__(self, other):
        return (self.name == other.name and
                self.lives == other.lives and
                self.isAlive == other.isAlive)

    # the following method is provided to you
    def __repr__(self):
        return f"Bowser({self.name})"


##########################################################


class World:
    def __init__(self, name, bowser, characters=None):
        self.name = name
        self.bowser = bowser
        self.isWon = False
        if characters is None:
            self.characters = ()
        else:
            self.characters = characters
    def __str__(self):
        if self.isWon == False:
            return self.name + " has not been won yet."
        elif self.isWon == True:
            return self.name + " has been won!"
    def addChar(self, char_name):
        if char_name not in self.characters:
            self.characters = self.characters + (char_name, )
        else:
            index = self.characters.index(char_name)
            return self.characters[index].name + " already exists in " + str(self.name) + "."
    def removeChar(self, char_name):
        if char_name in self.characters:
            listx = list(self.characters)
            listx.remove(char_name)
            self.characters = tuple(listx)
    def runInto(self, obj, char_name):
        if obj == "mushroom":
            char_name.gainLife()
        elif obj == "goomba":
            char_name.loseLife()
            if char_name.isAlive == False:
                self.removeChar(char_name)
            else:
                pass
        elif obj == "coin":
            char_name.gainCoins(5)
        else:
            pass
    def fight(self, arg1, arg2, win):
        if win == True:
            arg1.coins += 20
            arg2.loseLife()
            if arg2.isAlive == False:
                self.gameOver()
        elif win == False:
            arg1.loseLife()
            if arg1.isAlive is False:
                self.removeChar(arg1)
                self.gameOver()
    def gameOver(self):
        if len(self.characters) > 0:
            for each in self.characters:
                if each.isAlive is True and self.bowser.isAlive is False:
                    self.isWon = True
                    x = "Mario Team Wins!"
                    break
            return x
        elif len(self.characters) == 0 and self.bowser.isAlive is True:
            self.isWon = True
            return "Mario Team loses."
    def __repr__(self):
        return f"World({self.name}, {self.bowser})"
    
