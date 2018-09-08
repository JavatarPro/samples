package pro.javatar.services.consumer.mapper;

import org.mapstruct.Mapper;
import pro.javatar.services.consumer.client.model.ClientInfo;
import pro.javatar.services.consumer.rest.model.ProducerInfoTO;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface InfoMapper {

    ProducerInfoTO toProducerInfo(ClientInfo info);

    default Long instantToLong(Instant time){
        return time.toEpochMilli();
    }
}