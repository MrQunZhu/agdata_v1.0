package org.clesun.utils;

/**
 * Created by clesun on 2017/5/17.
 */

import org.clesun.entity.Compositor;
import org.clesun.entity.Filtration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: Pagination
 * @Description: 分页对象
 * @author OvO
 *
 */
public class Pagination<T> extends PageInfo{
    /**
     *
     */
    private static final long serialVersionUID = 450730231707544939L;
    private List<T> data;
    private List<Compositor> compositors;
    private List<Filtration> filtrations;
    private List<List<Filtration>>mfiltrations;
    //	private Map<String,Object> map;
    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }

    public List<Compositor> getCompositors() {
        return compositors;
    }
    public void setCompositors(List<Compositor> compositors) {
        this.compositors = compositors;
    }
    /**
     * 添加多字段的排序
     * @param compositor
     */
    public void addCompositor(Compositor compositor) {
        if(null==compositors) {
            compositors = new ArrayList<Compositor>();
        }
        this.compositors.add(compositor);
    }
    public List<Filtration> getFiltrations() {
        return filtrations;
    }
    /**
     * 设置单一条件：“条件1 and 条件2 and 条件n”
     * @param filtrations
     */
    public void setFiltrations(List<Filtration> filtrations) {
        this.filtrations = filtrations;
    }
    public List<List<Filtration>> getMfiltrations() {
        return mfiltrations;
    }
    /**
     * 设置复合条件：“(条件1 and 条件2 and 条件n) or (条件1 and 条件2 and 条件n) or (条件1 and 条件2 and 条件n) or ...”<br>
     * 使用实例：<br>
     * 	@Action中使用
    //( agencysid like ? and addtime > ? ) or( agencysid is null and addtime > ? ) or( agencysid = ? and addtime > ? )<br>
    List<Filtration> filters = new ArrayList<Filtration>();<br>
    List<Filtration> filters2 = new ArrayList<Filtration>();<br>
    List<Filtration> filters3 = new ArrayList<Filtration>();<br>
    if (null != obj.getAgencysid() &&  !"".equals(obj.getAgencysid())){<br>
    filters.add(new Filtration(Filtration.MatchType.LIKE, obj.getAgencysid(), "agencysid"));<br>
    filters2.add(new Filtration(Filtration.MatchType.ISNULL,null, "agencysid"));<br>
    filters3.add(new Filtration(Filtration.MatchType.EQ,"", "agencysid"));<br>
    }else{<br>
    throw new Exception("no agencysid");<br>
    }<br>
    if (null != obj.getAddtime()&&  !"".equals(obj.getAddtime())){<br>
    filters.add(new Filtration(Filtration.MatchType.GT, obj.getAddtime(), "addtime"));<br>
    filters2.add(new Filtration(Filtration.MatchType.GT, obj.getAddtime(), "addtime"));<br>
    filters3.add(new Filtration(Filtration.MatchType.GT, obj.getAddtime(), "addtime"));<br>
    }<br>
    <br>
    List<List<Filtration>>m_filters=new ArrayList<List<Filtration>>();<br>
    m_filters.add(filters);<br>
    m_filters.add(filters2);<br>
    m_filters.add(filters3);<br>
    <br>
    pageinfo.setMfiltrations(m_filters);<br>


     @Service中使用
     if(page.getFiltrations()!=null&&page.getFiltrations().size()>0){<br>
     HMessageExample.Criteria criteria =example.createCriteria();<br>
     for(Filtration filteration:page.getFiltrations()){<br>
     criteria.addCriterion(filteration.getCondition(), filteration.getFieldValue(), filteration.getFieldName());<br>
     }<br>
     }else if(page.getMfiltrations()!=null && page.getMfiltrations().size()>0){<br>
     //( agencysid like ? and addtime > ? ) or( agencysid is null and addtime > ? ) or( agencysid = ? and addtime > ? )<br>
     for(int i=0;i<page.getMfiltrations().size();i++){<br>
     List<Filtration> filters=page.getMfiltrations().get(i);<br>
     if(i==0){<br>
     HMessageExample.Criteria criteria =example.createCriteria();<br>
     for(Filtration filteration:filters){<br>
     criteria.addCriterion(filteration.getCondition(), filteration.getFieldValue(), filteration.getFieldName());<br>
     }<br>
     }else{<br>
     HMessageExample.Criteria criteria2=example.or();<br>
     for(Filtration filteration:filters){<br>
     if(null==filteration.getFieldValue()){<br>
     criteria2.addCriterion(filteration.getCondition());<br>
     }else{<br>
     criteria2.addCriterion(filteration.getCondition(), filteration.getFieldValue(), filteration.getFieldName());<br>
     }<br>
     }<br>
     }<br>
     }<br>
     }<br>

      * @param mfiltrations
     */
    public void setMfiltrations(List<List<Filtration>> mfiltrations) {
        this.mfiltrations = mfiltrations;
    }

}
