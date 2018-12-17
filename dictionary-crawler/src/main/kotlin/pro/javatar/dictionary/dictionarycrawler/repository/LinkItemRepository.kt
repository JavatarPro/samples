package pro.javatar.dictionary.dictionarycrawler.repository

import org.springframework.data.repository.CrudRepository
import pro.javatar.dictionary.dictionarycrawler.domain.LinkItem
import pro.javatar.dictionary.dictionarycrawler.domain.LinkType
import pro.javatar.dictionary.dictionarycrawler.domain.SourceStatus

interface LinkItemRepository : CrudRepository<LinkItem, Long> {

    fun findByType(type: LinkType): List<LinkItem>

    fun findByTypeAndStatusIn(type: LinkType, status: List<SourceStatus>): List<LinkItem>
}