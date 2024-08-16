package ispirer.study.project.controller.ServerController;

import ispirer.study.project.ProjectApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

    @PutMapping("/shutdown")
    public void shutdown() {
        try {
            ProjectApplication.shutDown();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        }
}
