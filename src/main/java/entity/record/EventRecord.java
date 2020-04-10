package entity.record;

import javax.xml.parsers.SAXParser;

public class EventRecord extends Record {
    private String reason;
    private String  eventType;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String type) {
        this.eventType = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventRecord that = (EventRecord) o;

        if (getId() != that.getId()) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (eventType != null ? !eventType.equals(that.eventType) : that.eventType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        return result;
    }
}
