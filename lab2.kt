open class Person(var name: String, var birthYear: Int) {
    var age: Int = 2021 - birthYear
}

class Student(
    S_name: String, S_birthYear: Int,
    var averageGrade: Double,
    var extramural: Boolean = false
) :
    Person(S_name, S_birthYear) {

}

class Lecturer(
    L_name: String, L_birthYear: Int,
    var degree: String,
    var experienceFrom: Int
) :
    Person(L_name, L_birthYear) {

}

fun main() {
    var persons = listOf(
        Student("Казантипов Олег", 2000, 4.3),
        Student("Приемников Паша", 2001, 4.1),
        Student("Растрворова Екатерина", 2000, 3.9, true),
        Student("Морозов Даниил", 2001, 4.6),
        Student("Отличников Антон", 2002, 5.0, true),
        Lecturer("Панасенко Пётр", 1972, "Кандидат технических наук", 2001),
        Lecturer("Агафонов Владимир", 1975, "Кандидат педагогических наук", 2004),
        Lecturer("Липова Надежда", 1981, "Кандидат экономических наук", 2010),
        Lecturer("Дебоширов Алексей", 1954, "Доктор технических наук", 1992),
        Lecturer("Берёзова Татьяна", 1963, "Доктор филологических наук", 2001)
    )

    println("Сортировка списка Persons по возрасту в порядке убывания:")
    persons.sortByAge().forEach { println("Имя: ${it.name} | Возраст: ${it.age}") }

    println("\nСортировка Students по имени в порядке убывания:")
    var persons_S = mutableListOf<Student>()
    persons.forEach { if (it is Student) persons_S.add(it) }
    persons_S.sortByNameStudents().forEach { println("Имя: ${it.name} | Возраст: ${it.age}") }

    println("\nСортировка очников по средней оценке в порядке убывания")
    persons_S.sortByAverageGrade(true).forEach { println("Имя: ${it.name} | Возраст: ${it.averageGrade}") }

}

fun List<Person>.sortByAge(): List<Person> {

    return this.sortedByDescending { it.age }
}

fun List<Student>.sortByNameStudents(): List<Student> {

    return this.sortedByDescending { it.name }
}

fun List<Student>.sortByAverageGrade(exceptExtramural: Boolean): List<Student> {

    return if (!exceptExtramural)
        this.sortedByDescending { it.averageGrade }
    else {
        this.filter { !it.extramural }.sortedByDescending { it.averageGrade }
    }
}