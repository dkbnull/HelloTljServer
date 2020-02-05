package cn.wbnull.hellotlj.entity;

import cn.wbnull.hellotlj.model.user.RegisterAppRequestData;
import cn.wbnull.hellotlj.util.JSONUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author dukunbiao(null)
 * @since 2020-02-05
 */
public class Userinfo extends Model<Userinfo> {

    private static final long serialVersionUID = 1L;

    @TableId("userId")
    private String userId;

    private String nickname;

    private Integer score;

    @TableField("winNum")
    private Integer winNum;

    @TableField("failNum")
    private Integer failNum;

    @TableField("dogfallNum")
    private Integer dogfallNum;

    public static Userinfo build(String userId, RegisterAppRequestData appRequestData) {
        Userinfo userinfo = new Userinfo();
        userinfo.userId = userId;
        userinfo.nickname = appRequestData.getNickname();
        userinfo.score = 10000;
        userinfo.winNum = 0;
        userinfo.failNum = 0;
        userinfo.dogfallNum = 0;

        return userinfo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getWinNum() {
        return winNum;
    }

    public void setWinNum(Integer winNum) {
        this.winNum = winNum;
    }

    public Integer getFailNum() {
        return failNum;
    }

    public void setFailNum(Integer failNum) {
        this.failNum = failNum;
    }

    public Integer getDogfallNum() {
        return dogfallNum;
    }

    public void setDogfallNum(Integer dogfallNum) {
        this.dogfallNum = dogfallNum;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return JSONUtils.javaBeanToJSON(this).toString();
    }
}
