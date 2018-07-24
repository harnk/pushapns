package nd.tesserae.phoneagent.pushapns;

import nd.tesserae.phoneagent.pushapns.entities.Push;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by dscottnull on 7/24/18.
 */
public interface PushRepository extends CrudRepository<Push, String> {
//    List<Push> findPushesByDeviceToken();
}
