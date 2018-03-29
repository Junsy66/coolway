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

import com.sun.media.jfxmedia.logging.Logger;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.generator.entity.BusTextInfoEntity;
import io.renren.modules.generator.service.BusTextInfoService;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-28 21:06:53
 */
@RestController
@RequestMapping("bustextinfo")
public class BusTextInfoController {
	@Autowired
	private BusTextInfoService busTextInfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@RequiresPermissions("bustextinfo:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        

		List<BusTextInfoEntity> busTextInfoList = busTextInfoService.queryList(query);
		int total = busTextInfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(busTextInfoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@RequiresPermissions("bustextinfo:info")
	public R info(@PathVariable("id") Long id){
		BusTextInfoEntity busTextInfo = busTextInfoService.queryObject(id);
		
		return R.ok().put("busTextInfo", busTextInfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("bustextinfo:save")
	public R save(@RequestBody BusTextInfoEntity busTextInfo){
		busTextInfoService.save(busTextInfo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("bustextinfo:update")
	public R update(@RequestBody BusTextInfoEntity busTextInfo){
		busTextInfoService.update(busTextInfo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("bustextinfo:delete")
	public R delete(@RequestBody Long[] ids){
		busTextInfoService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
