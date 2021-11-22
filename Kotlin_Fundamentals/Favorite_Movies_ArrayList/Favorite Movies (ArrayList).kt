fun main() {
    // Create an ArrayList
    var moviesList = ArrayList<String>()

    // Ask the user to enter their favorite movies
    println("Please enter favorite movies")

    // The user must enter at least 3 items
    while (true) {
        print("${moviesList.size+1}: ")
        // Add each item to the ArrayList
        moviesList.add(readLine()!!)

        // If the ArrayList has 3 or more items ask the user if they want to continue
        if (moviesList.size >= 3) {
            print("Do you want to continue? (yes/no) ")
            val userAnswer = readLine()!!

            // If the user says yes, allow them to enter another movie
            if (userAnswer == "yes" || userAnswer == "YES") continue
            // If the user says no, print all movies with a for loop
            else {
                for (movie in moviesList) {
                    println(movie)
                }
                break
            }

        }
    }

}