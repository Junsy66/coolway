package io.renren.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-03-28 21:06:53
 */
public class BusCaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String name;
	//主题类型  1-美食 2-运动 3-金融 4-电商 5-视频
	private Integer topicType;
	//图片路径
	private String imageUrl;
	//视频路径
	private String videoUrl;
	//地铁线路
	private String lineNum;
	//
	private Date startTime;
	//
	private Date endTime;
	//
	private String describe;
	//
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：主题类型  1-美食 2-运动 3-金融 4-电商 5-视频
	 */
	public void setTopicType(Integer topicType) {
		this.topicType = topicType;
	}
	/**
	 * 获取：主题类型  1-美食 2-运动 3-金融 4-电商 5-视频
	 */
	public Integer getTopicType() {
		return topicType;
	}
	/**
	 * 设置：图片路径
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	/**
	 * 获取：图片路径
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * 设置：视频路径
	 */
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	/**
	 * 获取：视频路径
	 */
	public String getVideoUrl() {
		return videoUrl;
	}
	/**
	 * 设置：地铁线路
	 */
	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}
	/**
	 * 获取：地铁线路
	 */
	public String getLineNum() {
		return lineNum;
	}
	/**
	 * 设置：
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：
	 */
	public Date getStartTime() {
		return startTime;
	}
	/**
	 * 设置：
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：
	 */
	public Date getEndTime() {
		return endTime;
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
}
