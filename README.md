# Лабораторная работа №13-14
Коллекции, обобщения и функциональный стиль в Kotlin

## Описание
Данная лабораторная работа посвящена изучению продвинутых возможностей языка Kotlin,
которые активно используются при разработке Android-приложений

В рамках работы рассматриваются:
- обобщённые типы (Generics)
- коллекции Kotlin (Array, List, Set, Map)
- функции высшего порядка (forEach, map, filter, groupBy, fold, sortedBy)
- extension-функции и свойства
- data class, enum class, sealed class
- singleton и companion object
- scope-функции (let, apply)
- интерфейсы

## Структура проекта
- `Question.kt` - обобщённый класс вопроса, enum Difficulty, data class, singleton, companion object, интерфейс ProgressPrintable, scope-функции
- `Collection.kt` - работа с Array, List, Set, Map
- `HigherOrderFunctions.kt` - функции высшего порядка: передача функции как параметра, возврат функции
- `HigherOrderFunctionsList.kt` - HOF для коллекций: forEach, map, filter, groupBy, fold, sortedBy
- `LibrarySystem.kt` - самостоятельное задание: библиотечная система с generics, sealed class, HOF

## Примеры

### Generics
```kotlin
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)
```

### Enum class
```kotlin
enum class Difficulty { EASY, MEDIUM, HARD }
```

### Функции высшего порядка
```kotlin
val softBaked = cookies.filter { it.softBaked }
val total = cookies.fold(0.0) { acc, c -> acc + c.price }
val sorted = cookies.sortedBy { it.name }
```

## Как запустить проект
1. Клонируйте репозиторий:
```bash
git clone https://github.com/Arina-loiko/kotlin_lab13_14.git
```
2. Откройте в IntelliJ IDEA
3. Запустите нужный файл через функцию main()

## Автор
Лойко Арина Станиславна, группа ИСП-232

## Лицензия
Проект создан в учебных целях
