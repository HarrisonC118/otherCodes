package hatcher.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Collection;
import java.util.Set;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/28
 * @Description: 写一个shiro可以用的redis缓存
 */
public class TestRedisCache<K,V> implements Cache<K,V> {
    @Autowired
    private RedisTemplate<String, V> redisTemplate;

    @Override
    public V get(K k) throws CacheException {
        V v = redisTemplate.opsForValue().get(k.toString());
        return v;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(k.toString(),v);
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
