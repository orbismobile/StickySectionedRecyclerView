package pe.com.orbis.stickysectionedrcv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pe.com.orbis.stickysectionedrcv.model.NotificationEntity;
import pe.com.orbis.stickysectionedrcv.model.NotificationSectionEntity;
import pe.com.orbis.stickysectionedrcv.view.StickyHeaderLayoutManager;
import pe.com.orbis.stickysectionedrcv.view.adapter.NotificationSectionAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvNotification;
    NotificationSectionAdapter adapter;
    List<NotificationSectionEntity> listNotificationSectionEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvNotification = (RecyclerView) findViewById(R.id.rcvNotification);
        rcvNotification.setLayoutManager(new StickyHeaderLayoutManager());
        listNotificationSectionEntity = new ArrayList<>();
        adapter = new NotificationSectionAdapter(this);


        List<NotificationEntity> listNotification = new ArrayList<>();
        listNotification.add(new NotificationEntity("1","Nueva coincidencia con tu búsqueda guardada",
                "Revisa las últimas coincidencias de tu búsqueda","12:00 a.m","1","0"));
        listNotification.add(new NotificationEntity("1","Invitación a proceso",
                "Grupo Pana te ha invitado a tomar parte en su proceso de selcción","10:34 a.m","1","0"));
        NotificationSectionEntity notificationSectionEntity = new NotificationSectionEntity("Hoy",listNotification);
        listNotificationSectionEntity.add(notificationSectionEntity);



        List<NotificationEntity> listNotification2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            listNotification2.add(new NotificationEntity("1","Han revisado tu CV",
                    "Alguien ha revisado tu perfil público , mantenlo actualizado para mejorar tus posibilidades",
                    "12:20 p.m","1","0"));
        }
        NotificationSectionEntity notificationSectionEntity2 = new NotificationSectionEntity("Ayer",listNotification2);
        listNotificationSectionEntity.add(notificationSectionEntity2);



        List<NotificationEntity> listNotification3 = new ArrayList<>();
        listNotification3.add(new NotificationEntity("1","Han revisado tu CV en un proceso",
                "Alguien ha revisado tu CV en un proceso al que has postulad.",
                "11:20 p.m","0","0"));
        for (int i = 0; i < 5; i++) {
            listNotification3.add(new NotificationEntity("1","Nuevo mensaje",
                    "Has recibido un mensaje de Corporación Lindley S.A.",
                    "11:20 p.m","0","0"));
        }
        NotificationSectionEntity notificationSectionEntity3 = new NotificationSectionEntity("15/12/15",listNotification3);
        listNotificationSectionEntity.add(notificationSectionEntity3);


        adapter.setNotificationSection(listNotificationSectionEntity);
        rcvNotification.setAdapter(adapter);
    }

}
