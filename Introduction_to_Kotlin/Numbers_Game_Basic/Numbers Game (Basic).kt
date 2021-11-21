fun main() {
    // Create a variable to hold an integer between 0 and 10
    val num = 8

    //  Print a message to the user explaining that the goal is to guess a number between 0 and 10
    print("Guess a number between 0 and 10: ")

    // Use a try block to make sure the user can only guess numbers
    try {
        // // Ask the user to guess the secret number
        val userGuess = readLine()!!.toInt()

        // If the user guesses correctly, display a message to tell them they have guessed correctly
        if (userGuess == num) {
            println("You got it!")
        }
        // If the user does not guess correctly, display a message to tell them they have guessed incorrectly and display the answer
        else {
            println("Wrong guess. The answer was $num.")
        }
    } catch (e: Exception) {
        println("Please enter numbers only.")
    }

    // Display a message to tell the user that the game is over
    println("Game Over")
}
