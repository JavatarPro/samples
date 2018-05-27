package pro.javatar.services.consumer.client.model;

import java.time.Instant;

public class ClientInfo {
    private String id;
    private Instant time;

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