/**
 * 
 */
package com.infinera.dna.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.infinera.dna.models.PerformanceResource;

/**
 * @author Harshith Gowda B T
 *
 */
@Repository
public interface PerformanceMgmtRepository extends ElasticsearchRepository<PerformanceResource, String> {

}
