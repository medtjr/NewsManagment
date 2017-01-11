package com.pfe.ahmed.facade.nimda;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.pfe.ahmed.domain.NewsModel;
import com.pfe.ahmed.facade.converters.Converter;
import com.pfe.ahmed.service.dto.NewsDTO;
import com.pfe.ahmed.service.nimda.NewsService;

@Component
public class NewsFacade {
	
	@Inject
	private NewsService newsService;
	@Inject
	private Converter<NewsModel, NewsDTO> newsConverter;
	@Inject
	private Converter<NewsDTO,NewsModel> newsReverseConverter;
	
    public List<NewsDTO> getAllNews() {
        List<NewsModel> newsModels = newsService.getAllNews();
        List<NewsDTO> newsDtos = new ArrayList<NewsDTO>();
        for (NewsModel newsModel : newsModels) {
        	newsDtos.add(newsConverter.convert(newsModel));
		}
		return newsDtos;
    }
	
    public void postNews(@RequestBody NewsDTO newsDTO ) {
		
		newsService.createOrUpdateNews(newsReverseConverter.convert(newsDTO));
    }
	
    public void deleteNews(@PathVariable("id") Long id) {
		
		newsService.deleteNews(id);
    }

}
