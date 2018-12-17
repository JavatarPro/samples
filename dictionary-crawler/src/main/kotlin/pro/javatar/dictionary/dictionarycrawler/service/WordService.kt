package pro.javatar.dictionary.dictionarycrawler.service

import pro.javatar.dictionary.dictionarycrawler.domain.LinkItem
import pro.javatar.dictionary.dictionarycrawler.domain.word.Word

interface WordService {

    fun loadGroup(group: LinkItem): List<Word>

    fun load(word: Word): Word

    fun save(word: Word): Word

    fun getByLetter(letter: LinkItem): List<Word>

    fun getOpenWords(): List<Word>

    fun getOpenWordsByGroup(group: LinkItem): List<Word>
}