package nd.tesserae.phoneagent.pushapns.service;

import nd.tesserae.phoneagent.pushapns.PushRepository;
import nd.tesserae.phoneagent.pushapns.entities.Push;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by dscottnull on 7/24/18.
 */
@Service
public class PushService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PushRepository pushRepository;

    public List<Push> getAllPushesNotSentYet() {
        List<Push> pushes = new ArrayList<>();
        pushes = pushRepository.findAllByTimeSentIsNull();
        return pushes;
    }

    public boolean sendPush(Push push){
        // Do APNS push
        logger.info("// Do APNS push - TBD");

        // If Successful, set time_sent
        long now = ZonedDateTime.now().toInstant().toEpochMilli();
        logger.info("// If Successful, set time sent: "+now);
        push.setTimeSent(now);
        logger.info("// Do I also need to do a save here - TBD");
        return true;
    }

    public Push getPush(String id) {
        return pushRepository.findOne(id);
    }

    public void addPush(Push push){
        pushRepository.save(push);
    }

    public void updatePush(Long id, Push push) {
        pushRepository.save(push);
    }

    public void deletePush(String id) {
        pushRepository.delete(id);
    }


}
