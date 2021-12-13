package buddyguide.controller;

import buddyguide.converter.GuideConverter;
import buddyguide.converter.UserConverter;
import buddyguide.model.Guide;
import buddyguide.model.TourCategory;
import buddyguide.model.User;
import buddyguide.model.dto.GuideDto;
import buddyguide.service.IBuddyGuideService;
import buddyguide.service.IReservationService;
import buddyguide.service.impl.GuideService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController("mainController")
public class MainController {
    private static final Logger logger = Logger.getLogger(MainController.class.getName());

    @Autowired
    private GuideService guideService;

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IBuddyGuideService buddyGuideService;

    @Autowired
    private GuideConverter guideConverter;

    @Autowired
    private UserConverter userConverter;

    @GetMapping("/guide/{guideId}/details")
    @ResponseBody
    public ResponseEntity<?> getGuideById(@PathVariable("guideId") String guideIdAsString) {
        try {
            var guideId = Long.parseLong(guideIdAsString);
            var searchedGuide = guideService.getGuideByID(guideId);
            var guideDto = guideConverter.convertModelToDto(searchedGuide);

            System.out.println(searchedGuide.getCategories());

            return new ResponseEntity<>(guideDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/categories")
    @ResponseBody
    public ResponseEntity<?> getAllCategories() {
        try {
            List<String> categoriesList = new ArrayList<>();

            categoriesList.addAll(Arrays.stream(TourCategory.values()).map(Enum::toString).collect(Collectors.toList()));

            return new ResponseEntity<>(categoriesList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{tourCategory}/guides")
    @ResponseBody
    public ResponseEntity<?> getGuidesByCategory(@PathVariable("tourCategory") String tourCategoryAsString) {
        try {
            var tourCategory = TourCategory.valueOf(tourCategoryAsString.toUpperCase());

            List<GuideDto> guides = new ArrayList<>();
            guideService.getGuidesForGivenCategory(tourCategory).forEach(guide -> {
                guides.add(guideConverter.convertModelToDto(guide));
            });

            return new ResponseEntity<>(guides, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{guideId}/notification")
    @ResponseBody
    public ResponseEntity<?> getGuideNotification(@PathVariable("guideId") long guideId) {
        try {
            var reservation = reservationService.getReservationByGuideId(guideId);
            var user = userConverter.convertModelToDto(reservation.getUser());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{guide}/{user}/reservation")
    @ResponseBody
    public ResponseEntity<?> makeReservation(@PathVariable("guide") Guide guide, @PathVariable("user") User user) {
        try {
            buddyGuideService.makeReservation(guide, user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
