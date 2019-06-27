package org.clesun.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by lsw on 2017/5/18.
 */
@SuppressWarnings("serial")
public class BaseEntity implements Serializable, Cloneable {

    @Override
    public Object clone() {
        Object dp = null;
        try {
            dp = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return dp;
    }


    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}