package io.renren.modules.generator.service;

import io.renren.modules.generator.entity.BusResourcesEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-25 18:18:09
 */
public interface BusResourcesService {
	
	BusResourcesEntity queryObject(Long id);
	
	List<BusResourcesEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BusResourcesEntity busResources);
	
	void update(BusResourcesEntity busResources);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
