/**
 * 
 */
package com.infinera.dna.ha;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.infinera.dna.ha.model.MessageDetails;

/**
 * @author Harshith Gowda B T
 *
 */
@Repository
public interface MessageRepository extends ElasticsearchRepository<MessageDetails, String> {

}
