package models;

public class DHTSensor {
    String id;
    Float temperature;
    Float humidity;
    Long epochTime;

    public DHTSensor(String id, Float temperature, Float humidity, Long epochTime) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.epochTime = epochTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Long getEpochTime() {
        return epochTime;
    }

    public void setEpochTime(Long epochTime) {
        this.epochTime = epochTime;
    }
}
