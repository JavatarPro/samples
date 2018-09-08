package pro.javatar.services.consumer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.javatar.services.consumer.client.ProducerClient;
import pro.javatar.services.consumer.client.model.ClientInfo;
import pro.javatar.services.consumer.mapper.InfoMapper;
import pro.javatar.services.consumer.rest.model.ProducerInfoTO;

@RestController
public class Controller {

    @Autowired
    private ProducerClient client;

    @Autowired
    private InfoMapper mapper;

    @GetMapping("producer-info")
    public ProducerInfoTO getProducerInfo() {
        ClientInfo info = client.getClientInfo();
        return mapper.toProducerInfo(info);
    }
}