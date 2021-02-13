package br.com.springtx.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author felipeleonhardt
 * Spring transactions examples
 */
public class CreateRequest {

    @JsonProperty
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
