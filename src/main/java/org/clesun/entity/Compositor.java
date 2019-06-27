package org.clesun.entity;

import java.io.Serializable;

/**
 * Created by clesun on 2017/5/17.
 */
public class Compositor implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 4255535498727891117L;
    private String fieldName;
    private CompositorType compositorType;

    public Compositor(String fieldName, CompositorType compositorType) {
        this.fieldName = fieldName;
        this.compositorType = compositorType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public CompositorType getCompositorType() {
        return compositorType;
    }

    public enum CompositorType {
        ASC, // 升序
        DESC// 降序
    }

    public static void main(String[] args) {
        System.out.println(CompositorType.ASC.toString());
    }

}
