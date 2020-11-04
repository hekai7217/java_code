package com.jutixueyuan.utils;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-11-03 10:40
 * @desc 百战程序员 http://www.jutixueyuan.com
 *   分页属性封装的工具
 */
public class PageUtils {

    // 分页的必须数据

    //当前的页面
    private Integer currentPage;

    // 页面的大小
    private Integer pageSize;

    // 数据的总数
    private Integer totalCount;

    // 存放数据拿到集合
    private List data;

    // 封装 前端页面的导航条

    // 导航条的个数
    private Integer navCount;

    // 第一页 最后一页
    private Integer firstPage;
    private Integer lastPage;

    // 导航条 开始和结尾
    private Integer startNav;
    private Integer endNav;

    // 封装 上一页 和下一页
    private Integer prePage;
    private Integer nextPage;


    // 查询开始的位置
    private Integer index;


    /**
     *  pageUtils 的数据的初始化
     *
     *    初始化时候:    必须的数据
     *        currentPage, pageSize , totalCount , navCount
     *    不是必须的数据: 可以不用初始化,如果需要初始化 可以进行计算出来
     *
     * @param currentPage
     * @param pageSize
     * @param totalCount
     * @param navCount
     */
    public PageUtils(Integer currentPage, Integer pageSize, Integer totalCount,Integer navCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.navCount = navCount;

        // 初始化其他的数据

        //第一页
        this.firstPage = 1;
        // 最后一页    totalCount / pageSize
        if (totalCount%pageSize ==0){  // 整除
            this.lastPage = totalCount/pageSize;
        }else{
            this.lastPage = totalCount/pageSize + 1;
        }

        //上一页
        // 不用判断 第一页 和最后一页 (通过前端 页面来判断 )
        this.prePage = this.currentPage -1;
        this.nextPage = this.currentPage +1;

        // 导航条 开始和结尾
        // 导航条开始和结束的位置要分情况讨论
       if(lastPage >= navCount){  // 分页的总数大于 导航条的个数
//           情况1:  分页的1-6页, 导航条开始和结束位置不会变化
           if(currentPage <= 6){
               this.startNav = 1;
               this.endNav = navCount;
           }
           // 情况2  72 - 76 导航条开始和结束位置是不变的
           else if(currentPage >= lastPage -navCount/2 +1 && currentPage <= lastPage){
               // 67
               this.startNav = lastPage -navCount + 1 ;
               // 76
               this.endNav = lastPage;
           }
           // 情况3  左边 有5个 右边有4个
           else{
               this.startNav = currentPage  - navCount/2;
               // 76
               this.endNav = currentPage + navCount/2 -1;
           }
       }else{  // 分页的总数小于导航条的个数
           this.startNav = 1;
           this.endNav = lastPage;
       }

       // index 的 初始化
        this.index = (currentPage - 1 )* pageSize;
    }

    public PageUtils() {
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Integer getNavCount() {
        return navCount;
    }

    public void setNavCount(Integer navCount) {
        this.navCount = navCount;
    }

    public Integer getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Integer firstPage) {
        this.firstPage = firstPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getStartNav() {
        return startNav;
    }

    public void setStartNav(Integer startNav) {
        this.startNav = startNav;
    }

    public Integer getEndNav() {
        return endNav;
    }

    public void setEndNav(Integer endNav) {
        this.endNav = endNav;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", data=" + data +
                ", navCount=" + navCount +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", startNav=" + startNav +
                ", endNav=" + endNav +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", index=" + index +
                '}';
    }
}
