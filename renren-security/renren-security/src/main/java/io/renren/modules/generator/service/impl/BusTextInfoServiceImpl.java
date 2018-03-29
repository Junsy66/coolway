package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.generator.dao.BusTextInfoDao;
import io.renren.modules.generator.entity.BusTextInfoEntity;
import io.renren.modules.generator.service.BusTextInfoService;



@Service("busTextInfoService")
public class BusTextInfoServiceImpl implements BusTextInfoService {
	@Autowired
	private BusTextInfoDao busTextInfoDao;
	
	@Override
	public BusTextInfoEntity queryObject(Long id){
		return busTextInfoDao.queryObject(id);
	}
	
	@Override
	public List<BusTextInfoEntity> queryList(Map<String, Object> map){
		return busTextInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return busTextInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(BusTextInfoEntity busTextInfo){
		busTextInfoDao.save(busTextInfo);
	}
	
	@Override
	public void update(BusTextInfoEntity busTextInfo){
		busTextInfoDao.update(busTextInfo);
	}
	
	@Override
	public void delete(Long id){
		busTextInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		busTextInfoDao.deleteBatch(ids);
	}
	
}
