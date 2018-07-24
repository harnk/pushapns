package nd.tesserae.phoneagent.pushapns;

import nd.tesserae.phoneagent.pushapns.entities.Push;
import nd.tesserae.phoneagent.pushapns.service.PushService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    //Executes each 5000 ms chg this to 10 minutes later (600,000)
    @Scheduled(fixedRate = 10000)
    public void doMainLoop() {
        logger.info("MAIN LOOP IS WORKING ");
        List<Push> pushes = new ArrayList<>();
        pushes = pushService.getAllPushesNotSentYet();
        for (Push push : pushes) {
//            logger.info("Pushing ... ");
            pushService.sendPush(push);
            pushService.updatePush(push.getId(),push);
        }
    }
}