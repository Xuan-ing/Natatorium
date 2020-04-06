package pojo;

import java.sql.Date;

public class Record {
    private int id;
    private Date date;
    private Boolean type;
    private EventRecord eventRecord;
    private UsageRecord usageRecord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (id != record.id) return false;
        if (date != null ? !date.equals(record.date) : record.date != null) return false;
        if (type != null ? !type.equals(record.type) : record.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    public EventRecord getEventRecord() {
        return eventRecord;
    }

    public void setEventRecord(EventRecord eventRecord) {
        this.eventRecord = eventRecord;
    }

    public UsageRecord getUsageRecord() {
        return usageRecord;
    }

    public void setUsageRecord(UsageRecord usageRecord) {
        this.usageRecord = usageRecord;
    }
}
