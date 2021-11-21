import kotlin.random.Random
fun main() {
    var counter = 0
    while (counter < 3) {
        val randomNum = Random.nextInt(11)
        print("Guess a number between 0 and 10 or write 'quit' to quit the program: ")
        val userEnter = readLine()

        if (userEnter == "quit") {
            break
        }

        try {
            val userGuess = userEnter!!.toInt()

            if (userGuess in 0..10) {

                when (userGuess) {
                    randomNum -> {
                        println("You got it!")
                        break
                    }
                    else -> {
                        println("Wrong guess. The answer was $randomNum.")
                        counter++
                    }
                }
            } else {
                println("The number must be between 0 and 10")
            }

        } catch (e: Exception) {
            println("Please enter numbers only.")
        }
    }

    println("Game Over")
}
