package org.clesun.entity;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.clesun.utils.DateUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by clesun on 2017/5/17.
 */
@SuppressWarnings("serial")
public class Filtration implements Serializable {

    public static final String OR = "|OR|";
    public static final String AND = "|AND|";// 因为or使用比较广泛，and功能暂时没有实现

    private String fieldName = null;
    private Object fieldValue = null;
    private MatchType matchType = null;
    private Class<?> fieldType = null;

    public static void main(String[] args) {

        Date d = DateUtils.stringToDate("12/04/2012 12");
        System.out.println(DateUtils.formatDate(d, "yyyy-MM-dd HH:mm:ss"));

    }

    public Filtration(MatchType matchType, String fieldName, Object fieldValue) {
        this.matchType = matchType;
        this.fieldValue = fieldValue;
        this.fieldName = fieldName;
    }

    /**
     *
     filterName = "filter#" + matchType + fieldType + "#" +
     * fieldList.replaceAll(",", Filtration.OR);
     *
     * @param filterName
     *            [MatchType][FiledType]#[fieldName] 例:"LIKES#peopledm"
     * @param filterValue
     *            多个值时“,”分隔
     */
    public Filtration(String filterName, String filterValue) {
        String condition = StringUtils.substringBefore(filterName, "#");
        String matchTypeCode = condition.substring(0, condition.length() - 1);
        String fieldTypeCode = condition.substring(condition.length() - 1, condition.length());
        matchType = Enum.valueOf(MatchType.class, matchTypeCode);
        fieldType = Enum.valueOf(FiledType.class, fieldTypeCode).getValue();
        if (matchType == MatchType.IN || matchType == MatchType.NIN) {
            List list = new ArrayList();
            String[] vtmp = filterValue.split(",");
            for (String vt : vtmp) {
                list.add(ConvertUtils.convert(vt, fieldType));
            }
            fieldValue = list;
        } else {
            if (fieldType.equals(Date.class)) {
                fieldValue = DateUtils.stringToDate(filterValue);
                if (null != fieldValue && filterValue.length() == 10 && matchType == MatchType.LE) {
                    fieldValue = DateUtils.getDateMaxTime((Date) fieldValue);
                }
            } else {
                fieldValue = ConvertUtils.convert(filterValue, fieldType);
            }
        }
        fieldName = StringUtils.substringAfter(filterName, "#");

    }

    /**
     * @param filterName  [MatchType][FiledType]#[fieldName] 例:"LIKES#peopledm"
     * @param filterValue  多个值时“,”分隔
     * @param prefix  分隔号‘#’
     */
    public Filtration(String filterName, String filterValue,String prefix) {
        prefix=StringUtils.isBlank(prefix)?"#":prefix;
        String condition = StringUtils.substringBefore(filterName, prefix);
        String matchTypeCode = condition.substring(0, condition.length() - 1);
        String fieldTypeCode = condition.substring(condition.length() - 1, condition.length());
        matchType = Enum.valueOf(MatchType.class, matchTypeCode);
        fieldType = Enum.valueOf(FiledType.class, fieldTypeCode).getValue();
        if (matchType == MatchType.IN || matchType == MatchType.NIN) {
            List list = new ArrayList();
            String[] vtmp = filterValue.split(",");
            for (String vt : vtmp) {
                list.add(ConvertUtils.convert(vt, fieldType));
            }
            fieldValue = list;
        } else {
            if (fieldType.equals(Date.class)) {
                fieldValue = DateUtils.stringToDate(filterValue);
                if (null != fieldValue && filterValue.length() == 10 && matchType == MatchType.LE) {
                    fieldValue = DateUtils.getDateMaxTime((Date) fieldValue);
                }
            } else {
                fieldValue = ConvertUtils.convert(filterValue, fieldType);
            }
        }
        fieldName = StringUtils.substringAfter(filterName, prefix);
    }

    public String getFieldName() {
        return fieldName;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public Object getFieldValue() {
        if (matchType == MatchType.LIKE) {
            return "%" + fieldValue + "%";
        }
        return fieldValue;
    }

    /**
     * @author OvO
     *
     */
    public enum MatchType {
        /**
         * is null
         */
        ISNULL,
        /**
         * is not null
         */
        ISNotNULL,
        /**
         * =
         */
        EQ, // =
        NEQ, // <>
        /**
         * like
         */
        LIKE, // like
        /**
         * in
         */
        IN, NIN,
        /**
         * <
         */
        LT, // <
        /**
         * <=
         */
        LE, // <=
        /**
         * >
         */
        GT, // >
        /**
         * >=
         */
        GE // >=
    }

    @Override
    public String toString() {
        String flag = "";
        switch (matchType) {
            case ISNULL:
                flag = " is null ";
                break;
            case ISNotNULL:
                flag = " is not null ";
                break;
            case EQ:
                flag = " = ";
                break;
            case NEQ:
                flag = " <> ";
                break;
            case LIKE:
                flag = " like '%";
                break;
            case IN:
                flag = " in ()";
                break;
            case NIN:
                flag = " not in ()";
                break;
            case LT:
                flag = " < ";
                break;
            case LE:
                flag = " <= ";
                break;
            case GT:
                flag = " > ";
                break;
            case GE:
                flag = " >= ";
                break;
            default:
                flag = " = ";
                break;
        }
        if (matchType == MatchType.LIKE) {
            return fieldName + flag + fieldValue + "%'";
        }
        return fieldName + flag + fieldValue;
    }

    public String getCondition() {
        String flag = "";
        switch (matchType) {
            case ISNULL:
                flag = " is null ";
                break;
            case ISNotNULL:
                flag = " is not null ";
                break;
            case EQ:
                flag = " = ";
                break;
            case NEQ:
                flag = " <> ";
                break;
            case LIKE:
                flag = " like ";
                break;
            case IN:
                flag = " in ";
                break;
            case NIN:
                flag = " not in ";
                break;
            case LT:
                flag = " < ";
                break;
            case LE:
                flag = " <= ";
                break;
            case GT:
                flag = " > ";
                break;
            case GE:
                flag = " >= ";
                break;
            default:
                flag = " = ";
                break;
        }
        return fieldName + flag;
    }

    public enum FiledType {
        S(String.class), // 字符串
        I(Integer.class), // 整形
        L(Long.class), // 长整形
        N(Double.class), // 双精度
        D(Date.class), // 时间
        B(Boolean.class);// 布尔

        private Class<?> clazz;

        FiledType(Class<?> clazz) {
            this.clazz = clazz;
        }

        public Class<?> getValue() {
            return clazz;
        }
    }
}

