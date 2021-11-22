import kotlin.random.Random

fun main() {
    // Create a Country class with two attributes (name, capital)
    class Country(val name: String, val capital: String) {
        // Create a function that prints the country and its capital
        fun print() {
            println("The capital city in $name is: $capital ")
        }
    }

    // Create ten countries and place them inside a list
    val countries = listOf(
        Country("Saudi Arabia","Riyadh"),
        Country("Egypt","Cairo"),
        Country("United Arab Emirates","Abu Dhabi"),
        Country("United Kingdom","London"),
        Country("India","New Delhi"),
        Country("Italy","Rome"),
        Country("France","Paris"),
        Country("Japan","Tokyo"),
        Country("China","Beijing"),
        Country("Kenya","Nairobi")
    )


    do {
        // Bonus: Can you find a way to always ask 3 unique questions? (Never repeating the same country in a single game)
        var arr = arrayListOf(0,1,2,3,4,5,6,7,8,9)
 
        var score = 0
        // Randomly select three countries and quiz the user to see if they know the capitals
        for (i in 1..3) {
            val randomNum = arr.random()
            arr.remove(randomNum)

            print("What is the capital of ${countries[randomNum].name}? ")
            val userAnswer = readLine()!!

            // If the user guesses incorrectly call the capital function to show the answer
            if (userAnswer != countries[randomNum].capital) {
                println("Wrong guess!")
                countries[randomNum].print()
            }
            // Give the user a final score out of 3 at the end of the game
            else {
                println("You got it!")
                score++
            }

        }
        println("The score is: $score out of 3.")

        // Start a new game if they want to play again
        print("Do you want to play again? (y/n) ")
        val playAgain= readLine()!!

    } while (playAgain == "y" || playAgain == "Y")
}