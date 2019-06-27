package org.clesun.utils;

/**
 * Created by clesun on 2017/6/13.
 */
public class PageUtil {
    private static int offset = 0;// 偏移量

    public static int getOffset(int currentPage,int rows){
        return  (currentPage-1)*rows;
    }
}
