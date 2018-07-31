package nd.tesserae.phoneagent.pushapns;

import nd.tesserae.phoneagent.pushapns.entities.Push;
import nd.tesserae.phoneagent.pushapns.service.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dscottnull on 7/23/18.
 */

@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PushService pushService;

    @Value("${apns_batch_size:20}")
    private int apnsBatchSize;

    @Scheduled(fixedDelayString = "${apns_interval_time_ms:2000}")
    public void doMainLoop() {
        logger.info("MAIN LOOP IS WORKING ");

        pushService.sendTestPush("this test push needs to be removed later"); // TBRemoved

        List<Push> pushes = new ArrayList<>();
        // Grab a batch of records that haven't been sent
        pushes = pushService.getSomePushesNotSentYet(apnsBatchSize);
        // Send the APNS pushes
        for (Push push : pushes) {
            pushService.sendAndUpdatePush(push);
//            pushService.sendTestPush(push.getDeviceToken());
        }
    }
}