import kotlin.random.Random
fun main() {

    // Create an abstract class Animal with attributes name and age and abstract function talk
    abstract class Animal(name: String, age: Int) {
        abstract fun talk()
    }

    // Create a class Dog that inherits Animal and barks ('Name: Woof')
    class Dog(val name: String, val age: Int) : Animal(name, age) {
        override fun talk() {
            println("$name: Woof")
        }
    }

    // Create a class Cat that inherits Animal and meows ('Name: Meow')
    class Cat(val name: String, val age: Int) : Animal(name, age) {
        override fun talk() {
            println("$name: Meow")
        }
    }

    // Create a list of five dogs and a list of five cats with random ages
    val dogs = listOf(
        Dog("Rufus", Random.nextInt(1,99)),
        Dog("Fred", Random.nextInt(1,99)),
        Dog("Spot", Random.nextInt(1,99)),
        Dog("Brian", Random.nextInt(1,99)),
        Dog("Fluffy", Random.nextInt(1,99))
    )
    val cats = listOf(
        Cat("Lili", Random.nextInt(1,99)),
        Cat("Meep", Random.nextInt(1,99)),
        Cat("Patchy", Random.nextInt(1,99)),
        Cat("Furball", Random.nextInt(1,99)),
        Cat("Snowball", Random.nextInt(1,99))
    )

    // Use a loop to iterate through the list of cats and make each cat meow
    // also use a nested loop to make each dog bark if they are older than the meowing cat
    for (cat in cats) {
        cat.talk()
        for (dog in dogs) {
            if (dog.age > cat.age) {
                dog.talk()
            }
        }
    }
}