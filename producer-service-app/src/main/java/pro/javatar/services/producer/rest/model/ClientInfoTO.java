package pro.javatar.services.producer.rest.model;

import java.time.Instant;

public class ClientInfoTO {
    private String id;
    private Long time;

    public ClientInfoTO() {
    }

    public ClientInfoTO(String id, Long time) {
        this.id = id;
        this.time = time;
    }

    public ClientInfoTO(String id) {
        this(id, Instant.now().toEpochMilli());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
