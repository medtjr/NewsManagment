package com.pfe.ahmed.repository;

import org.springframework.data.repository.CrudRepository;

import com.pfe.ahmed.domain.NewsModel;

/**
 * Spring Data JPA repository for the News entity.
 */
public interface NewsRepository extends CrudRepository<NewsModel, Long> {



}
