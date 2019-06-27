package org.clesun.utils;

/**
 * Created by clesun on 2017/5/17.
 */

import org.clesun.entity.BaseEntity;

/**
 *
 * @ClassName: PageInfo
 * @Description:
 *
 */
public class PageInfo extends BaseEntity {

    // private int totalPageCount;//总页数
    // private int offset;//数据库中从第offset条开始查询的记录指针位置

    private static final long serialVersionUID = -6724975001349471475L;
    private int totalRowCount = 0;// 总记录数
    private int currentPageNum = 1;// 当前页号
    private int rowsOfPage = ConfigUtils.getInt(ConstantCore.Common_PageInfo_PageSize, 20);// 每页记录数
    private int offset = 0;// 偏移量


    /**
     *
     * @Description 获取数据库查询需要的指标位置
     * @return
     * @author OvO
     * @date 2013-3-20
     */
    public int getOffset() {
        if (offset == 0) {
            return (currentPageNum - 1) * rowsOfPage;
        } else {
            return offset;
        }
    }

    /**
     * 以偏移量来获取当前分页数据（如果使用了本方法，setCurrentPageNum则失效）
     * @param offset
     * @author linsf
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @Description 返回总页数
     * @return
     * @author OvO
     * @date 2013-3-20
     */
    public int getTotalPageCount() {
        return (totalRowCount % rowsOfPage == 0) ? (totalRowCount / rowsOfPage) : (totalRowCount / rowsOfPage + 1);
    }

    public int getTotalRowCount() {
        return totalRowCount;
    }

    public void setTotalRowCount(int totalRowCount) {
        if (totalRowCount > -1) {
            this.totalRowCount = totalRowCount;
        }
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        if (currentPageNum > 0) {
            this.currentPageNum = currentPageNum;
        }
    }

    public int getRowsOfPage() {
        return rowsOfPage;
    }

    public void setRowsOfPage(int rowsOfPage) {
        if (rowsOfPage > 0) {
            this.rowsOfPage = rowsOfPage;
        }
    }

    public static void main(String[] args) {
        PageInfo pi = new PageInfo();

        pi.setTotalRowCount(10);
        pi.setCurrentPageNum(1);
        pi.setRowsOfPage(2);

        System.out.println("CurrentPageNum=" + pi.getCurrentPageNum());
        System.out.println("TotalPageCount=" + pi.getTotalPageCount());
        System.out.println("TotalRowCount=" + pi.getTotalRowCount());
        System.out.println("RowsOfPage=" + pi.getRowsOfPage());
        System.out.println("Offset=" + pi.getOffset());
        System.out.println();

    }
}