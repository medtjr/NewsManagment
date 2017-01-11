package com.pfe.ahmed.facade.nimda.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.pfe.ahmed.domain.NewsModel;
import com.pfe.ahmed.facade.converters.AbstractConverter;
import com.pfe.ahmed.service.dto.FileDTO;
import com.pfe.ahmed.service.dto.NewsDTO;

@Component
public class NewsConverter extends AbstractConverter<NewsModel, NewsDTO> {

	@Override
	public NewsDTO convert(NewsModel source) {
		return convert(source,new NewsDTO());
	}

	@Override
	public NewsDTO convert(NewsModel source, NewsDTO target) {
		target.setId(source.getId());
		target.setUrgent(isUrgent(source.getIs_urgent()));
		target.setTitre(source.getTitre());
		target.setImage(new FileDTO(source.getImage_path()));
		return target;
	}

	private boolean isUrgent(String is_urgent) {
		if (StringUtils.isEmpty(is_urgent)) {
			return false;
		}
		return "1".equalsIgnoreCase(is_urgent)?true:false;
	}

}
