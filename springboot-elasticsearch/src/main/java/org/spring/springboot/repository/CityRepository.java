package org.spring.springboot.repository;

import org.spring.springboot.domain.City;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 */
@Repository
public interface CityRepository extends ElasticsearchRepository<City,Long> {


}
