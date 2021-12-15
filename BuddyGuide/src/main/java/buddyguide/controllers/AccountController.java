package buddyguide.controllers;


import buddyguide.model.BaseEntity;
import buddyguide.model.Guide;
import buddyguide.model.User;
import buddyguide.model.dto.AccountDTO;
import buddyguide.service.impl.AccountService;
import buddyguide.service.impl.BuddyGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping(value = "/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    private BuddyGuideService buddyGuideService;

    @PostMapping()
    public ResponseEntity<String> checkUsernameAndPassword(@RequestBody AccountDTO accountDTO) {
        try {
            ResponseEntity response;
            BaseEntity<Long> entity = buddyGuideService.login(accountDTO.getUsername(), accountDTO.getPassword());
            if (entity instanceof User) {
                User user = (User) entity;
                user.setType("USER");
                response = new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                Guide guide = (Guide) entity;
                guide.setType("GUIDE");
                response = new ResponseEntity<>(guide, HttpStatus.OK);
            }

            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
