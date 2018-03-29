package io.renren.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-25 18:18:09
 */
public class BusResourcesEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键id
	private Long id;
	//资源名称
	private String name;
	//图片种类： 1-图片 2-视屏
	private Integer type;
	//资源分类 1-Banner 2-
	private Integer kind;
	//
	private String imageUrl;
	//
	private String videoUrl;
	//
	private String describe;
	//
	private Date createTime;
	//
	private Date updateTime;

	/**
	 * 设置：主键id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：资源名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：资源名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：图片种类： 1-图片 2-视屏
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：图片种类： 1-图片 2-视屏
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：资源分类 1-Banner 2-
	 */
	public void setKind(Integer kind) {
		this.kind = kind;
	}
	/**
	 * 获取：资源分类 1-Banner 2-
	 */
	public Integer getKind() {
		return kind;
	}
	/**
	 * 设置：
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	/**
	 * 获取：
	 */
	public String getVideoUrl() {
		return videoUrl;
	}
	/**
	 * 设置：
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	/**
	 * 获取：
	 */
	public String getDescribe() {
		return describe;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
