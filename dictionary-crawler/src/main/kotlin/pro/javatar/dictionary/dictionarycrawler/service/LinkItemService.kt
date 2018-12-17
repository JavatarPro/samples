package pro.javatar.dictionary.dictionarycrawler.service

import pro.javatar.dictionary.dictionarycrawler.domain.LinkItem

interface LinkItemService {

    fun loadLetters(): List<LinkItem>

    fun isLettersPresent(): Boolean

    fun loadGroups(letter: LinkItem): List<LinkItem>

    fun getOpenGroups(): List<LinkItem>

    fun closeGroup(group: LinkItem)

    fun save(item: LinkItem): LinkItem
}