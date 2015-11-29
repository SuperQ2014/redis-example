package skyler.tao.redis_example;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis example
 *
 */
public class ConnectExample {

	private static JedisPool pool;

	public static void main(String[] args) {
		
		String ip = "221.179.193.178";
		int port = 8833;
		int timeout = 1000;
		String passwd = "30140906tao";
		 pool = new JedisPool(new JedisPoolConfig(), ip, port, timeout, passwd);
		try (Jedis jedis = pool.getResource()) {
			jedis.set("foo", "bar");
			String foobar = jedis.get("foo");
			System.out.println(foobar);
			
			String myMember1 = "skyler.tao";
			double myMember1Score1 = 1.0;
			String SortedSet1 = "mySortedSet1";
			jedis.zadd("mySortedSet1", myMember1Score1, myMember1);
			Set<String> mySortedSet1 = jedis.zrange(SortedSet1, 0, -1);
			System.out.println(mySortedSet1);
		}
		
		pool.destroy();
	}
}
