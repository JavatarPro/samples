package pro.javatar.dictionary.dictionarycrawler

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import pro.javatar.dictionary.dictionarycrawler.service.LinkItemService
import java.util.concurrent.TimeUnit


@EnableScheduling
@EnableJpaRepositories
@SpringBootApplication
class DictionaryCrawlerApplication {
    private val log = LoggerFactory.getLogger(javaClass);

    @Autowired
    lateinit var service: LinkItemService

    @Value("\${dictionary.base-url}")
    lateinit var baseUrl: String

    @EventListener(ApplicationReadyEvent::class)
    fun doSomethingAfterStartup() {
        if (service.isLettersPresent()) {
            log.info("Wan't load letters because some are present in db")
        } else {
            log.info("Loading letters from ${baseUrl}")
            val letters = service.loadLetters()
            letters.forEach {
                service.loadGroups(it);
                TimeUnit.SECONDS.sleep(1L)
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<DictionaryCrawlerApplication>(*args)
}



