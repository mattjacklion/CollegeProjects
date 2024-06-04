// Written by Matthew Jackson
import java.util.Random; // Imports Random class.
import java.util.Scanner; // Imports Scanner class.
import java.util.Arrays; // Imports Array class.
public class DnD { // DnD Class
    public static void main(String[] args) { // Main method
        Intro(); // Calls intro method
        int classChoice = chooseClass(); // Stores the class picked by user.
        // Explanatory Dialogue
        System.out.println("You have committed to the selected class. Let your adventure begin! \n Oh, and be cautious, this could be where you meet your end....");
        encounterOne(classChoice); // Calls encounterOne method
        encounterTwo(classChoice); // Calls encounterTwo method
        Boss(classChoice); // Calls Boss method
    }

    public static void Intro() { // Intro method
        // Describing the Scene.
        System.out.println("In a remote corner of the land lies the abandoned workshop of an enigmatic alchemist known" +
                " for experimenting with rare and powerful magical substances. \n Legends speak of a hidden chamber within the workshop that holds " +
                "the key to unlocking the secrets of transmutation.");
        System.out.println("You a lone adventurer, drawn by the allure of forgotten knowledge and untold riches, decides to explore the mysterious workshop");
        System.out.println("Welcome to the one-shot adventure \" The Forgotten Alchemist's Workshop \" ");
        System.out.println("You may choose from one of three classes: Fighter, Wizard, or Rogue, each will have there own strengths and weaknesses.");
        System.out.println("Choose wisely. It may be your last.......");
    }

    public static int chooseClass() { // Class method
        int classChoice; // Initializes classChoice variable.
        Scanner input = new Scanner(System.in); // Sets scanner up.
        do { // Do while loop
            System.out.println("Now make your choice between (1) Fighter, (2) Wizard, or (3) Rogue.");
            classChoice = input.nextInt(); // Variable to hold choice
            if (classChoice <= 0 || classChoice >= 4) { // Input checking to for valid option.
                System.out.println("You've chosen an invalid choice, please choose a valid one.");
                System.out.println("Press enter (4) to try again.");
            } else {
                switch (classChoice) { // Switch for classChoice
                    case 1: // If you choose Fighter
                        System.out.println("You've chosen Fighter, master of conventional combat. Are you sure you want this class?");
                        break;
                    case 2: // If you choose Wizard
                        System.out.println("You've chosen Wizard, knowledgeable about all things arcane. Are you sure you want this class?");
                        break;
                    case 3: // If you choose Rogue
                        System.out.println("You've chosen Rogue, expert of stealth and subterfuge. Are you sure you wish to choose this class?");
                        break;
                    default: // By default
                        System.out.println("Invalid choice. Please choose a valid class.");
                }
                // Prompt the user to confirm their choice
                System.out.println("Enter '1' to confirm or any other number to choose again:");
            }
        }
        while (input.nextInt() != 1); // Used in the do while loop.
        return classChoice; // Returns variable classChoice to main method.
    }

