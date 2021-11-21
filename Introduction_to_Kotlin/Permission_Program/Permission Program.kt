fun main() {
    // Create a variable that holds a minimum age
    var minimumAge = 20

    // Ask the user to enter their age
    print("Enter your age:  ")

    // Use a try block to make sure user enters a number
    try {
        var userAge = readLine()!!.toInt()

        // Use an if statement to check the user age against the minimum age
        if (minimumAge < userAge) {
            println("Welcome!")
        }
        else {
            // Display a message to the user that tells them whether they are old enough
            println("You are not old enough...")
        }
    } catch (e: Exception) {
        println("Please enter numbers only")
    }
}