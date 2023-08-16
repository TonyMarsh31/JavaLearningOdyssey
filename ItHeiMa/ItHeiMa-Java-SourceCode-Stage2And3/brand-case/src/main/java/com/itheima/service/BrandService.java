package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     *
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据id进行批量删除
     *
     * @param ids 传递的多个id
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     *
     * @param currentPage 当前页
     * @param pageSize    每页显示的条数
     * @return 一个PageBean对象，里面包含了currentPage中应当显示的数据，同时包含一个totalCount属性，表示总条数
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);


    /**
     * 分页条件查询
     *
     * @param currentPage 当前页
     * @param pageSize    每页显示的条数
     * @param brand       查询条件
     * @return 一个PageBean对象，里面包含了currentPage中应当显示的数据，同时包含一个totalCount属性，表示总条数
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);


}
