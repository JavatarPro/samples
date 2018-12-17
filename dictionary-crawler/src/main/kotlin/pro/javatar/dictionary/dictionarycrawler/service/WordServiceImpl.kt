package pro.javatar.dictionary.dictionarycrawler.service

import org.jsoup.Jsoup
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import pro.javatar.dictionary.dictionarycrawler.domain.LinkItem
import pro.javatar.dictionary.dictionarycrawler.domain.SourceStatus
import pro.javatar.dictionary.dictionarycrawler.domain.word.Orthography
import pro.javatar.dictionary.dictionarycrawler.domain.word.Word
import pro.javatar.dictionary.dictionarycrawler.repository.WordRepository

@Service
class WordServiceImpl : WordService {
    private val log = LoggerFactory.getLogger(javaClass);

    @Value("\${dictionary.base-url}")
    lateinit var baseUrl: String

    @Value("\${dictionary.words.selectors.word}")
    lateinit var wordSelector: String

    @Value("\${dictionary.words.selectors.description}")
    lateinit var descSelector: String

    @Value("\${dictionary.words.selectors.orpho}")
    lateinit var orthoSelector: String

    @Autowired
    lateinit var repository: WordRepository

    override fun load(word: Word): Word {
        log.info("Loading content for ${word.value}...")
        val doc = Jsoup.connect(word.link).get()
        word.source = doc.toString()

        val description = doc.select(descSelector)
        word.description = description.text()
        word.descriptionHtml = description.html()

        val ortho = doc.select(orthoSelector).first()
        if (ortho != null) {
            word.ortho = Orthography(ortho.text(), ortho.html())
        }
        repository.save(word)
        log.info("Content was saved")
        return word;
    }

    override fun loadGroup(group: LinkItem): List<Word> {
        log.info("Retrieving words for group ${group.name}")
        val list: MutableList<Word> = mutableListOf()
        val doc = Jsoup.connect(group.link).get()

        val words = doc.select(wordSelector)
        log.info("${words.size} words were found")
        for (w in words) {
            val link = baseUrl + w.attr("href")
            val name = w.text().toLowerCase()
            list.add(Word(name, link, group))
        }
        repository.saveAll(list)
        log.info("${list.size} words were saved")
        return list
    }

    override fun getOpenWords(): List<Word> {
        val statuses = listOf(SourceStatus.NEW, SourceStatus.IN_PROGRESS)
        log.info("Retrieving open words by statuses $statuses")
        return repository.findWordsByStatusIn(statuses)
    }

    override fun getOpenWordsByGroup(group: LinkItem): List<Word> {
        val statuses = listOf(SourceStatus.NEW, SourceStatus.IN_PROGRESS)
        log.info("Retrieving open words by statuses $statuses and group $group")
        return repository.findWordsByGroupAndStatusIn(group, statuses)
    }

    override fun save(word: Word): Word {
        return repository.save(word)
    }

    override fun getByLetter(letter: LinkItem): List<Word> {
        log.info("Retrieving words by letter ${letter.name}")
        return repository.findWordsByGroup(letter)
    }
}