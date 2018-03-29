package io.renren.modules.generator.service;

import io.renren.modules.generator.entity.BusCaseInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-28 21:06:53
 */
public interface BusCaseInfoService {
	
	BusCaseInfoEntity queryObject(Integer id);
	
	List<BusCaseInfoEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(BusCaseInfoEntity busCaseInfo);
	
	void update(BusCaseInfoEntity busCaseInfo);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
