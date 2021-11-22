fun main() {

    // Create a list of 3 countries
    val countries = listOf("Saudi Arabia", "Egypt", "Kuwait")

    // Create an empty ArrayList
    val capitalCity = ArrayList<String>()

    // Ask the user to enter the capital of each country in the list
    for (country in countries) {
        print("Enter the capital of $country: ")

        // // Add each capital to the ArrayList
        capitalCity.add(readLine()!!)
    }
    // Print all countries and their capitals by iterating through the list and the ArrayList
    for (i in 0..countries.size-1) {
        println("The capital city in ${countries[i]} is: ${capitalCity[i]} ")
    }
}