    // End of chooseClass method.
    public static void encounterOne(int classChoice) { // encounterOne method
        Random random = new Random(); // Basically creates the variable to use the d20 dice.
        int randomNumber; // Variable to hold number rolled on dice.
        Scanner input = new Scanner(System.in); // Imports Scanner.
        int damage = 0; // Sets the damage to 0
        boolean wordFound = false; // Used in the riddle, and when set to true it means you got the riddle right.
        int firstChoice; // firstChoice variable.
        System.out.println("You make your way to the entrance of the abandoned workshop. Around the entrance is desolate ruins. Quite ancient by the looks of them."); // Describing the environment
        if (classChoice == 2) { // If you're a Wizard you get a nice hint into what you may be looking for.
            System.out.println("Before you enter you feel a disturbance in the weave, something of power lies here.");
            System.out.println("After seeing nothing else of interest you make your way inside.");
        } else { // If you aren't a Wizard you get nothing.
            System.out.println("After seeing nothing else of interest you make your way inside.");
        }
        // Describing the scene.
        System.out.println("Inside, you can see scattered papers, broken glass vials, and remnants of long-dried alchemical substances. \n Clearly abandoned... as far as you know. \n As you're thinking about this a barrier appears behind you.");
        System.out.println("Then you hear a loud echoing voice in your head \"Only the worthy may enter.\". Floating words appear in front of you saying  \"I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?\" ");
        System.out.println("You can choose to (1) investigate the room, (2) investigate the barrier or (3) try and answer the riddle right away.");
        firstChoice = input.nextInt();
        while (firstChoice <= 0 || firstChoice >= 4) { // Input Checking
            System.out.println("Invalid option, please choose valid one.");
            firstChoice = input.nextInt();
        }
        switch (firstChoice) { // Switch for firstChoice variable. This decides which route to take you down by whatever choice you picked.
            ////
            case 1: // Case 1 of firstChoice. AKA the first choice.
                System.out.println("You begin to look around the room. A d20 will be rolled to see how you do.");
                randomNumber = random.nextInt(20) + 1; // Basically rolling a digital d20.
                System.out.println("You rolled a " + randomNumber); // Shows you what you "rolled"
                if (randomNumber == 1 && classChoice != 3) { // Happens if you rolled a nat 1 and not a Rogue.
                    System.out.println("You don't find anything of use, but you slip and hit your head and take 1 point of damage.");
                    damage++;
                }
                if (randomNumber == 1 && classChoice == 3) { // If you roll a nat 1, but are a rogue you don't take damage to add some flavor to interactions.
                    System.out.println("You don't find anything of use, but you almost feel yourself slip, but thanks to your roguish acrobatics, you're able to stop yourself from hitting your head.");
                }
                if (randomNumber >= 2 && randomNumber <= 10) { // If you roll 2 - 10
                    System.out.println("You don't find anything of use.");

                }
                if (randomNumber >= 11 && randomNumber <= 19) { // If you roll 11 - 19
                    System.out.println("As you look around the room, you find small writing on the ground, saying \" Beware of bone-men \" ");

                }
                if (randomNumber == 20) { // If you roll a 20
                    System.out.println("You feel like this place is a second home to you, being able to spot the minuscule differences from things that just don't match.");
                    System.out.println("You find writing on the ground saying \" Watch out for bone-men \" and after in a little more wear, \" in the next room \". ");
                    System.out.println("You also find small writing on the ground, saying, \" blow \". ");

                }
                // Next choice
                System.out.println("You can now either (1) investigate the barrier, or (2) answer the riddle.");
                int secondChoice = input.nextInt(); // Variable to hold if you decide to investigate the barrier or answer the riddle.
                while (secondChoice <= 0 || secondChoice >= 3) { // Input Checking
                    System.out.println("Invalid option, please choose valid one.");
                    secondChoice = input.nextInt(); // Variable to hold if you decide to investigate the barrier or answer the riddle.
                }
                switch (secondChoice) { // Switch for secondChoice
                    case 1: // secondChoice case 1
                        System.out.println("As you approach the barrier you can (1) touch it, or (2) investigate it.");
                        int barrierChoice; // Initializes barrierChoice variable.
                        barrierChoice = input.nextInt();// Variable to hold whether you want to touch it or not.
                        while (barrierChoice <= 0 || barrierChoice >= 3) { // Input Checking to see if you choose a valid option.
                            System.out.println("Invalid option, please choose valid one.");
                            barrierChoice = input.nextInt(); // Variable to hold whether you want to touch it or not.
                        }
                        if (barrierChoice == 1) { // Input Checking for barrierChoice
                            if (classChoice == 2) { // Checks to see class choice
                                // Describing the scene.
                                System.out.println("You almost touch the barrier, but in your arcane knowledge,you know it probably isn't the best idea to touch it.");
                                System.out.println("Although you do feel a slight magical presence, but you can't quite put your finger on it.");
                            } else {
                                System.out.println("You see the magic barrier surging with power, are you sure you want to touch it? (1) Yes? or (2) No");
                                int touchBarrier; // Variable to hold value if you decided to touch the barrier or not.
                                touchBarrier = input.nextInt();
                                while (touchBarrier <= 0 || touchBarrier >= 3) { // Checks to see if you choose a valid option.
                                    System.out.println("Invalid option, please choose valid one.");
                                    touchBarrier = input.nextInt(); // Variable to hold if you decide to touch the barrier or not
                                }
                                if (touchBarrier == 1) { // If you touch the barrier
                                    System.out.println("As you touch the barrier, you feel a terrible shock.");
                                    damage++; // Adds 1 damage
                                    if(damage == 3){ // If your damage is 3 you die.
                                        System.out.println("As you feel this terrible shock from touching the barrier, everything goes black.");
                                        System.out.println("******** YOU DIED ********"); // Death Screen
                                        System.exit(0);
                                    }
                                }
                                if (touchBarrier == 2) { // If you decide to touch the barrier
                                    // Describing the Scene
                                    System.out.println("You realize this probably isn't the best idea, so you go back and proceed to investigate the barrier.");
                                    System.out.println("You proceed to try and investigate the barrier.");
                                    randomNumber = random.nextInt(20) + 1; // Rolls d20.
                                    System.out.println("You rolled a " + randomNumber); // Shows what you rolled.
                                    if (randomNumber == 1) { // If you rolled a 1
                                        System.out.println("You investigate the barrier, but you trip terribly, and touch the barrier taking a shocking 1 damage");
                                        damage++; // Adds 1 damage
                                        if (damage == 3) { // If you have 3 damage
                                            System.out.println("As you feel the shock, everything goes dark, and you die");
                                            System.out.println("******** YOU DIED ********"); // Death Screen
                                            System.exit(0);
                                        }
                                    }
                                    if (randomNumber == 1 && classChoice == 1) { //  If you rolled a 1 but are a Fighter.
                                        System.out.println("As you feel yourself trip you use your quick reflexes, built upon by numerous battles,to quickly pullout your shield you quickly bounce yourself off of the barrier, and to save yourself for another day.");

                                    }
                                    if (randomNumber >= 2 && randomNumber <= 10) { // If you rolled a 2 - 10
                                        System.out.println("You don't find anything in particular with the magic barrier, it is in-fact a magic barrier.");

                                    }
                                    if (randomNumber >= 11 && randomNumber <= 19) { // If you rolled a 11 - 19.
                                        System.out.println("As you investigate the barrier you can tell it seems to only be able to break, after answering the riddle. ");
                                    }
                                    if (randomNumber == 20) { // If you rolled a 20
                                        System.out.println("You feel like you can feel the source of the barrier on the ceiling, if only you could reach it.");
                                        if (classChoice == 1) { // If you're a Fighter
                                            System.out.println("Your fighting spirit remembers back in training school how you were taught to throw javelins, so you think back to then and let one loose, hitting the power source perfectly, and the barrier is let down and you make your way into the next room.");
                                            return; // Returns to main method
                                        }

                                        if (classChoice == 3) { // If you're a Rogue
                                            System.out.println("You rely on your cat-like agility to leap in the air and throw a dagger at the source, hitting the power source perfectly, and the barrier is let down and you make your way into the next room.");
                                            return; // Returns to main method
                                        }
                                    }
                                    // Describing the scene.
                                    System.out.println("Seeing as you don't have anything left to do, you try to answer the riddle.");
                                    System.out.println("You hear the riddle again \" I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I? \" ");
                                    do { // Do While loop
                                        input.nextLine(); // To stop scanner bleed
                                        System.out.println("Type your guess now: ");
                                        String answer = input.nextLine(); // Stores what ever the user inputs to compare to the right answer.
                                        if (answer.contains("whistle") || answer.contains("Whistle")) { // Checks to see if answer contains whistle or Whistle
                                            System.out.println("As you say the magic word, the barrier falls, and you begin to make your way into the other room.");
                                            wordFound = true;
                                        } else {
                                            System.out.println("As you say those words, you feel a terrible shock.");
                                            damage++;
                                            if(damage == 1){
                                                System.out.println("You can tell you've got it wrong, refer to your wits, and press enter to try again.");
                                            }
                                            if(damage == 2){
                                                System.out.println("You can tell if you take one more shock you won't survive");
                                                System.out.println("Press enter to try again.");
                                            }
                                            if(damage == 3){
                                                System.out.println("As you feel this terrible shock, everything goes black.");
                                                System.out.println("******** YOU DIED ********"); // Death Screen
                                                System.exit(0);
                                            }
                                        }
                                    } while (!wordFound); // Used in the do while loop.
                                    return; // Returns to main method
                                }
                            }
                        }
                        if (barrierChoice == 2) { // If you decide not to touch the barrier
                            // Describing the Scene.
                            System.out.println("You decide to not touch the barrier, and proceed to back away.");
                            System.out.println("You proceed to try and investigate the barrier.");
                            randomNumber = random.nextInt(20) + 1; // Rolls d20.
                            System.out.println("You rolled a " + randomNumber); // Shows what you rolled
                            if (randomNumber == 1 && classChoice != 1) { // If you rolled a 1 and aren't a Fighter
                                System.out.println("You investigate the barrier, but you trip terribly, and touch the barrier taking a shocking 1 damage");
                                damage++; // Adds 1 damage
                                if (damage == 3) { // If you take 3 damage
                                    System.out.println("As you feel the shock, everything goes dark, and you die");
                                    System.out.println("******** YOU DIED ********"); // Death Screen
                                    System.exit(0);
                                }
                            }
                            if (randomNumber == 1 && classChoice == 1) { // If you rolled a 1, but are a Fighter.
                                System.out.println("As you feel yourself trip you use your quick reflexes, built upon by numerous battles,to quickly pullout your shield you quickly bounce yourself off of the barrier, and to save yourself for another day.");

                            }
                            if (randomNumber >= 2 && randomNumber <= 10) { // If you rolled a 2 - 10
                                System.out.println("You don't find anything in particular with the magic barrier, it is in-fact a magic barrier.");

                            }
                            if (randomNumber >= 11 && randomNumber <= 19) { // If you rolled a 11-19
                                System.out.println("As you investigate the barrier you can tell it seems to only be able to break, after answering the riddle. ");
                            }
                            if (randomNumber == 20) { // If you rolled a 20
                                System.out.println("You feel like you can feel the source of the barrier on the ceiling, if only you could reach it.");
                                if (classChoice == 1) { // If you're a Fighter
                                    System.out.println("Your fighting spirit remembers back in training school how you were taught to throw javelins, so you think back to then and let one loose, hitting the power source perfectly, and the barrier is let down and you make your way into the next room.");
                                    return; // Returns to main method
                                }
                                if (classChoice == 2) { // If you're a Wizard
                                    System.out.println("Thanks to your arcane ability you are able to focus on the power source, and shoot a Fire-bolt, hitting the power source perfectly, and then barrier is let down and you make your way into the next room.");
                                    return; // Returns to main method
                                }

                                if (classChoice == 3) { // If you're a Rogue
                                    System.out.println("You rely on your cat-like agility to leap in the air and throw a dagger at the source, hitting the power source perfectly, and the barrier is let down and you make your way into the next room.");
                                    return; // Returns to main method
                                }
                            }
                            // Describing the Scene
                            System.out.println("Seeing as you don't have anything left to do, you try to answer the riddle.");
                            System.out.println("You hear the riddle again \" I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I? \" ");
                            do { // Do while loop
                                input.nextLine(); // To stop scanner bleed
                                System.out.println("Type your guess now: ");
                                String answer = input.nextLine(); // Stores what ever the user inputs to compare to the right answer.
                                if (answer.contains("whistle") || answer.contains("Whistle")) { // Checks to see if answer contains whistle or Whistle
                                    System.out.println("As you say the magic word, the barrier falls, and you begin to make your way into the other room.");
                                    wordFound = true; // Ends do while loop
                                } else {
                                    System.out.println("As you say those words, you feel a terrible shock.");
                                    damage++; // Adds 1 to damage.
                                    if(damage == 1){ // If you have 1 damage
                                        System.out.println("You can tell you've got it wrong, refer to your wits, and press enter to try again.");
                                    }
                                    if(damage == 2){ // If you have 2 damage
                                        System.out.println("You can tell if you take one more shock you won't survive");
                                        System.out.println("Press enter to try again.");
                                    }
                                    if(damage == 3){ // If you have 3 damage
                                        System.out.println("As you feel this terrible shock, everything goes black.");
                                        System.out.println("******** YOU DIED ********"); // Death Screen
                                        System.exit(0);
                                    }
                                }
                            } while (!wordFound); // Used in the do while loop.
                        }

                    case 2:
                        // Describing the Scene
                        System.out.println("You proceed to try and solve the riddle");
                        System.out.println("You hear the riddle again \" I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I? \" ");
                        do {
                            input.nextLine(); // To stop scanner bleed
                            System.out.println("Type your guess now: ");
                            String answer = input.nextLine(); // Stores what ever the user inputs to compare to the right answer.
                            if (answer.contains("whistle") || answer.contains("Whistle")) { // Checks to see if answer contains whistle or Whistle
                                System.out.println("As you say the magic word, the barrier falls, and you begin to make your way into the other room.");
                                wordFound = true; // Breaks the do while loop
                            } else {
                                System.out.println("As you say those words, you feel a terrible shock.");
                                damage++;
                                if(damage == 1){ // If you take 1 damage
                                    System.out.println("You can tell you've got it wrong, refer to your wits, and press enter to try again.");
                                }
                                if(damage == 2){ // If you take 2 damage
                                    System.out.println("You can tell if you take one more shock you won't survive");
                                    System.out.println("Press enter to try again.");
                                }
                                if(damage == 3){ // If you take 3 damage
                                    System.out.println("As you feel this terrible shock, everything goes black.");
                                    System.out.println("******** YOU DIED ********"); // Death Screen
                                    System.exit(0);
                                }
                            }
                        } while (!wordFound); // Used in the do while loop.
                        return; // Returns to main method
                }
            case 2: // Case 2 of firstChoice switch statement
                System.out.println("As you approach the barrier you can (1) touch it, or (2) investigate it.");
                int barrierChoice;
                barrierChoice = input.nextInt(); // Variable to store if you decide to touch the barrier or not.
                while (barrierChoice <= 0 || barrierChoice >= 3) { // Input checking to see if you choose a valid option.
                    System.out.println("Invalid option, please choose valid one.");
                    barrierChoice = input.nextInt(); // Variable to store if you decide to touch the barrier or not.
                        }
                if (barrierChoice == 1) { // If you decide to touch the barrier
                    if (classChoice == 2) { // If you're a Wizard
                        System.out.println("You almost touch the barrier, but in your arcane knowledge,you know it probably isn't the best idea to touch it.");
                        System.out.println("Although you do feel a slight magical presence, but you can't quite put your finger on it.");
                        System.out.println("You try to reach out to feel it.");
                        randomNumber = random.nextInt(20) + 1; // Rolls d20.
                        System.out.println("You rolled a " + randomNumber); // Shows what you rolled
                        if (randomNumber == 1) { // If you roll a 1
                            System.out.println("You feel the barrier, but in your haste you fall on your face accidentally. You take no damage, except to your pride. ");
                        }
                        if (randomNumber >= 2 && randomNumber <= 10) { // If you roll 2 - 10
                            System.out.println("You don't feel anything too magical in particular with the magic barrier, it is in-fact a magic barrier.");

                        }
                        if (randomNumber >= 11 && randomNumber <= 19) { // If you roll 11 - 19
                            System.out.println("As you feel the magic of the barrier, it seems to only be able to break, after answering the riddle. ");
                        }
                        if (randomNumber == 20) { // If you roll a 20
                            System.out.println("You feel like you can feel the source of the barrier on the ceiling, if only you could reach it.");
                            System.out.println("Then you remember that you're a Wizard, your spells can reach it.");
                            System.out.println("Thanks to your arcane ability you are able to focus on the power source, and shoot a Fire-bolt, hitting the power source perfectly, and then barrier is let down and you make your way into the next room.");
                            return; // Returns to main method
                        }
                    } else {
                        System.out.println("You see the magic barrier surging with power, are you sure you want to touch it? (1) Yes or (2) No.");
                        int touchBarrier;  // Hold value that shows if you decide to touch the barrier or not.
                        touchBarrier = input.nextInt(); // Variable to hold whether you decide to touch the barrier or not.
                        while (touchBarrier <= 0 || touchBarrier >= 3) { // Input Checking to see if you input a valid option.
                            System.out.println("Invalid option, please choose valid one.");
                            touchBarrier = input.nextInt();
                        }
                        if (touchBarrier == 1) { // If you decide to touch the barrier as a Rogue or Fighter
                            System.out.println("You touch the magic barrier and feel a terrible shock, and take 1 damage.");
                            damage++;
                        }
                        if (touchBarrier == 2) { // If you don't decide to touch the barrier as a Rogue or Fighter
                            System.out.println("You realize this probably isn't the best idea, so you go back and proceed to investigate the barrier.");
                            System.out.println("You proceed to try and investigate the barrier.");
                            randomNumber = random.nextInt(20) + 1; // Rolls d20.
                            System.out.println("You rolled a " + randomNumber); // Shows what you rolled
                            if (randomNumber == 1 && classChoice != 1) { // If you roll a 1 and aren't a Fighter.
                                System.out.println("You investigate the barrier, but you trip terribly, and touch the barrier taking a shocking 1 damage");
                                damage++;
                            }
                            if (randomNumber == 1 && classChoice == 1) { // If you roll a 1 but are a Fighter
                                System.out.println("As you feel yourself trip you use your quick reflexes, built upon by numerous battles,to quickly pullout your shield you quickly bounce yourself off of the barrier, and to save yourself for another day.");

                            }
                            if (randomNumber >= 2 && randomNumber <= 10) { // If you roll 2 - 10
                                System.out.println("You don't find anything in particular with the magic barrier, it is in-fact a magic barrier.");

                            }
                            if (randomNumber >= 11 && randomNumber <= 19) { // If you roll 11 - 19
                                System.out.println("As you investigate the barrier you can tell it seems to only be able to break, after answering the riddle. ");
                            }
                            if (randomNumber == 20) { // If you roll a 20
                                System.out.println("You feel like you can feel the source of the barrier on the ceiling, if only you could reach it.");
                                if (classChoice == 1) { // If you're a Fighter
                                    System.out.println("Your fighting spirit remembers back in training school how you were taught to throw javelins, so you think back to then and let one loose, hitting the power source perfectly, and the barrier is let down and you make your way into the next room.");
                                    return; // Returns to main method
                                }

                                if (classChoice == 3) { // If you're a Rogue
                                    System.out.println("You rely on your cat-like agility to leap in the air and throw a dagger at the source, hitting the power source perfectly, and the barrier is let down and you make your way into the next room.");
                                    return; // Returns to main method.
                                }
                            }
                        }
                    }
                }

                    System.out.println("You realize there isn't anything else here for you, so you proceed to either (1) check out the room some more, or (2) try and guess the riddle's answer.");
                    int secondSChoice = input.nextInt(); // Stores whether you choose to check the room out or try and guess the riddle.
                    while (secondSChoice <= 0 || secondSChoice >= 3) { // Input checking to see if you input a valid option
                        System.out.println("Invalid option, please choose valid one.");
                        secondSChoice = input.nextInt(); // Used to store which decision you make.
                    }
                    switch (secondSChoice) {
                        case 1:
                            System.out.println("You begin to look around the room. A d20 will be rolled to see how you do.");
                            randomNumber = random.nextInt(20) + 1; // Rolls d20.
                            System.out.println("You rolled a " + randomNumber); // Shows what you rolled
                            if (randomNumber == 1 && classChoice != 3) { // If you roll a 1 and aren't a Rogue
                                System.out.println("You don't find anything of use, but you slip and hit your head and take 1 point of damage.");
                                damage++;
                                if (damage == 2) {
                                    System.out.println("As you feel the shock, everything goes dark, and you die");
                                    System.out.println("******** YOU DIED ********"); // Death Screen
                                    System.exit(0);
                                }
                            }
                            if (randomNumber == 1 && classChoice == 3) { // If you roll a 1 but are a Rogue
                                System.out.println("You don't find anything of use, but you almost feel yourself slip, but thanks to your roguish acrobatics, you're able to stop yourself from hitting your head.");
                            }
                            if (randomNumber >= 2 && randomNumber <= 10) { // If you roll 2 - 10
                                System.out.println("You don't find anything of use.");

                            }
                            if (randomNumber >= 11 && randomNumber <= 19) { // If you roll 11 - 19
                                System.out.println("As you look around the room, you find small writing on the ground, saying \" Beware of bone-men \" ");

                            }
                            if (randomNumber == 20) { // If you roll a 20
                                System.out.println("You feel like this place is a second home to you, being able to spot the minuscule differences from things that just don't match.");
                                System.out.println("You find writing on the ground saying \" Watch out for bone-men \" and after in a little more wear, \" in the next room \". ");
                                System.out.println("You also find small writing on the ground, saying, \" blow \". ");
                            }
                            System.out.println("As there isn't anything else to do other than to answer the riddle, you proceed to try and solve the riddle.");
                            System.out.println("You hear the riddle again \" I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I? \" ");
                            do {
                                input.nextLine(); // To stop scanner bleed
                                System.out.println("Type your guess now: ");
                                String answer = input.nextLine(); // Stores what ever the user inputs to compare to the right answer.
                                if (answer.contains("whistle") || answer.contains("Whistle")) {
                                    System.out.println("As you say the magic word, the barrier falls, and you begin to make your way into the other room.");
                                    wordFound = true;
                                } else {
                                    System.out.println("As you say those words, you feel a terrible shock.");
                                    damage++;
                                    if(damage == 1){
                                        System.out.println("You can tell you've got it wrong, refer to your wits, and press enter to try again.");
                                    }
                                    if(damage == 2){
                                        System.out.println("You can tell if you take one more shock you won't survive");
                                        System.out.println("Press enter to try again.");
                                    }
                                    if(damage == 3){
                                        System.out.println("As you feel this terrible shock, everything goes black.");
                                        System.out.println("******** YOU DIED ********"); // Death Screen
                                        System.exit(0);
                                    }
                                }
                            } while (!wordFound); // Used in the do while loop.
                            return; // Returns to main method


                        case 2:
                            System.out.println("You proceed to try and solve the riddle");
                            System.out.println("You hear the riddle again \" I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I? \" ");
                            do {
                                input.nextLine(); // To stop scanner bleed
                                System.out.println("Type your guess now: ");
                                String answer = input.nextLine(); // Stores what ever the user inputs to compare to the right answer.
                                if (answer.contains("whistle") || answer.contains("Whistle")) { // Checks to see if answer contains whistle or Whistle.
                                    System.out.println("As you say the magic word, the barrier falls, and you begin to make your way into the other room.");
                                    wordFound = true;
                                } else {
                                    System.out.println("As you say those words, you feel a terrible shock.");
                                    damage++; // Takes 1 damage
                                    if(damage == 1){ // If you have 1 damage
                                        System.out.println("You can tell you've got it wrong, refer to your wits, and press enter to try again.");
                                    }
                                    if(damage == 2){ // If you have 2 damage
                                        System.out.println("You can tell if you take one more shock you won't survive");
                                        System.out.println("Press enter to try again.");
                                    }
                                    if(damage == 3){ // If you have 3 damage
                                        System.out.println("As you feel this terrible shock, everything goes black.");
                                        System.out.println("******** YOU DIED ********"); // Death Screen
                                        System.exit(0);
                                    }
                                }
                            } while (!wordFound); // Part of do while loop
                            return; // Returns to main method


                    }
            case 3: // Case 3 of firstChoice switch statement
                System.out.println("You proceed to try and solve the riddle");
                System.out.println("You hear the riddle again \" I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I? \" ");
                do {
                    input.nextLine(); // To stop scanner bleed
                    System.out.println("Type your guess now: ");
                    String answer = input.nextLine(); // Stores what ever the user inputs to compare to the right answer.
                    if (answer.contains("whistle") || answer.contains("Whistle")) { // Checks to see if answer contains whistle or Whistle
                        System.out.println("As you say the magic word, the barrier falls, and you begin to make your way into the other room.");
                        wordFound = true;
                    } else {
                        System.out.println("As you say those words, you feel a terrible shock.");
                        damage++;
                        if(damage == 1){
                            System.out.println("You can tell you've got it wrong, refer to your wits, and press enter to try again.");
                        }
                        if(damage == 2){
                            System.out.println("You can tell if you take one more shock you won't survive");
                            System.out.println("Press enter to try again.");
                        }
                        if(damage == 3){
                            System.out.println("As you feel this terrible shock, everything goes black.");
                            System.out.println("******** YOU DIED ********"); // Death Screen
                            System.exit(0);
                        }
                    }
                } while (!wordFound);


        }
    }
                     // End of encounterOne
    public static void encounterTwo(int classChoice) {// encounterTwo method.
                         Random random = new Random(); // Basically creates the variable to use the d20 dice.
                         Scanner input = new Scanner(System.in); // Imports Scanner.
                         int randomNumber; // Makes randomNumber variable to use
                        String[] alchemy = {"Mandrake Root", "Wyvern Venom", "Moonstone Dust", "Phoenix Feather", "Djinni Essence", "Dragon's Blood"}; // Stores different alchemical ingredients.
                    System.out.println("You coming out of the entrance hall victorious, you begin to see more intricate decorations, and more vibrant alchemical ingredients. "); // Describing the scene
                    if(classChoice == 2){ // If you're a Wizard
                        System.out.println("You recognize some of the ingredients thanks to your arcane studies.");
                        System.out.println("There's quite a few, like the usual, " + alchemy[0] + ", " + alchemy[1] + ", and " + alchemy[2] + ". \n But strangely there's quite a few powerful ones, like " + alchemy[3] + ", and " + alchemy[4] + ", and even more strangely " + alchemy[5]  + " and they're just laying around. You put this in your mind then continue on.");
                    }
                        Arrays.sort(alchemy); // Sorts alchemy array.
                        if(classChoice != 2){ // If you aren't a Wizard
                        System.out.println("You see on the wall a list of alchemy ingredients and them by different cases.");
                        System.out.println("Them being: " + alchemy[0] + ", " + alchemy[1] + ", " + alchemy[2] + ", " + alchemy[3] + ", " + alchemy[4] + ", and " + alchemy[5] );
                        }
                        // Describing the scene.
                         System.out.println("As you're walking you hear footsteps and are able to hide yourself behind a statue.");
                         System.out.println("You peek seeing two skeletons.");
                         System.out.println("You can either try and sneak past them or fight them.");
                        if(classChoice == 1){ // If you're a Fighter
                            System.out.println("You as a Fighter know fighting two skeletons by oneself isn't the best idea for a regular adventurer, but you are confident you would be able to manage if not destroy them.");
                         }
                        if(classChoice == 2){ // If you're a Wizard
                            System.out.println("You as a Wizard, are confident that a quick fireball would more than destroy these skeletons, only that you can hit them with it.");
                         }
                         if(classChoice == 3){ // If you're a Rogue
                             System.out.println("You, a Rogue, are confident that it should be a cake-walk to sneak past them, unless something unexpected happens.");
                         }
                         System.out.println("Will you (1) fight them, or (2) sneak past them?");
                         int startChoice = input.nextInt(); // Stores value to determine if you choose to sneak past them or fight them.
                         while(startChoice <= 0 || startChoice >= 3){ // Checking to see if a valid option.
                             System.out.println("Invalid choice, please choose another option.");
                             startChoice = input.nextInt();
                         }
                         if (startChoice == 1){ // Combat choice
                             System.out.println("You proceed to do battle with the skeletons.");
                             System.out.println("Since you got the drop on them you give yourself a leg up in the fight.");
                             randomNumber = random.nextInt(20) + 1; // Rolls d20.
                             int randomNumberTwo = randomNumber + 3; // Adds a three to the roll since you've got the drop on them.
                             System.out.println("You rolled a " + randomNumberTwo ); // Shows what you rolled
                             if(randomNumber == 1){
                                 System.out.println("You fight valiantly, but sadly in a stroke of bad luck you slip and the skeletons stab you lethally. Your remains are now apart of the alchemical workshop. Forever.");
                                 System.out.println("******** YOU DIED ********"); // Death Screen
                             }
                             if(randomNumberTwo >= 5 && randomNumberTwo <= 9 ){ // If you roll 5 -9
                                     System.out.println("You meet your end quickly and are forgotten.");
                                     System.out.println("******** YOU DIED ********"); // Death Screen
                                     System.exit(0);
                             }
                             if(randomNumberTwo >= 10 && randomNumberTwo <= 19 ){ // If you roll 10 - 19
                                 System.out.println("You're able to destroy the skeletons fairly easily and make your way to the final room.");
                                 return; // Returns to main method
                             }
                             if(randomNumberTwo >= 20 ){ // If you roll 20 or higher
                                 if (classChoice == 1) { // If you're a Fighter
                                     System.out.println("You proceed to eviscerate the skeletons, sending them from whence they came.");
                                     System.out.println("You see before you leave, words on the ground saying \" He speaks of Winged Beasts \" ");
                                     System.out.println("You begin to make your way to the final room.");
                                     return; // Returns to main method
                                 }
                                 if (classChoice == 2) { // If you're a Wizard
                                     System.out.println("You recite the spell Fireball and it glows brightly lighting up the room, then burning the skeletons into cinder.");
                                     System.out.println("You see before you leave, words on the ground saying \" He speaks of Winged Beasts \" ");
                                     System.out.println("You begin to make your way to the final room.");
                                     return; // Returns to main method
                                 }
                                 if (classChoice == 3) { // If you're a Rogue
                                     System.out.println("You slice the skeletons into ribbons with your daggers like they never stood a chance.");
                                     System.out.println("You see before you leave, words on the ground saying \" He speaks of Winged Beasts \" ");
                                     System.out.println("You begin to make your way to the final room.");
                                 }
                             }

                         }else { // Stealth choice
                             System.out.println("You try to sneak past them");
                             if (classChoice == 3) {
                                 System.out.println("You, a rogue, and feel a burst of confident in your skills as you start to sneak past them.");
                             }
                             randomNumber = random.nextInt(20) + 1; // Rolls d20.
                             if (classChoice == 3 && randomNumber != 1) { // If you're a Rogue and didn't roll a 1
                                 randomNumber = randomNumber + 3;
                             }
                             System.out.println("You rolled a " + randomNumber); // Shows what you rolled
                             if (randomNumber == 1) {
                                 System.out.println("You try to sneak past them, but you step on a loose brick, and under you the floor breaks, and you fall, and keep falling, and keep falling, until you don't.");
                                 System.out.println("******** YOU DIED ********"); // Death Screen
                                 System.exit(0);
                             }
                             if (randomNumber >= 3 && randomNumber <= 8) { // If you rolled 3 - 8 on your sneak check.
                                 System.out.println("You begin to sneak, but trip instantly, alerting the skeletons.");
                                 System.out.println("The skeletons are blocking your path, so it looks like you must fight.");
                                 if (classChoice == 1) { // If you are a Fighter.
                                     System.out.println("With your years of fighting experience, you see their stances are second-grade at best and see weak-points in their stances that you can take advantage of.");
                                 }
                                 randomNumber = random.nextInt(20) + 1; // Rolls d20.
                                 if (classChoice == 1 && randomNumber != 1) { // Checks to see if you are a Fighter and didn't roll a 1.
                                     randomNumber = randomNumber + 5;
                                 }
                                 if (randomNumber == 1) { // If you rolled a 1
                                     System.out.println("You fight valiantly, but sadly in a stroke of bad luck you slip and the skeletons stab you lethally. Your remains are now apart of the alchemical workshop. Forever.");
                                     System.out.println("******** YOU DIED ********"); // Death Screen
                                     System.exit(0);
                                 }
                                 if (randomNumber >= 3 && randomNumber <= 4 ) { // If rolled 3 or 4
                                     System.out.println("You meet your end quickly and are forgotten.");
                                     System.out.println("******** YOU DIED ********"); // Death Screen
                                     System.exit(0);

                                 }
                                 if (randomNumber >= 5 && randomNumber <= 9) { // If rolled 5 - 9
                                     System.out.println("You proceed to do battle with the skeletons");
                                     randomNumber = random.nextInt(20) + 1; // Rolls d20.
                                     System.out.println("You rolled a " + randomNumber); // Shows what you rolled.
                                     if (randomNumber >= 5 && randomNumber <= 19) {
                                         System.out.println("You're able to destroy the skeletons fairly easily and make your way to the final room.");
                                         return; // Returns to main method
                                     }
                                 }

                                 if(randomNumber >= 10 && randomNumber <= 19 ){ // If rolled 10 - 19
                                     System.out.println("You're able to destroy the skeletons fairly easily and make your way to the final room.");
                                     return; // Returns to main method
                                 }
                                 if(randomNumber >= 20 ){ // If rolled a 20 or higher
                                     if (classChoice == 1) {
                                         System.out.println("You proceed to eviscerate the skeletons, sending them from whence they came.");
                                         System.out.println("You see before you leave, words on the ground saying \" He speaks of Winged Beasts \" ");
                                         System.out.println("You begin to make your way to the final room.");
                                         return; // Returns to main method
                                     }
                                     if (classChoice == 2) {
                                         System.out.println("You recite the spell Fireball and it glows brightly lighting up the room, then burning the skeletons into cinder.");
                                         System.out.println("You see before you leave, words on the ground saying \" He speaks of Winged Beasts \" ");
                                         System.out.println("You begin to make your way to the final room.");
                                         return; // Returns to main method
                                     }
                                     if (classChoice == 3) {
                                        System.out.println("You slice the skeletons into ribbons with your daggers like they never stood a chance.");
                                        System.out.println("You see before you leave, words on the ground saying \" He speaks of Winged Beasts \" ");
                                        System.out.println("You begin to make your way to the final room.");
                                        return; // Returns to main method
                                 }
                                 }
                             }
                             if (randomNumber >= 9 && randomNumber <= 19) { // If rolled 9-19.
                                 System.out.println("You're able to sneak past them successfully");
                                 System.out.println("You begin to make your way to the boss room.");
                                 return; // Returns to main method
                             }
                             if (randomNumber >= 20) { // If rolled a 20 or higher
                                 if (classChoice == 1) { // For Fighter class
                                     System.out.println("Wearing heavy armor should've screwed with your ability to sneak. But you enter a trance, sneaking like never before, being as silent as professional rogues.");
                                     System.out.println("You see before you leave, words on the ground saying \" He speaks of Winged Beasts \" ");
                                     System.out.println("You begin to make your way to the final room.");
                                     return; // Returns to main method
                                 }
                                 if (classChoice == 2) { // For Wizard Class
                                     System.out.println("Surprisingly, you, a Wizard, masterfully sneak past the skeletons and in doing so, avoid a dire fight.");
                                     System.out.println("You see before you leave, words on the ground saying \" He speaks of Winged Beasts \" ");
                                     System.out.println("You begin to make your way to the final room.");
                                     return; // Returns to main method
                                 }
                                 if (classChoice == 3) { // For Rogue Class
                                     System.out.println("You being a rogue, isn't really surprising, how you're able to masterfully, sneak past them, but this one seemed different, than your usual escapades, you felt more focused than ever before.");
                                     System.out.println("You see before you leave, words on the ground saying \" He speaks of Winged Beasts \" ");
                                     System.out.println("You begin to make your way to the final room.");

                                 }
                             }
                         }

                 } /// End of encounterTwo Method
                 public static void Boss (int classChoice) { // Boss Method
                     Scanner input = new Scanner(System.in); // Imports Scanner.
                        System.out.println("You've made it!");
                        System.out.println("You walk into the chamber. ");
                        if(classChoice == 2){ // Checks to see if user is Wizard.
                            System.out.println("As you're walking in the chamber, you recognize it as a transmutation chamber, used to transmute things into different things.");
                        }
                        // Describing the scene.
                        System.out.println("You walk into the chamber. The chamber is a mesmerizing space, filled with an otherworldly ambiance that reflects the alchemical prowess of its long-lost creator. \n As your character steps into the chamber, the air hums with residual arcane energy, and the room is bathed in a soft, ethereal glow emanating from the intricate transmutation circle at the center. ");
                        System.out.println("You proceed to the circle.");
                        System.out.println(" The circle is a large, perfectly inscribed transmutation circle. Glyphs and symbols, representing various magical elements and alchemical principles, adorn its surface. Faint, pulsating lines of energy trace the intricate patterns of the circle.");
                        System.out.println("In the center you see a vase that is inscribed with runes.");
                        if(classChoice == 2){ // If Wizard, Describing the scene.
                            System.out.println("You sense that this is the source of magic power you felt at the entrance of the workshop.");
                        }
                        // Story Dialogue
                        System.out.println("As you walk further into the room, a spectral apparition appears. He is translucent, wearing ancient alchemical robes.");
                        System.out.println("He says, \"Woohoo! You made it! Great job! Been a while since I had someone here. I'm guessing you're here for the Vase of Wonders.\"");
                        System.out.println("You recognize the name as the vase that turns anything you put in, into just about anything. Lead into Gold. Gold into Silver. Silver back into Gold. It is highly valuable.");
                        System.out.println("But, you realize there's always a catch.");
                        System.out.println("You ask what would you need to do to get it. The alchemist responds \" Oh just guess what I'm talking about and you get the vase.\"");
                        System.out.println("You think it should be easy, but the vase still being here, you can tell it won't be.");
                        System.out.println("The alchemist responds \"Alright, I am sometimes red hot with anger, sometimes cool blue with ice, sometimes wise as an owl, yet sometimes as vicious as a lion, what am I? Oh and by the way, you have two chances, you'll see what happens if you fail.\" ");
                        for (int attempt = 1; attempt <= 2; attempt++) { // Loop for guessing.
                         System.out.print("Enter your guess: ");
                         String userGuess = input.nextLine(); // Stores what ever the user inputs to compare to the right answer.
                         if (userGuess.contains("Dragon") || userGuess.contains("dragon")) {
                             // Story Dialogue if correct answer is inputted
                             System.out.println("Congratulations! Glad someone was clever enough to guess my question, enjoy my vase, and treasure it.");
                             System.out.println("As the alchemist finishes he disappears and you are left with the vase.");
                             System.out.println("As you pick up the vase, you feel like tingling feeling, as your vision fades to black.");
                             System.out.println("You wake up outside of the workshop with the vase in-front of you. You look at it glad you were able to get it as you get up with vase in hand and walk away.");
                             System.out.println("Congratulations! You completed The Forgotten Alchemist's Workshop. You did great! Hope you enjoyed the one-shot!");
                             break; // Exit the loop if the guess is correct
                         } else {
                             if(attempt == 1) // First incorrect message
                                System.out.println("Incorrect guess. One more chance. Here's a hint, I am an beast.");
                             if(attempt == 2){ // Death Screen
                                 System.out.println("Wrong again, sorry to tell you this, but you're not making it out of here.");
                                 System.out.println("As he says that you feel yourself feel colder than you've ever felt, and you blink and all you see is darkness.");
                                 System.out.println("******** YOU DIED ********");
                             }
                         }
                     }
                 }
                 // End of Boss method.
             }
             // End of Program