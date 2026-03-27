data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val isbn: String
)

data class Magazine(
    val title: String,
    val issue: Int,
    val month: String
)

data class DVD(
    val title: String,
    val director: String,
    val duration: Int
)

sealed class LibraryItem {
    data class BookItem(val book: Book) : LibraryItem()
    data class MagazineItem(val magazine: Magazine) : LibraryItem()
    data class DVDItem(val dvd: DVD) : LibraryItem()
}

class Library<T> {
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    fun getAll(): List<T> = items
}

fun filterByYear(books: List<Book>, year: Int): List<Book> {
    return books.filter { it.year == year }
}

fun sortByTitle(items: List<LibraryItem>): List<LibraryItem> {
    return items.sortedBy {
        when (it) {
            is LibraryItem.BookItem -> it.book.title
            is LibraryItem.MagazineItem -> it.magazine.title
            is LibraryItem.DVDItem -> it.dvd.title
        }
    }
}

fun groupByAuthor(books: List<Book>): Map<String, List<Book>> {
    return books.groupBy { it.author }
}

fun calculateTotalDuration(dvds: List<DVD>): Int {
    return dvds.fold(0) { total, dvd -> total + dvd.duration }
}

fun main() {
    val bookLibrary = Library<Book>()
    bookLibrary.add(Book("Война и мир", "Лев Толстой", 1869, "978-5-04-001"))
    bookLibrary.add(Book("Преступление и наказание", "Достоевский", 1866, "978-5-04-002"))
    bookLibrary.add(Book("Анна Каренина", "Лев Толстой", 1878, "978-5-04-003"))
    bookLibrary.add(Book("Идиот", "Достоевский", 1869, "978-5-04-004"))

    val dvdLibrary = Library<DVD>()
    dvdLibrary.add(DVD("Матрица", "Вачовски", 136))
    dvdLibrary.add(DVD("Интерстеллар", "Нолан", 169))
    dvdLibrary.add(DVD("Начало", "Нолан", 148))

    val magazineLibrary = Library<Magazine>()
    magazineLibrary.add(Magazine("Наука и жизнь", 1, "January"))
    magazineLibrary.add(Magazine("Природа", 3, "March"))

    val books1869 = filterByYear(bookLibrary.getAll(), 1869)
    println("Книги 1869 года:")
    books1869.forEach { println("${it.title} - ${it.author}") }

    val allItems = listOf(
        LibraryItem.BookItem(bookLibrary.getAll()[0]),
        LibraryItem.DVDItem(dvdLibrary.getAll()[0]),
        LibraryItem.MagazineItem(magazineLibrary.getAll()[0]),
        LibraryItem.BookItem(bookLibrary.getAll()[1])
    )
    val sorted = sortByTitle(allItems)
    println("Отсортированные по названию:")
    sorted.forEach {
        when (it) {
            is LibraryItem.BookItem -> println(it.book.title)
            is LibraryItem.MagazineItem -> println(it.magazine.title)
            is LibraryItem.DVDItem -> println(it.dvd.title)
        }
    }

    val grouped = groupByAuthor(bookLibrary.getAll())
    println("Книги по авторам:")
    grouped.forEach { (author, books) ->
        println("$author: ${books.map { it.title }}")
    }

    val totalDuration = calculateTotalDuration(dvdLibrary.getAll())
    println("Общая длительность DVD: $totalDuration минут")
}
