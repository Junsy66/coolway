package io.renren.modules.generator.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.Query;
import io.renren.common.utils.R;
import io.renren.modules.generator.constants.Constant;
import io.renren.modules.generator.entity.BusResourcesEntity;
import io.renren.modules.generator.response.BusResourcesRlt;
import io.renren.modules.generator.service.BusResourcesService;



/**
 * 
 * 首页静态资源：视频、图片
 * @author YinShiJun
 * @email 
 * @date 2018-03-25 18:18:09
 */
@RestController
@RequestMapping("coolway/busres")
public class BusResourcesController {
	@Autowired
	private BusResourcesService busResourcesService;
	
	/**
	 * 首页获取资源列表
	 */
	@RequestMapping("/index")
	//@RequiresPermissions("busresources:list")
	public R list(@RequestParam Map<String, Object> params){
		/** 视频列表 **/
		List<BusResourcesRlt> videoList = new ArrayList<BusResourcesRlt>();
		/** 图片品牌列表 **/
		List<BusResourcesRlt> branchList = new ArrayList<BusResourcesRlt>();
		/** 图片合作伙伴列表 **/
		List<BusResourcesRlt> partnerList = new ArrayList<BusResourcesRlt>();
		
		/** 返回数据Map **/
		Map<String,Object> returnMap = new HashMap<String,Object>();
		//查询列表数据
        Query query = new Query(params);
		List<BusResourcesEntity> busResourcesList = busResourcesService.queryList(query);
		for(BusResourcesEntity entity: busResourcesList){
			BusResourcesRlt entityRlt = new BusResourcesRlt();
			BeanUtils.copyProperties(entity, entityRlt);
			// 视频
			if(Constant.HOME_TYPE_VIDEO == entity.getType()){
				videoList.add(entityRlt);
			}
			// 图片
			if(Constant.HOME_TYPE_IMAGE == entity.getType()){
				// 品牌
				if(Constant.IMAGE_KIND_BRAND == entity.getKind()){
					branchList.add(entityRlt);
				}
				// 合作伙伴
				if(Constant.IMAGE_KIND_PARTNER == entity.getKind()){
					partnerList.add(entityRlt);
				}
			}
			
		}
		// Map赋值
		returnMap.put(Constant.VIDEO_KEY, videoList);
		returnMap.put(Constant.IMAGE_BRAND_KEY, branchList);
		returnMap.put(Constant.IMAGE_PARTNER_KEY, partnerList);
		// 返回处理结果
		return R.ok(returnMap);
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
