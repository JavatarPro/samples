package pro.javatar.services.producer.rest.model;

import java.time.Instant;

public class ClientInfoTO {
    private String id;
    private Instant time;

    public ClientInfoTO() {
    }

    public ClientInfoTO(String id, Instant time) {
        this.id = id;
        this.time = time;
    }

    public ClientInfoTO(String id) {
        this(id, Instant.now());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getTime() {
        return time;
    }

    public void setTime(Instant time) {
        this.time = time;
    }
}
