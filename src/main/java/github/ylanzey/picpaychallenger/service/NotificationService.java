package github.ylanzey.picpaychallenger.service;

import github.ylanzey.picpaychallenger.client.NotificationClient;
import github.ylanzey.picpaychallenger.entity.Transfer;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private final NotificationClient notificationClient;


    public void SendNotification(Transfer transfer) {
        try {
            logger.info("Sending notification");

            var res = notificationClient.sendNotification(transfer);

            if(res.getStatusCode().isError())
            {
                logger.error("Error while sending notification, status code is not OK");
            }

        } catch (Exception e) {
            logger.error("Error while sending notification", e);
        }
    }

}
