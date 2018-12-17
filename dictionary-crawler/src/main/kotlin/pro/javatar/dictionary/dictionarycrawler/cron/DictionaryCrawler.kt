package pro.javatar.dictionary.dictionarycrawler.cron

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import pro.javatar.dictionary.dictionarycrawler.domain.SourceStatus
import pro.javatar.dictionary.dictionarycrawler.service.LinkItemService
import pro.javatar.dictionary.dictionarycrawler.service.WordService

@Service
class DictionaryCrawler(@Autowired val wordService: WordService, @Autowired val linkItemService: LinkItemService) {
    private val log = LoggerFactory.getLogger(javaClass)

    @Scheduled(cron = "\${dictionary.groups.cron}")
    fun processGroups() {
        log.info("***** Start groups processing *****")

        val openGroups = linkItemService.getOpenGroups()
        log.info("${openGroups.size} open groups were found")

        val group = openGroups.first()
        log.info("$group would be processed")

        wordService.loadGroup(group)

        group.status = SourceStatus.DONE
        linkItemService.save(group)
        log.info("${group.name} group status was changed to DONE")
        log.info("***** End groups processing *****")
    }

    @Scheduled(cron = "\${dictionary.words.cron}")
    fun processWords() {
        log.info("***** Start word processing *****")
        val openWords = wordService.getOpenWords()
        log.info("${openWords.size} open words were found")

        val word = openWords.first()
        wordService.load(word)

        word.status = SourceStatus.DONE
        wordService.save(word)
        log.info("${word.value} word content was successfully saved")
        log.info("***** End word processing *****")

//        if (word.group != null) {
//            val emptyWordsByGroup = wordService.getOpenWordsByGroup(word.group)
//
//            if (emptyWordsByGroup.isEmpty()) {
//                linkItemService.closeGroup(word.group)
//                println("Group ${word.group} was closed")
//            }
//        }
    }
}