package nd.tesserae.phoneagent.pushapns.service;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import nd.tesserae.phoneagent.pushapns.PushRepository;
import nd.tesserae.phoneagent.pushapns.entities.Push;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by dscottnull on 7/24/18.
 */
@Service
public class PushService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    ApnsService service = null;

    @Autowired
    private PushRepository pushRepository;

    public List<Push> getSomePushesNotSentYet(int howMany) {
        List<Push> pushes = new ArrayList<>();
        pushes = pushRepository.findAllByTimeSentIsNull(new PageRequest(0,howMany));
        return pushes;
    }

    public void sendTestPush2(String junkStr){
        // Do APNS push
        ApnsService service = APNS.newService()
                .withCert("pushapns.p12", "pushapns")
                .withAppleDestination(true)
                .build();
        String payload = APNS.newPayload()
                .alertBody(junkStr)
                .alertTitle("sendTestPush 2 Tess").build();

        String token = "36c67b3925efab91dfd996c7ac5edcc2c4e39cb79d85943f246389476e6f3df4"; // my iPhone 6
        logger.info("payload:"+payload);
        service.push(token, payload);
        logger.info("the message was hopefully sent:"+payload);
    }

    public void sendTestPush(String junkStr){
        // Do APNS push
        ApnsService service = APNS.newService()
                .withCert("WhereRU.p12", "whereru")
                .withSandboxDestination()
                .build();
        String payload = APNS.newPayload()
                .alertBody(junkStr)
                .alertTitle("sendTestPush").build();

        String token = "c59acd53f88b8947db1428a7abaedc1d0ddc0b9defd6335f0b61c8569ef1ea42"; // my iPhone 6
        logger.info("payload:"+payload);
        service.push(token, payload);
        logger.info("the message was hopefully sent:"+payload);
    }

    public boolean sendAndUpdatePush(Push push){
        // Do APNS push

        // If Successful, set time_sent
        long now = ZonedDateTime.now().toInstant().toEpochMilli();
//        logger.info("// If Successful, set time sent: "+now);
        push.setTimeSent(now);
        updatePush(push.getId(),push);
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
