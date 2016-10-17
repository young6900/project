"""
Game

 * Author       :고영준
 * Created      :고영준
 * Last modified:고영준
"""
import random
i = 0
while i<10 :

 
    player = input("Enter your choice (rock/paper/scissors): ")
    player = player.lower()
    while (player != "rock" and player != "paper" and player != "scissors"):
        player = input("Enter your choice (rock/paper/scissors): ")
        player = player.lower()


    computer = random.randint(1,3)
    if (computer == 1):
        computer = "rock"
    elif (computer == 2):
        computer = "paper"
    elif (computer == 3):
        computer = "scissors"
    else:
        print ("Error. Enter your choice from rock, paper, scissors.")


    if (player == computer):
        print ("Draw!")
    elif (player == "rock"):
        if (computer == "paper"):
            print ("You won.");
        if (computer == "scissors"):
            print ("You lost.");
    elif (player == "paper"):
        if (computer == "rock"):
            print ("You won.");
        if (computer == "scissors"):
            print ("You lost.");
    elif (player == "scissors"):
        if (computer == "rock"):
            print ("You lost.");
        if (computer == "paper"):
            print ("You won.");
    i = i+1

