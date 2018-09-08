package pro.javatar.services.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pro.javatar.services.consumer.client.model.ClientInfo;

@FeignClient("producer-service")
public interface ProducerClient {

    @RequestMapping(value = "client-info", method = RequestMethod.GET)
    ClientInfo getClientInfo();
}