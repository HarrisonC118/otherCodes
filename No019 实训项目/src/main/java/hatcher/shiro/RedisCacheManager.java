package hatcher.shiro;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

/**
 * @author: HatcherCheung
 * @Date: 2021/12/28
 * @Description: 自定义Redis缓存管理器
 */
public class RedisCacheManager implements CacheManager {
    /**
     *
     * @param s 认证或授权缓存的名字
     * @param <K>
     * @param <V>
     * @return redis的缓存管理器
     * @throws CacheException
     */
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return new TestRedisCache<K, V>();
    }
}
