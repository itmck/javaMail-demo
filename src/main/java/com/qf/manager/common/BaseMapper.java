package com.qf.manager.common;

import java.io.Serializable;

/**
 * Create by it_mck 2018/10/19 9:23
 *
 * @Description:    mapper基类，集成此类后增删改查的方法不用再写
 * @Version: 1.0
 */

/**
 *
 * @param <E> 实体类
 * @param <PK> 主键
 */
public interface BaseMapper<E,PK extends Serializable> {


    /**
     * 根据id获取对象
     * @param id 对象id
     * @return Object  返回对象
     */
    E selectByPrimaryKey(PK id);

    /**
     * 根据id删除对象
     * @param id 对象id
     *
     */
    Integer deleteByPrimaryKey(PK id);

    /**
     * 保存对象所有信息
     * @param entity 对象实体类
     *
     */
    Integer insert(E entity);

    /**
     * 只保存对象不为空信息
     * @param entity 对象实体类
     *
     */
    Integer insertSelective(E entity);

    /**
     * 更新对象信息且只更新不为空的属性
     * @param entity 实体类
     *
     */
    Integer updateByPrimaryKeySelective(E entity);

    /**
     * 更新对象所有属性
     * @param entity
     * @return
     */
    Integer updateByPrimaryKey(E entity);

//	/**
//	* 分页查询--总条数
//	* @return Integer 总条数
//	*/
//	Integer findPageCount(Map<String, String> map);
//
//	/**
//	* 分页查询列表，使用此方法的dto需要继承pageList
//	* @return List<E> 返回数据集合
//	*/
//	List<E> findPage(Map<String, String> map);



}
