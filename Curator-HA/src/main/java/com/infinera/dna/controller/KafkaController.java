/**
 * 
 */
package com.infinera.dna.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PreDestroy;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.retry.RetryForever;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Harshith Gowda B T
 *
 */
@RestController
public class KafkaController {
	private static final Logger logger = LogManager.getLogger(KafkaController.class);


	@Value("${zookeeper.host}")
	private String zookeeperHost;
	
	@LocalServerPort
	private static int serverport;


	public static CuratorFramework cf = null;
	public static int limit = 5;
	public static LeaderLatch leaderLatch = null;
	public static Map<Integer, LeaderLatch> leadermap = new HashMap<>();
	int i = 1;

	@GetMapping("/createlatch")
	private void createlatch() throws Exception {
		System.out.println("AppInitializator initialization logic ...");
		cf = CuratorFrameworkFactory.newClient("10.220.104.59:12181,10.220.104.59:22181,10.220.104.59:32181", new RetryForever(2000));

		cf.start();

		while (i <= limit) {
			logger.info("creating leader latch with id = " + i);
			createlatch(i);
			Thread.sleep(200);
			i++;
		}
	}

	@GetMapping("/removeandRecreateLatch")
	public void removelatch() {
		for (int i = 0; i < limit; i++) {
			int randomInteger = (int) (limit * Math.random());
			if (randomInteger == 0) {
				randomInteger = randomInteger + 1;
			}
			logger.info("removing and re creating leader latch for id = " + randomInteger);
			LeaderLatch leader = leadermap.get(randomInteger);
			try {
				leader.close();
				try {
					Thread.sleep(500);
					try {
						createLatch(randomInteger);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void createLatch(int id) throws Exception {
		createlatch(id);
	}

	/**
	 * @param id
	 * @throws Exception
	 */
	private static void createlatch(int id) throws Exception {
		leaderLatch = new LeaderLatch(cf, "/curator-demo/" + id, serverport+"");
		leaderLatch.addListener(new LeaderLatchListener() {

			@Override
			public void isLeader() {

				logger.info(id + "  is a leader");
			}

			@Override
			public void notLeader() {
				logger.info(id + "  is not a leader");

			}

		});
		leaderLatch.start();
		leadermap.put(id, leaderLatch);

	}

	@PreDestroy
	public void onDestroy() throws Exception {
		System.out.println("Spring Container is destroyed!");
		for (int i = 1; i <= limit; i++) {
			LeaderLatch leader = leadermap.get(i);
			leader.close();
		}
		if (cf != null) {
			cf.close();
		}
	}

}
