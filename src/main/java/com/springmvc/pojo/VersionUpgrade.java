package com.springmvc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

//app版本号
@Repository
public class VersionUpgrade {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    //客户端设备 1安卓 2苹果
    @Column(name = "app_id")
    private Integer AppId;

    //大版本号Id
    @Column(name="version_id")
    private String VersionId;

    //小版本号Id
    @Column(name="version_mini")
    private String VersionMini;

    //代码版本标识
    @Column(name="version_code")
    private String VersionCode;

    //是否升级 1升级 0不升级 2强制升级
    private Integer type;

    //apk下载路径
    @Column(name="ApkUrl")
    private String apk_url;

    //升级提示
    @Column(name="upgrade_prompt")
    private String UpgradePrompt;

    //创建时间
    @Column(name="create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date CreateTime;

    //更新时间
    @Column(name="update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date UpdateTime;


    public Integer getId() {
        return id;
    }

    public Integer getAppId() {
        return AppId;
    }

    public String getVersionId() {
        return VersionId;
    }

    public String getVersionMini() {
        return VersionMini;
    }

    public String getVersionCode() {
        return VersionCode;
    }

    public Integer getType() {
        return type;
    }

    public String getApk_url() {
        return apk_url;
    }

    public String getUpgradePrompt() {
        return UpgradePrompt;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAppId(Integer appId) {
        AppId = appId;
    }

    public void setVersionId(String versionId) {
        VersionId = versionId;
    }

    public void setVersionMini(String versionMini) {
        VersionMini = versionMini;
    }

    public void setVersionCode(String versionCode) {
        VersionCode = versionCode;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setApk_url(String apk_url) {
        this.apk_url = apk_url;
    }

    public void setUpgradePrompt(String upgradePrompt) {
        UpgradePrompt = upgradePrompt;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    @Override
    public String toString() {
        return "VersionUpgrade{" +
                "id=" + id +
                ", AppId=" + AppId +
                ", VersionId=" + VersionId +
                ", Version_mini=" + VersionMini +
                ", VersionCode='" + VersionCode + '\'' +
                ", type=" + type +
                ", apk_url='" + apk_url + '\'' +
                ", UpgradePrompt='" + UpgradePrompt + '\'' +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                '}';
    }
}
