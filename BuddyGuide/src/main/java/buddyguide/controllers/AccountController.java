package buddyguide.controllers;


import buddyguide.model.dtos.AccountDTO;
import buddyguide.service.impl.AccountService;
import buddyguide.service.impl.BuddyGuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    @Autowired
    private BuddyGuideService buddyGuideService;

    @PostMapping()
    public ResponseEntity<String> checkUsernameAndPassword(@RequestBody AccountDTO accountDTO)
    {
        try {
            buddyGuideService.login(accountDTO.getUsername(),accountDTO.getPassword());
            return new ResponseEntity<> (accountDTO.getUsername(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
