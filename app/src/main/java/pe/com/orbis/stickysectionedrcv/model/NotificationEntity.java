package pe.com.orbis.stickysectionedrcv.model;

public class NotificationEntity{

    private String id;
    private String title;
    private String description;
    private String hour;
    private String state;
    private String intentActivity;

    public NotificationEntity() {
    }

    public NotificationEntity(String id, String title, String description, String hour, String state, String intentActivity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.hour = hour;
        this.state = state;
        this.intentActivity = intentActivity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getIntentActivity() {
        return intentActivity;
    }

    public void setIntentActivity(String intentActivity) {
        this.intentActivity = intentActivity;
    }
}