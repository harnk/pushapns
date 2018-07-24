package nd.tesserae.phoneagent.pushapns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * Created by dscottnull on 7/23/18.
 */

@Controller
public class MainController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //Executes each 5000 ms chg this to 10 minutes later (600,000)
    @Scheduled(fixedRate = 10000)
    public void doMainLoop() {
        logger.info("MAIN LOOP IS WORKING ");

    }
}