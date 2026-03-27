val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
val solarSystem = rockPlanets + gasPlanets

fun main() {
    println(solarSystem[0])
    println(solarSystem[1])
    println(solarSystem[2])
    println(solarSystem[3])
    println(solarSystem[4])
    println(solarSystem[5])
    println(solarSystem[6])
    println(solarSystem[7])

    solarSystem[3] = "Little Earth"
    println(solarSystem[3])

    val newSolarSystem = arrayOf(
        "Mercury",
        "Venus",
        "Earth",
        "Mars",
        "Jupiter",
        "Saturn",
        "Uranus",
        "Neptune",
        "Pluto"
    )
    println(newSolarSystem[8])

    val solarSystemList = mutableListOf(
        "Mercury", "Venus", "Earth", "Mars",
        "Jupiter", "Saturn", "Uranus", "Neptune"
    )

    println(solarSystemList.size)
    println(solarSystemList[2])
    println(solarSystemList.get(3))
    println(solarSystemList.indexOf("Earth"))
    println(solarSystemList.indexOf("Pluto"))

    for (planet in solarSystemList) {
        println(planet)
    }

    solarSystemList.add("Pluto")
    solarSystemList.add(index = 3, element = "Theia")
    solarSystemList[3] = "Future Moon"
    println(solarSystemList[3])
    println(solarSystemList[9])
    solarSystemList.removeAt(index = 9)
    solarSystemList.remove("Future Moon")
    println(solarSystemList.contains("Pluto"))
    println("Future Moon" in solarSystemList)

    val solarSystemSet = mutableSetOf(
        "Mercury", "Venus", "Earth", "Mars",
        "Jupiter", "Saturn", "Uranus", "Neptune"
    )

    println(solarSystemSet.size)
    solarSystemSet.add("Pluto")
    println(solarSystemSet.size)
    println(solarSystemSet.contains("Pluto"))
    println("Pluto" in solarSystemSet)
    solarSystemSet.add("Pluto")
    println(solarSystemSet.size)
    solarSystemSet.remove(element = "Pluto")
    println(solarSystemSet.size)
    println(solarSystemSet.contains("Pluto"))

    val solarSystemMap = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    println(solarSystemMap.size)
    solarSystemMap["Pluto"] = 5
    println(solarSystemMap.size)
    println(solarSystemMap["Pluto"])
    println(solarSystemMap.get("Theia"))
    solarSystemMap.remove(key = "Pluto")
    println(solarSystemMap.size)
    solarSystemMap["Jupiter"] = 78
    println(solarSystemMap["Jupiter"])
}
