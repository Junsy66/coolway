package io.renren.modules.generator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.modules.generator.dao.BusCaseInfoDao;
import io.renren.modules.generator.entity.BusCaseInfoEntity;
import io.renren.modules.generator.service.BusCaseInfoService;



@Service("busCaseInfoService")
public class BusCaseInfoServiceImpl implements BusCaseInfoService {
	@Autowired
	private BusCaseInfoDao busCaseInfoDao;
	
	@Override
	public BusCaseInfoEntity queryObject(Integer id){
		return busCaseInfoDao.queryObject(id);
	}
	
	@Override
	public List<BusCaseInfoEntity> queryList(Map<String, Object> map){
		return busCaseInfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return busCaseInfoDao.queryTotal(map);
	}
	
	@Override
	public void save(BusCaseInfoEntity busCaseInfo){
		busCaseInfoDao.save(busCaseInfo);
	}
	
	@Override
	public void update(BusCaseInfoEntity busCaseInfo){
		busCaseInfoDao.update(busCaseInfo);
	}
	
	@Override
	public void delete(Integer id){
		busCaseInfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		busCaseInfoDao.deleteBatch(ids);
	}
	
}
