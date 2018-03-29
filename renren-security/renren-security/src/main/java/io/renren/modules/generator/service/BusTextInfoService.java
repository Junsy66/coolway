package io.renren.modules.generator.service;

import io.renren.modules.generator.entity.BusTextInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-28 21:06:53
 */
public interface BusTextInfoService {
	
	BusTextInfoEntity queryObject(Long id);
	
	List<BusTextInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BusTextInfoEntity busTextInfo);
	
	void update(BusTextInfoEntity busTextInfo);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
