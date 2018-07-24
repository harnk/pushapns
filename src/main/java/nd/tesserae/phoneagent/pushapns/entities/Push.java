package nd.tesserae.phoneagent.pushapns.entities;

import javax.persistence.*;

/**
 * Created by dscottnull on 7/24/18.
 */
@Entity
@Table(name = "push_queue_prod")
public class Push {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;                // auto
    private String deviceToken;     // 36c67b3925efab91dfd996c7ac5edcc2c4e39cb79d85943f246389476e6f3df4
    private String payload;         // {‘aps’:{“alert”:’111’,’sensor_config’:[{*},{**},{***}]}
    // *    "duty_cycle_interval": 10, "interval": 1, "sensor": "acc"
    // **   "duty_cycle_interval": 10, "interval": 1, "sensor": "act"
    // ***  "duty_cycle_interval": 10, "interval": 1, "sensor": "loc"
    // **** "duty_cycle_interval": 10, "interval": 1, "sensor": "aud"
    private Long timeQueued;        // 1513632469879
    private Long timeSent;          // NULL or 1532438378122

    public Long getId() {
        return id;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Long getTimeQueued() {
        return timeQueued;
    }

    public void setTimeQueued(Long timeQueued) {
        this.timeQueued = timeQueued;
    }

    public Long getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Long timeSent) {
        this.timeSent = timeSent;
    }
}
