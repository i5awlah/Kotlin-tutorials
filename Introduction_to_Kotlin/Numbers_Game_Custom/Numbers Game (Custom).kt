import kotlin.random.Random

fun main() {

    val randomNumber = Random.nextInt(11)

    try {
        print("Enter your first number: ")
        val userNumber1 = readLine()!!.toInt()

        print("Enter your second number: ")
        val userNumber2 = readLine()!!.toInt()

        // UserNumber1 * RandomNumber + UserNumber2
        val result = userNumber1 * randomNumber + userNumber2
        println("$userNumber1 * X + $userNumber2 = $result ")

        print("What is X? >> ")

        val x = readLine()!!.toInt()

        if (x == randomNumber) {
            println("You got it!")
        }
        else {
            println("Wrong!")
        }


    } catch (e: Exception) {
        println("Please enter numbers only.")
    }
}
