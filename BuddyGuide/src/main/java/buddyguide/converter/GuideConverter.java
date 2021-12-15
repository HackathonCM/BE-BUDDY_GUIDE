package buddyguide.converter;

import buddyguide.model.Guide;
import buddyguide.model.dto.GuideDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("guideConverter")
public class GuideConverter implements IConverter<Guide, GuideDto> {

    @Override
    public GuideDto convertModelToDto(Guide guide) {
        var guideDto = new GuideDto();

        guideDto.setId(guide.getId());
        guideDto.setFirstName(guide.getFirstName());
        guideDto.setLastName(guide.getLastName());
        guideDto.setTelephone(guide.getTelephone());
        guideDto.setEmail(guide.getEmail());
        guideDto.setType(guideDto.getType());
        guideDto.setAvailable(guide.isAvailable());
        guideDto.setPrice(guide.getPrice());

        List<String> categoriesList;
        categoriesList = guide.getCategories().stream()
                .map(elem -> elem.toString())
                .collect(Collectors.toList());
        guideDto.setCategories(categoriesList);

        return guideDto;
    }
}
