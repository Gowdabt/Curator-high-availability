/**
 * 
 */
package com.infinera.dna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infinera.dna.models.Alert;

/**
 * @author Harshith Gowda B T
 *
 */
@Repository
public interface KafkaElasticRepository extends JpaRepository<Alert, Integer> {
	
}
