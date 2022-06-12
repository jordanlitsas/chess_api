package com.spendingTracker.user;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
public class CustomUserController {

    private final CustomUserRepository repository;

    CustomUserController(CustomUserRepository repository) {
        this.repository = repository;
    }
    private static final Logger log = LoggerFactory.getLogger(CustomUserController.class);

    @GetMapping("/user")
    List<CustomUser> all() {
        return repository.findAll();
    }

    @GetMapping("/user/{uId}")
    @CrossOrigin("https://expense-tracker-mobile.herokuapp.com/")
    CustomUser byUid(@PathVariable String uId) {
        List<CustomUser> users = repository.findAll();
        CustomUser user = new CustomUser();
        for (int i = 0; i < users.size(); i++){
            log.info(users.get(i).toString());
            if (users.get(i).getUId().equals(uId)){
                System.out.println(users.get(i).toString());
                return users.get(i);
            }
        }
        return user;
    }


    @PostMapping(path = "/user", consumes = "application/json")
    @CrossOrigin("https://expense-tracker-mobile.herokuapp.com/")
        CustomUser newUser(@RequestBody CustomUser newCustomUser) {
            log.info(newCustomUser.toString());
            return repository.save(newCustomUser);
        }

}
