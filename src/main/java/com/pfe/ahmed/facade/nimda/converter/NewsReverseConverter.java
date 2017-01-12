package com.pfe.ahmed.facade.nimda.converter;

import java.io.IOException;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pfe.ahmed.domain.NewsModel;
import com.pfe.ahmed.facade.converters.AbstractConverter;
import com.pfe.ahmed.facade.utils.ImageBase64Transformer;
import com.pfe.ahmed.service.dto.FileDTO;
import com.pfe.ahmed.service.dto.NewsDTO;

@Component
public class NewsReverseConverter extends AbstractConverter<NewsDTO, NewsModel> {

	@Inject
	private ImageBase64Transformer imageBase64Transformer;
	
	private static final Logger LOG = LoggerFactory.getLogger(NewsReverseConverter.class);
	
	@Override
	public NewsModel convert(NewsDTO source) {
		return convert(source,new NewsModel());
	}

	@Override
	public NewsModel convert(NewsDTO source, NewsModel target) {
		target.setId(source.getId());
		target.setIs_urgent(source.isUrgent()?"1":"0");
		target.setTitre(source.getTitre());
		FileDTO image = source.getImage();
		if (image!=null && StringUtils.isNotEmpty(image.getBase64()) ) {
			try {
				target.setImage_path(imageBase64Transformer.transform2File(image.getBase64(),image.getFilename()));
			} catch (IOException e) {
				LOG.error(e.getMessage(),e);
			}
		}
		return target;
	}


}
