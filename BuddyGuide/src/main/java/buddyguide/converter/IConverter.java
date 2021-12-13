package buddyguide.converter;

import buddyguide.model.BaseEntity;
import buddyguide.model.dto.BaseDto;

public interface IConverter<Model extends BaseEntity<Long>, Dto extends BaseDto> {
    //Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}
