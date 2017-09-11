package org.spring.springboot.repository;

import org.spring.springboot.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * ES 操作类
 * <p>
 */
public interface CityRepository extends ElasticsearchRepository<City, Long> {

}
