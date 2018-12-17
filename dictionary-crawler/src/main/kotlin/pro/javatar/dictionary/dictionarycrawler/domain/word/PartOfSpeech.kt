package pro.javatar.dictionary.dictionarycrawler.domain.word

enum class PartOfSpeech(val value:String) {
    VERB("дієслово"),
    NOUN("іменник"),
    ADJECTIVE("прикметник"),
    ADVERB("прислівник"),
    PRONOUN("займенник"),
    PREPOSITION("прийменник"),
    CONJUNCTIVE("сполучник"),
    FRACTION("частка"),
    UNKNOWN("UNKNOWN")
}