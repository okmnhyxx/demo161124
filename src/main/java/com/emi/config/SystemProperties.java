package com.emi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by emi on 2016/10/27.
 */
@ConfigurationProperties(prefix = "self.test")
public class SystemProperties {

    private String name;

    private String password;

    private List<String> secret;

    public Work work;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = StringUtils.isEmpty(this.name) ? name : this.name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = StringUtils.isEmpty(this.password) ? password : this.password;
    }

    public List<String> getSecret() {
        return secret;
    }

    public void setSecret(List<String> secret) {
        this.secret = null == this.secret ? secret : this.secret;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = null == this.work ? work : this.work;
    }



     public static class Work {

        @NestedConfigurationProperty
        private Integer year;

        @NestedConfigurationProperty
        private String career;

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = null == this.year ? year : this.year;
        }

        public String getCareer() {
            return career;
        }

        public void setCareer(String career) {
            this.career = StringUtils.isEmpty(this.career) ? career : this.career;
        }
    }

}
