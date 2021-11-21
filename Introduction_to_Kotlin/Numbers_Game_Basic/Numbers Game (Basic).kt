fun main() {
    // Create a variable to hold an integer between 0 and 10
    val num = 8

    //  Print a message to the user explaining that the goal is to guess a number between 0 and 10
    print("Guess a number between 0 and 10: ")

    // Use a try block to make sure the user can only guess numbers
    try {
        // // Ask the user to guess the secret number
        val userGuess = readLine()!!.toInt()

        // Make sure that the user has entered a number between 0 and 10.
        if (userGuess >= 0 && userGuess <= 10) {

            // If the user guesses correctly, display a message to tell them they have guessed correctly
            if (userGuess == num) {
                println("You got it!")
            }
            // If the user does not guess correctly, display a message to tell them they have guessed incorrectly and display the answer
            else {
                println("Wrong guess. The answer was $num.")
            }
        } else {
            println("The number must be between 0 and 10")
        }
    } catch (e: Exception) {
        println("Please enter numbers only.")
    }

    // Display a message to tell the user that the game is over
    println("Game Over")
}
