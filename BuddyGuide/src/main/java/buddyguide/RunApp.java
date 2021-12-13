package buddyguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunApp {

    public static void main(String[] args) {
        SpringApplication.run(RunApp.class, args);

        //ApplicationContext applicationContext = SpringApplication.run(RunApp.class, args);



        /*BuddyGuideService buddyGuideService = applicationContext.getBean(BuddyGuideService.class);

        //TourService tourService = applicationContext.getBean(TourService.class);
        //tourService.getToursByCategory(TourCategory.ISTORIC).forEach(System.out::println);
        try {
            buddyGuideService.login("user", "root");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/
    }
}
