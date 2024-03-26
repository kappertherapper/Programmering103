package Opgaver

data class Person (
    val name: String,
    val age: Int
)



fun main() {
    val persons = listOf(
        Person("Alice", 30),
        Person("Bob", 25),
        Person("Charlie", 35),
        Person("Dave", 40),
        Person("Eve", 20),
        Person("Frank", 45),
        Person("Grace", 28)
    )

    fun findFirst(persons: List<Person>, condition: (Person) ->  Boolean): Person? {
        for (person in persons) {
            if (condition(person)) return person
        }
        return null
    }

    val p30 = findFirst(persons) { it.age < 30 }



    val p40 = findFirst(persons) { it.age == 40 }
    //println("The first person who is 40 years old is: ${p40?.name}")
    val p40lambda = findFirst(persons) {
            p : Person -> p.age == 44
    }.also(::println )



}



