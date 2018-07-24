package nd.tesserae.phoneagent.pushapns;

import nd.tesserae.phoneagent.pushapns.entities.Push;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dscottnull on 7/24/18.
 */
public interface PushRepository extends CrudRepository<Push, String> {
    List<Push> findAllByTimeSentIsNull();
}
