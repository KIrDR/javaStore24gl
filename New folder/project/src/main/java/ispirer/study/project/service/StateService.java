package ispirer.study.project.service;

import ispirer.study.project.repository.StateRepository;
import org.springframework.stereotype.Service;
import ispirer.study.project.model.State;
import java.util.List;

@Service
public class StateService {

    private final StateRepository stateRepository = new StateRepository();


    public List<State> initStates() {
        return stateRepository.initStates();
    }

    public State getState(String code){
        return stateRepository.getState(code);
    }
}
