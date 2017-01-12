package com.pfe.ahmed.service.nimda;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.pfe.ahmed.domain.NewsModel;
import com.pfe.ahmed.repository.NewsRepository;

@Component
@Transactional
public class NewsService {

	@Inject
	private NewsRepository newsRepository;
	
	public List<NewsModel> getAllNews(){
		
		return (List<NewsModel>) newsRepository.findAll();
	}
	
	public void createOrUpdateNews(NewsModel newsModel){
		
		 newsRepository.save(newsModel);
	}
	
	public void deleteNews(Integer newsID){
		
		 newsRepository.delete(newsID);
	}
}
