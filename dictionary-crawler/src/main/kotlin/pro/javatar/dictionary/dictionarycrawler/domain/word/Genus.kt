package pro.javatar.dictionary.dictionarycrawler.domain.word

enum class Genus(val value:String) {
    DOUBLE("чоловічий і жіночий"),
    MALE("чоловічий"),
    FEMALE("жіночий"),
    NEUTER("середній"),
    UNKNOWN("UNKNOWN")
}