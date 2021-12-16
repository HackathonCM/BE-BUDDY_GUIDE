package buddyguide.controller;

import buddyguide.converter.GuideConverter;
import buddyguide.converter.UserConverter;
import buddyguide.model.TourCategory;
import buddyguide.model.dto.GuideDto;
import buddyguide.service.IBuddyGuideService;
import buddyguide.service.IGuideService;
import buddyguide.service.IReservationService;
import buddyguide.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController("mainController")
public class MainController {

    @Autowired
    private IGuideService guideService;

    @Autowired
    private IUserService userService;

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
    public ResponseEntity<?> getGuideById(@PathVariable("guideId") long guideId) {
        try {
            var searchedGuide = guideService.getGuideByID(guideId);
            var guideDto = guideConverter.convertModelToDto(searchedGuide);

            return new ResponseEntity<>(guideDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
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

    @GetMapping("/user/{userId}/details")
    @ResponseBody
    public ResponseEntity<?> getUserById(@PathVariable("userId") long userId) {
        try {
            var searchedUser = userService.getUserByID(userId);
            var userDto = userConverter.convertModelToDto(searchedUser);

            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{guideId}/notification")
    @ResponseBody
    public ResponseEntity<?> getGuideNotification(@PathVariable("guideId") long guideId) {
        try {
            var reservation = reservationService.getReservationByGuideId(guideId);
            System.out.println(reservation);
            var user = userConverter.convertModelToDto(reservation.getUser());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{guideId}/{userId}/reservation")
    @ResponseBody
    public ResponseEntity<?> makeReservation(@PathVariable("guideId") long guideId, @PathVariable("userId") long userId) {
        try {
            buddyGuideService.makeReservation(guideId, userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
