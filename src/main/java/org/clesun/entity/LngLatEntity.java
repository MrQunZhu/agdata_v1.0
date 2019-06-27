package org.clesun.entity;

import java.util.List;

/**
 * Created by clesun on 2018/1/16.
 */
public class LngLatEntity {
    private List<Double> geom;

    public List<Double> getGeom() {
        return geom;
    }

    public void setGeom(List<Double> geom) {
        this.geom = geom;
    }
}
