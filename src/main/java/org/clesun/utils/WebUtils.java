package org.clesun.utils;

import org.apache.commons.lang.StringUtils;
import org.clesun.entity.Compositor;
import org.clesun.entity.Compositor.CompositorType;
import org.clesun.entity.Filtration;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by clesun on 2017/5/17.
 */
public class WebUtils {
    public static Map<String, Object> getParametersStartingWith(HttpServletRequest request, String prefix) {
        Enumeration<String> paramNames = request.getParameterNames();
        Map<String, Object> params = new TreeMap<String, Object>();
        if (prefix == null) {
            prefix = "";
        }
        while (paramNames != null && paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            if ("".equals(prefix) || paramName.startsWith(prefix)) {
                String unprefixed = paramName.substring(prefix.length());
                String[] values = request.getParameterValues(paramName);
                if (values == null || values.length == 0) {

                } else if (values.length > 1) {
                    params.put(unprefixed, values);
                } else {
                    params.put(unprefixed, values[0]);
                }
            }
        }
        return params;
    }

    public static List<Filtration> creatFiltrationList(HttpServletRequest request, String filterPrefix) {
        List<Filtration> filtrationList = new ArrayList<Filtration>();
        filterPrefix= StringUtils.isBlank(filterPrefix)?"_":filterPrefix;
        Map<String, Object> filterParamMap = getParametersStartingWith(request,"filter"+filterPrefix);
        for (Map.Entry<String, Object> entry : filterParamMap.entrySet()) {
            String filterName = entry.getKey();
            String value = "";
            if (entry.getValue() instanceof String) {
                value = StringEncode.iso2utf((String) entry.getValue());
            } else if (entry.getValue() instanceof String[]) {
                String[] vs = (String[]) entry.getValue();
                value = StringUtils.join(vs, ',');
                filterName = filterName.replace("[]", "");
            }
            if (StringUtils.isNotBlank(value)) {
                Filtration filter = new Filtration(filterName, value, filterPrefix);
                filtrationList.add(filter);
            }

        }
        return filtrationList;
    }

    /**
     * request get方式参数：
     * currentPageNum=1<br>
     rowsOfPage=10<br>
     filter_GEL_start=1459987200000<br>
     filter_LEL_end=1460505600000<br>
     filter_EQI_alarmtype=4<br>
     filter_INS_ipcsids[]=44030300001320002303<br>
     filter_INS_ipcsids[]=44030300001320002321<br>
     filter_INS_ipcsids[]=44030300001320002315<br>
     filter_INS_ipcsids[]=44030300001320002314<br>
     filter_INS_ipcsids[]=44030300001320002305<br>
     filter_INS_ipcsids[]=44030300001320002304<br>


     * @param request
     * @param pageData
     * @param paramprefix filter过滤参数的数据分隔符，默认为“_”
     * @author linsf
     */
    public static void setPageDataParameter(HttpServletRequest request, Pagination<?> pageData, String paramprefix) {
        List<Filtration> filtrationList = creatFiltrationList(request, paramprefix);
        pageData.setFiltrations(filtrationList);
        String fieldName = request.getParameter("fieldName");
        String compositorType = request.getParameter("compositorType");
        if (StringUtils.isNotBlank(fieldName) && StringUtils.isNotBlank(compositorType)) {
            Compositor compositor = new Compositor(fieldName, Enum.valueOf(CompositorType.class, compositorType.toUpperCase()));
            pageData.addCompositor(compositor);
        }
        String pageNoStr = request.getParameter("pageNo");

        if (StringUtils.isNotBlank(pageNoStr)) {
            pageNoStr = request.getParameter("currentPageNum");
        }

        if (StringUtils.isNotBlank(pageNoStr)) {
            Integer pageNo = Integer.parseInt(pageNoStr);
            pageData.setCurrentPageNum(pageNo);
        }
    }

    public static void setPageDataParameter(HttpServletRequest request, Pagination<?> pageData) {
        setPageDataParameter(request, pageData, "#");
    }
}
