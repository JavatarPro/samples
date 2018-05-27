package pro.javatar.services.producer.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.javatar.services.producer.rest.model.ClientInfo;

@RestController
public class Controller {

    @Value("${my.id:default}")
    private String clientId;

    @GetMapping("client-info")
    public ClientInfo getClientInfo(){
        return new ClientInfo(clientId);
    }
}
