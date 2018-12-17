package pro.javatar.dictionary.dictionarycrawler.domain.word

import javax.persistence.*

@Embeddable
data class Orthography(@Lob val details: String, @Lob val detailsHtml: String) {
    @Enumerated(EnumType.STRING)
    val genus = Genus.values().firstOrNull { g -> details.contains(g.value, true) }
    @Enumerated(EnumType.STRING)
    val partOfSpeech = PartOfSpeech.values().firstOrNull { ps -> details.contains(ps.value, true) }
    @Enumerated(EnumType.STRING)
    val liveType = LiveType.values().firstOrNull { lt -> details.contains(lt.value, true) }
}