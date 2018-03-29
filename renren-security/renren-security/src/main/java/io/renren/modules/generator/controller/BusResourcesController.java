package io.renren.modules.generator.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.BusResourcesEntity;
import io.renren.modules.generator.service.BusResourcesService;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-25 18:18:09
 */
@RestController
@RequestMapping("busresources")
public class BusResourcesController {
	@Autowired
	private BusResourcesService busResourcesService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@RequiresPermissions("busresources:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BusResourcesEntity> busResourcesList = busResourcesService.queryList(query);
		int total = busResourcesService.queryTotal(query);
		PageUtils pageUtil = new PageUtils(busResourcesList, total, query.getLimit(), query.getPage());
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@RequiresPermissions("busresources:info")
	public R info(@PathVariable("id") Long id){
		BusResourcesEntity busResources = busResourcesService.queryObject(id);	
		return R.ok().put("busResources", busResources);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("busresources:save")
	public R save(@RequestBody BusResourcesEntity busResources){
		busResourcesService.save(busResources);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("busresources:update")
	public R update(@RequestBody BusResourcesEntity busResources){
		busResourcesService.update(busResources);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("busresources:delete")
	public R delete(@RequestBody Long[] ids){
		busResourcesService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
