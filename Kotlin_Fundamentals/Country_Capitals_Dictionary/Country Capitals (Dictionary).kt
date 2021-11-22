fun main() {
    // Create a mutable dictionary
    val countriesDict = mutableMapOf<String, String>()

    var country: String
    var capital: String

    for (i in 1..3) {
        println("Enter a country and capital")

        // Ask users to enter a country and save it as the key
        print("country: ")
        country = readLine()!!

        // Ask user to enter a capital and save it as the value
        print("capital: ")
        capital = readLine()!!
        countriesDict[country] = capital
    }

    // After user has entered 3 pairs, print each country and its capital
    for (country in countriesDict) {
        println("The capital city in ${country.key} is: ${country.value} ")
    }
}