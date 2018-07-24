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
    private long id;                // auto
    private String deviceToken;     // 36c67b3925efab91dfd996c7ac5edcc2c4e39cb79d85943f246389476e6f3df4
    private String payload;         // {‘aps’:{“alert”:’111’,’sensor_config’:[{*},{**},{***}]}
    // *    "duty_cycle_interval": 10, "interval": 1, "sensor": "acc"
    // **   "duty_cycle_interval": 10, "interval": 1, "sensor": "act"
    // ***  "duty_cycle_interval": 10, "interval": 1, "sensor": "loc"
    // **** "duty_cycle_interval": 10, "interval": 1, "sensor": "aud"
    private long timeQueued;        // 1513632469879
    private long timeSent;          // NULL or 1532438378122

    public long getId() {
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

    public long getTimeQueued() {
        return timeQueued;
    }

    public void setTimeQueued(long timeQueued) {
        this.timeQueued = timeQueued;
    }

    public long getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(long timeSent) {
        this.timeSent = timeSent;
    }
}
