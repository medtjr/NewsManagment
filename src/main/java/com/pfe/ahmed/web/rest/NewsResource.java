package com.pfe.ahmed.web.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.ahmed.facade.nimda.NewsFacade;
import com.pfe.ahmed.service.dto.NewsDTO;

/**
 * Controller for view and managing Log Level at runtime.
 */
@RestController
public class NewsResource {

	@Inject
	private NewsFacade newsFacade;
	
	@RequestMapping(value="/nimda/news",method = RequestMethod.GET)
    public List<NewsDTO> getNews() {
        return newsFacade.getAllNews();
    }
	
	@RequestMapping(value="/api/nimda/news/addupdate", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public void postNews(@RequestBody NewsDTO newsDTO ) {
		
		newsFacade.postNews(newsDTO);
    }
	
	@RequestMapping(value="/api/nimda/news/delete/{id}", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
    public void deleteNews(@PathVariable("id") Long id) {
		
		newsFacade.deleteNews(id);
    }
}
