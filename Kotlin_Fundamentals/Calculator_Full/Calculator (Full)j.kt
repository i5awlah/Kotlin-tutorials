var flag = true

fun main() {
    do {
        flag = true
        print("Enter your first number: ")
        val userNumber1 = numberCheck(readLine())
        println("$userNumber1")

        print("Enter operator: ")
        val operator = readLine()
        println("$userNumber1 $operator")

        print("Enter your second number: ")
        val userNumber2 = numberCheck(readLine())

        val result = calc(userNumber1, userNumber2, operator)
        println("$userNumber1 $operator $userNumber2 = $result")
    } while (!flag)
}

fun numberCheck(userNumber: String?) : Int {
    return try {
        userNumber!!.toInt()

    } catch (e: Exception) {
        0
    }
}

fun calc(firstNumber: Int, secondNumber: Int, operator: String?) : Int {
    return when (operator) {
        "+" -> firstNumber + secondNumber
        "-" -> firstNumber - secondNumber
        "*" -> firstNumber * secondNumber
        "/" -> {
            if (secondNumber == 0) {
                println("You can't divide by 0")
                flag = false
                0
            } else firstNumber / secondNumber
        }
        else -> {
            println("Wrong operator")
            0
        }
    }
}
