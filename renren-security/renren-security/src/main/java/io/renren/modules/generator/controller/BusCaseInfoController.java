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
import io.renren.modules.generator.entity.BusCaseInfoEntity;
import io.renren.modules.generator.service.BusCaseInfoService;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-28 21:06:53
 */
@RestController
@RequestMapping("buscaseinfo")
public class BusCaseInfoController {
	@Autowired
	private BusCaseInfoService busCaseInfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@RequiresPermissions("buscaseinfo:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BusCaseInfoEntity> busCaseInfoList = busCaseInfoService.queryList(query);
		int total = busCaseInfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(busCaseInfoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@RequiresPermissions("buscaseinfo:info")
	public R info(@PathVariable("id") Integer id){
		BusCaseInfoEntity busCaseInfo = busCaseInfoService.queryObject(id);
		
		return R.ok().put("busCaseInfo", busCaseInfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("buscaseinfo:save")
	public R save(@RequestBody BusCaseInfoEntity busCaseInfo){
		busCaseInfoService.save(busCaseInfo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("buscaseinfo:update")
	public R update(@RequestBody BusCaseInfoEntity busCaseInfo){
		busCaseInfoService.update(busCaseInfo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("buscaseinfo:delete")
	public R delete(@RequestBody Integer[] ids){
		busCaseInfoService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
