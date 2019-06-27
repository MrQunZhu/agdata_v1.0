package org.clesun.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clesun on 2016/10/25.
 */
public class ResData<T> {
    @JsonProperty("CODE")
    private int CODE;
    @JsonProperty("MSG")
    private String MSG;
    @JsonProperty("TIMESTAMP")
    private Long TIMESTAMP;
    @JsonProperty("DATA")
    private List<T> DATA;
    @JsonProperty("TOTALSIZE")
    private int TOTALSIZE;

    @JsonIgnore
    public ResData(int CODE, String MSG, List<T> DATA) {
        this.CODE = CODE;
        this.MSG = MSG;
        this.TIMESTAMP = System.currentTimeMillis()/1000L;
        this.DATA = DATA;
    }
    @JsonIgnore
    public ResData(int CODE, String MSG) {
        this.CODE = CODE;
        this.MSG = MSG;
        this.TIMESTAMP = System.currentTimeMillis()/1000L;
        this.DATA = new ArrayList<T>();
    }
    @JsonIgnore
    public ResData(int CODE, String MSG, Long TIMESTAMP, List<T> DATA) {
        this.CODE = CODE;
        this.MSG = MSG;
        this.TIMESTAMP = TIMESTAMP;
        this.DATA = DATA;
    }
    @JsonIgnore
    public ResData(int CODE, String MSG,List<T> DATA, int TOTALSIZE) {
        this.CODE = CODE;
        this.MSG = MSG;
        this.TIMESTAMP = System.currentTimeMillis()/1000L;
        this.DATA = DATA;
        this.TOTALSIZE = TOTALSIZE;
    }



    @JsonIgnore
    public Long getTIMESTAMP() {
        return TIMESTAMP;
    }
    @JsonIgnore
    public void setTIMESTAMP(Long TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    @JsonIgnore
    public int getCODE() {
        return CODE;
    }
    @JsonIgnore
    public void setCODE(int CODE) {
        this.CODE = CODE;
    }
    @JsonIgnore
    public String getMSG() {
        return MSG;
    }
    @JsonIgnore
    public void setMSG(String MSG) {
        this.MSG = MSG;
    }
    @JsonIgnore
    public List<T> getDATA() {
        return DATA;
    }
    @JsonIgnore
    public void setDATA(List<T> DATA) {
        this.DATA = DATA;
    }

    public int getTOTALSIZE() {
        return TOTALSIZE;
    }

    public void setTOTALSIZE(int TOTALSIZE) {
        this.TOTALSIZE = TOTALSIZE;
    }
}
