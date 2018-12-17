package pro.javatar.dictionary.dictionarycrawler.domain

import javax.persistence.*

@Entity
data class LinkItem(
        val name: String,
        val link: String,
        @Enumerated(EnumType.STRING)
        val type: LinkType,
        @ManyToOne
        val parent: LinkItem?
) {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Enumerated(EnumType.STRING)
    var status: SourceStatus = SourceStatus.NEW

    constructor(name: String, link: String, type: LinkType, parent: LinkItem?, status: SourceStatus): this(name, link, type, parent) {
        this.status = status;
    }
}