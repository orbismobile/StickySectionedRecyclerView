package pe.com.orbis.stickysectionedrcv.model;

import java.util.List;

/**
 * Created by carlos on 25/05/16.
 * Alias: CarlitosDroid
 */
public class NotificationSectionEntity {

    private String date;
    private List<NotificationEntity> notificationEntity;

    public NotificationSectionEntity() {

    }

    public NotificationSectionEntity(String date, List<NotificationEntity> notificationEntity) {
        this.date = date;
        this.notificationEntity = notificationEntity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<NotificationEntity> getNotificationEntity() {
        return notificationEntity;
    }

    public void setNotificationEntity(List<NotificationEntity> notificationEntity) {
        this.notificationEntity = notificationEntity;
    }

}
