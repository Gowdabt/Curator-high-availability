/**
 * 
 */
package com.infinera.dna.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.infinera.dna.model.PerformanceResource;

/**
 * @author Harshith Gowda B T
 *
 */
@Repository
public interface PerformanceMgmtRepository extends ElasticsearchRepository<PerformanceResource, String> {

}
