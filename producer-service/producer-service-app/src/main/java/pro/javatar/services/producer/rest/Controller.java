package pro.javatar.services.producer.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.javatar.services.producer.rest.model.ClientInfoTO;

@RestController
@RefreshScope
public class Controller {

    @Value("${my.id:default}")
    private String clientId;

    @GetMapping("client-info")
    public ClientInfoTO getClientInfo(){
        return new ClientInfoTO(clientId);
    }
}
