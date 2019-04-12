package com.springmvc.pojo;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private Integer VersionId;

    //小版本号Id
    @Column(name="version_mini")
    private Integer VersionMini;

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
    private Integer CreateTime;

    //更新时间
    @Column(name="update_time")
    private Integer UpdateTime;


    public Integer getId() {
        return id;
    }

    public Integer getAppId() {
        return AppId;
    }

    public Integer getVersionId() {
        return VersionId;
    }

    public Integer getVersionMini() {
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

    public Integer getCreateTime() {
        return CreateTime;
    }

    public Integer getUpdateTime() {
        return UpdateTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAppId(Integer appId) {
        AppId = appId;
    }

    public void setVersionId(Integer versionId) {
        VersionId = versionId;
    }

    public void setVersionMini(Integer versionMini) {
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

    public void setCreateTime(Integer createTime) {
        CreateTime = createTime;
    }

    public void setUpdateTime(Integer updateTime) {
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
