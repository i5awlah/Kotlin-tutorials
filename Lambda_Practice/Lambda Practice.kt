
fun main() {

    // Find one function (with no parameters) you have used in the past and rewrite it using a lambda expression

    val welcomeLambda = { println("Welcome in my app!") }
    fun welcomeFun() {
        println("Welcome in my app!")
    }
    welcomeLambda()
    welcomeFun()

    // Find two functions that take in one or more parameters and rewrite them using a lambda expression

    val addLambda = { a: Int, b: Int -> println(a + b) }
    fun addFun(a: Int, b: Int)  {
        println(a + b)
    }
    addLambda(10,8)
    addFun(10,8)

    val subLambda = { a: Int, b: Int -> println(a - b) }
    fun subFun(a: Int, b: Int)  {
        println(a - b)
    }
    subLambda(10,8)
    subFun(10,8)

    // Find two functions that return a value and rewrite them using a lambda expression

    val multiplicationLambda = { a: Int, b: Int -> a * b }
    fun multiplicationFun(a: Int, b: Int) : Int {
        return a * b
    }
    println (multiplicationLambda(10,8))
    println (multiplicationFun(10,8))

    val divisionLambda = { a: Int, b: Int -> a/b }
    fun divisionFun(a: Int, b: Int) : Int {
        return a/b
    }
    println (divisionLambda(10,5))
    println (divisionFun(10,5))

    // Make use of a data class to create a Player class with attributes name, age, height (in cm)
    data class Player(val name: String, val age: Int, val height: Int)

    // Create a list of 20 players
    val playersList = arrayListOf(
        Player("Ahmed",20,120),
        Player("Amjad",43,110),
        Player("Ibrahim",53,140),
        Player("Noura",25,160),
        Player("Sara",32,150),
        Player("Asma",82,100)
    )

    // Use a lambda expression to sort and print the list by each attribute
    playersList.sortBy { it.height }
    playersList.forEach { println("Name: ${it.name} Age: ${it.age} Height: ${it.height}") }

    // When sorting the list of players, try using the filter method to exclude certain players
    playersList.filter { it.age > 25 }.forEach { println("Name: ${it.name} Age: ${it.age} Height: ${it.height}") }
}