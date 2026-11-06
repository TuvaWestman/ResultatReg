
package se.ltu.resultatregistrering.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registration_log")
public class RegistrationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Integer logId;

    @ManyToOne
    @JoinColumn(name = "result_id", nullable = false)
    private Result result;

    @Column(name = "event_type", nullable = false, length = 30)
    private String eventType;

    @Column(name = "event_time", nullable = false,
            insertable = false, updatable = false)
    private LocalDateTime eventTime;

    @Column(length = 255)
    private String description;

    public RegistrationLog() {
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
