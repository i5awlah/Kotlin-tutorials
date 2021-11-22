fun main() {

    // Create an ArrayList of ArrayLists containing two strings (country and capital)
    val countries = arrayListOf<ArrayList<String>>()

    // Create a string variable to hold a country and a string variable to hold a capital
    var country: String
    var capital: String

    // Ask the user to enter a country and capital, then add the pair to the 2d ArrayList
    for (i in 1..3) {
        println("Enter a country and capital")
        print("country: ")
        country = readLine()!!
        print("capital: ")
        capital = readLine()!!
        countries.add(arrayListOf(country, capital))
    }

    // After the user has entered 3 pairs, print each country and its capital
    for (country in countries) {
        println(country)
    }
}