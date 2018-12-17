package pro.javatar.dictionary.dictionarycrawler.domain.word

import pro.javatar.dictionary.dictionarycrawler.domain.LinkItem
import pro.javatar.dictionary.dictionarycrawler.domain.SourceStatus
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Word(val value:String, val link:String, @ManyToOne val group: LinkItem?) {
    @Id
    @GeneratedValue
    val id:Long? = null
    @Lob
    var description:String? = null
    @Lob
    var descriptionHtml:String? = null
    var ortho: Orthography? = null
    @Lob
    var source:String? = null
    @Enumerated(EnumType.STRING)
    var status: SourceStatus = SourceStatus.NEW
    var parseDate:LocalDateTime = LocalDateTime.now()
}