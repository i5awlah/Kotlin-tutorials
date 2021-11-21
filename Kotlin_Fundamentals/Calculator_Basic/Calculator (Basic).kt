
fun main() {

    do {
        print("Enter your first number: ")
        val userNumber1 = numberCheck(readLine())

        print("Enter your second number: ")
        val userNumber2 = numberCheck(readLine())

        val sum = sum(userNumber1,userNumber2)
        println("$userNumber1 + $userNumber2 = $sum ")

        print("Would you like to add more numbers? (Y/N) >> ")
        val continueCalc = readLine()
    } while (continueCalc == "Y" || continueCalc == "y")



}

fun numberCheck(userNumber: String?) : Int {
    return try {
        userNumber!!.toInt()

    } catch (e: Exception) {
        0
    }
}

fun sum(firstNumber: Int, secondNumber: Int) : Int {
    return firstNumber + secondNumber
}