data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}

class Quiz : ProgressPrintable {
    val question1 = Question<String>(
        questionText = "Речка спятила с ума - По домам пошла сама. ___",
        answer = "водопровод",
        difficulty = Difficulty.MEDIUM
    )
    val question2 = Question<Boolean>(
        questionText = "Небо зелёное. Правда или ложь",
        answer = false,
        difficulty = Difficulty.EASY
    )
    val question3 = Question<Int>(
        questionText = "Сколько дней между полнолуниями?",
        answer = 28,
        difficulty = Difficulty.HARD
    )

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "${answered} of ${total} answered"

    override fun printProgressBar() {
        repeat(times = Quiz.answered) { print("▓") }
        repeat(times = Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()

        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}

interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}

fun main() {
    println(Question<String>(
        questionText = "Речка спятила с ума - По домам пошла сама. ___",
        answer = "водопровод",
        difficulty = Difficulty.MEDIUM
    ).toString())

    Quiz().apply { printQuiz() }
}
