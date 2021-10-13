open class Person(var name: String, var birthYear: Int) {
    var age: Int = 2021 - birthYear
}

class Student(
    name_s: String, birthYear_s: Int,
    var averageGrade: Double,
    var extramural: Boolean = false
) :
    Person(name_s, birthYear_s) {

}

class Lecturer(
    name_l: String, birthYear_l: Int,
    var degree: String,
    var experienceFrom: Int
) :
    Person(name_l, birthYear_l) {

}

fun main() {
    var persons = listOf(
        Student("Фамилия1 Имя1", 2000, 4.3),
        Student("Фамилия2 Имя2", 2001, 4.1),
        Student("Фамилия3 Имя3", 2000, 3.9, true),
        Student("Фамилия4 Имя4", 2001, 4.6),
        Student("Фамилия5 Имя5", 2002, 5.0, true),
        Lecturer("Фамилия6 Имя6", 1972, "Профессор математических наук", 2001),
        Lecturer("Фамилия7 Имя7", 1975, "Кандидат филологических наук", 2004),
        Lecturer("Фамилия8 Имя8", 1981, "Кандидат экономических наук", 2010),
        Lecturer("Фамилия9 Имя9", 1954, "Доктор технических наук", 1992),
        Lecturer("Фамилия10 Имя10", 1963, "Кандидат  педагогических наук", 2001)
    )
    println("Сортировка списка Persons по возрасту в порядке убывания:")
    persons.sortByAge().forEach { println("Имя: ${it.name} | Возраст: ${it.age}") }

    println("\nСортировка Students по имени в порядке убывания:")
    var persons_stud = mutableListOf<Student>()
    persons.forEach { if (it is Student) persons_stud.add(it) }
    persons_stud.sortByNameStudents().forEach { println("Имя: ${it.name} | Возраст: ${it.age}") }

    println("\nСортировка очников по средней оценке в порядке убывания")
    persons_stud.sortByAverageGrade(true).forEach { println("Имя: ${it.name} | Возраст: ${it.averageGrade}") }

}

fun List<Person>.sortByAge() = this.sortedByDescending { it.age }

fun List<Student>.sortByNameStudents(): List<Student> =

    this.sortedByDescending { it.name }


fun List<Student>.sortByAverageGrade(exceptExtramural: Boolean): List<Student> {

    return if (!exceptExtramural)
        this.sortedByDescending { it.averageGrade }
    else {
        this.filter { !it.extramural }.sortedByDescending { it.averageGrade }
    }
}