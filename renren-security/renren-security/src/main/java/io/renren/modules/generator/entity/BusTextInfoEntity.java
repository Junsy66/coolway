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
public class BusTextInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String topic;
	//类型 1-公司简介  2-公司动态
	private Integer type;
	//内容
	private String content;
	//创建者
	private String author;
	//描述信息
	private String describe;
	//
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}
	/**
	 * 获取：
	 */
	public String getTopic() {
		return topic;
	}
	/**
	 * 设置：类型 1-公司简介  2-公司动态
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型 1-公司简介  2-公司动态
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：创建者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：创建者
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：描述信息
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	/**
	 * 获取：描述信息
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
