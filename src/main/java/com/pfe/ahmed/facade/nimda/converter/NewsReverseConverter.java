package com.pfe.ahmed.facade.nimda.converter;

import org.springframework.stereotype.Component;

import com.pfe.ahmed.domain.NewsModel;
import com.pfe.ahmed.facade.converters.AbstractConverter;
import com.pfe.ahmed.service.dto.NewsDTO;

@Component
public class NewsReverseConverter extends AbstractConverter<NewsDTO, NewsModel> {

	@Override
	public NewsModel convert(NewsDTO source) {
		return convert(source,new NewsModel());
	}

	@Override
	public NewsModel convert(NewsDTO source, NewsModel target) {
		target.setId(source.getId());
		target.setIs_urgent(source.isUrgent()?"1":"0");
		target.setTitre(source.getTitre());
		target.setImage_path(source.getImage().getFilepath());
		return target;
	}


}
