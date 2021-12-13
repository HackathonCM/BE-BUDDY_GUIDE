package buddyguide.converter;

import buddyguide.model.Guide;
import buddyguide.model.dto.GuideDto;
import org.springframework.stereotype.Component;

@Component("guideConverter")
public class GuideConverter implements IConverter<Guide, GuideDto> {

    /*@Override
    public Guide convertDtoToModel(GuideDto dto) {
        return null;
    }*/

    @Override
    public GuideDto convertModelToDto(Guide guide) {
        var guideDto = new GuideDto();

        guideDto.setId(guide.getId());
        guideDto.setFirstName(guide.getFirstName());
        guideDto.setLastName(guide.getLastName());
        guideDto.setTelephone(guide.getTelephone());
        guideDto.setEmail(guide.getEmail());
        guideDto.setAvailable(guide.isAvailable());

        return guideDto;
    }

}
