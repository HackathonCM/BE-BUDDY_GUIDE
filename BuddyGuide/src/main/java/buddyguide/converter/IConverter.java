package buddyguide.converter;

import buddyguide.model.BaseEntity;
import buddyguide.model.dto.BaseDto;

public interface IConverter<Model extends BaseEntity<Long>, Dto extends BaseDto> {

    Dto convertModelToDto(Model model);
}
