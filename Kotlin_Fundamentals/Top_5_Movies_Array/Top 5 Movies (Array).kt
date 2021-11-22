fun main() {
    // Create an array of five empty strings
    var movies = Array<String>(5){""}

    // Ask the user to enter their top 5 movies
    println("Please enter top 5 movies")
    for (i in 1..5) {
        print("$i: ")
        movies[i-1] = readLine()!!
    }

    // Print each movie with a for loop
    for (movie in movies) {
        println(movie)
    }
}