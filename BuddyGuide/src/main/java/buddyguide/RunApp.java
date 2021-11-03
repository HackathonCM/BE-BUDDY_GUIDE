package buddyguide;

import buddyguide.repository.IAccountRepository;
import buddyguide.service.impl.AccountService;
import buddyguide.service.impl.BuddyGuideService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RunApp {
    public static void main(String[] args) {
        //SpringApplication.run(RunApp.class, args);

        ApplicationContext applicationContext = SpringApplication.run(RunApp.class, args);

        BuddyGuideService buddyGuideService = applicationContext.getBean(BuddyGuideService.class);


        try {
            buddyGuideService.login("test", "test");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
