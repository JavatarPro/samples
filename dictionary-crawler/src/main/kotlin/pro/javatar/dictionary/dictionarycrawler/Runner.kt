package pro.javatar.dictionary.dictionarycrawler

import pro.javatar.dictionary.dictionarycrawler.service.LinkItemServiceImpl
import pro.javatar.dictionary.dictionarycrawler.service.WordServiceImpl

fun main(args: Array<String>) {
    val baseUrl = "https://url.to.the.online.dictionaty/"
    val service = LinkItemServiceImpl()
    val wordService = WordServiceImpl()


    service.lettersUrl = "${baseUrl}index.php"
    service.baseUrl = baseUrl
    wordService.baseUrl = baseUrl

    val letters = service.loadLetters()

    val selectedLetter = letters.get(1);

    val groups = service.loadGroups(selectedLetter)

    val words = wordService.loadGroup(groups.first())

    println("${letters.size} letters, ${groups.size} groups for letter \"${selectedLetter.name}\"")
    println("Letter \"${selectedLetter.name}\". ${words.size} words were found in group \"${groups.first().name}\"")

    val word = wordService.load(words.get(7))

    println("${word.value} was loaded ${word}")
}
