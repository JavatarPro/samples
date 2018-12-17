package pro.javatar.dictionary.dictionarycrawler.repository

import org.springframework.data.repository.CrudRepository
import pro.javatar.dictionary.dictionarycrawler.domain.LinkItem
import pro.javatar.dictionary.dictionarycrawler.domain.SourceStatus
import pro.javatar.dictionary.dictionarycrawler.domain.word.Word

interface WordRepository : CrudRepository<Word, Long> {

    fun findWordsByStatus(status: SourceStatus): List<Word>

    fun findWordsByGroup(group: LinkItem): List<Word>

    fun findWordsByStatusIn(statuses: List<SourceStatus>): List<Word>

    fun findWordsByGroupAndStatusIn(group: LinkItem, statuses: List<SourceStatus>): List<Word>
}