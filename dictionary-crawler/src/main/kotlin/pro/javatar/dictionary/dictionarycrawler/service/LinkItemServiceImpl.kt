package pro.javatar.dictionary.dictionarycrawler.service

import org.jsoup.Jsoup
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import pro.javatar.dictionary.dictionarycrawler.domain.LinkItem
import pro.javatar.dictionary.dictionarycrawler.domain.LinkType
import pro.javatar.dictionary.dictionarycrawler.domain.SourceStatus
import pro.javatar.dictionary.dictionarycrawler.repository.LinkItemRepository

@Service
class LinkItemServiceImpl : LinkItemService {
    private val log = LoggerFactory.getLogger(javaClass);

    @Value("\${dictionary.letters.url}")
    internal var lettersUrl: String? = null

    @Value("\${dictionary.base-url}")
    lateinit var baseUrl: String

    @Value("\${dictionary.letters.selector}")
    lateinit var letterSelector: String

    @Value("\${dictionary.groups.selector}")
    lateinit var groupSelector: String

    @Autowired
    lateinit var repository: LinkItemRepository

    override fun save(item: LinkItem): LinkItem {
        return repository.save(item)
    }

    override fun closeGroup(group: LinkItem) {
        log.info("Close group ${group.name}")
        group.status = SourceStatus.DONE
        repository.save(group)
    }

    override fun getOpenGroups(): List<LinkItem> {
        val statuses = listOf(SourceStatus.NEW, SourceStatus.IN_PROGRESS)
        log.info("Retrieving open groups by statuses $statuses")
        return repository.findByTypeAndStatusIn(LinkType.GROUP, statuses)
    }

    override fun isLettersPresent(): Boolean {
        val list = repository.findByType(LinkType.LETTER)
        return list.isNotEmpty()
    }

    override fun loadLetters(): List<LinkItem> {
        val list: MutableList<LinkItem> = mutableListOf()
        log.info("Download letters from $lettersUrl")
        val doc = Jsoup.connect(lettersUrl).get()
        val letters = doc.select(letterSelector)
        for (letter in letters) {
            val href = letter.attr("href")
            val name = letter.text()
            val item = LinkItem(name, href, LinkType.LETTER, null, SourceStatus.DONE)
            list.add(item)
        }
        repository.saveAll(list)
        log.info("${list.size} letters were processed")
        return list;
    }

    override fun loadGroups(letter: LinkItem): List<LinkItem> {
        val list: MutableList<LinkItem> = mutableListOf()
        val groupUrl = baseUrl + letter.link
        log.info("Download groups for letter ${letter.name} from url $groupUrl")
        val doc = Jsoup.connect(groupUrl).get()
        val groups = doc.select(groupSelector)
        for (group in groups) {
            val href = baseUrl + group.attr("href")
            val name = group.text()
            list.add(LinkItem(name, href, LinkType.GROUP, letter))
        }
        repository.saveAll(list)
        log.info("${list.size} groups were processed")
        return list;
    }
}