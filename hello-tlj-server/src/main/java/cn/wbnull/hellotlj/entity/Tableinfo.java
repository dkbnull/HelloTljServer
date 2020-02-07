package cn.wbnull.hellotlj.entity;

import cn.wbnull.hellotlj.util.JSONUtils;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author dukunbiao(null)
 * @since 2020-02-07
 */
public class Tableinfo extends Model<Tableinfo> {

    private static final long serialVersionUID = 1L;

    @TableId("tableId")
    private String tableId;

    @TableField("userId")
    private String userId;

    private String poker;

    private String status;

    private Integer score;

    public static Tableinfo build(Gametable gametable, List<String> pokers) {
        Tableinfo tableinfo = new Tableinfo();
        tableinfo.tableId = gametable.getTableId();
        tableinfo.userId = gametable.getUserId();
        tableinfo.poker = pokers.toString();
        tableinfo.status = "1";
        tableinfo.score = 0;

        return tableinfo;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPoker() {
        return poker;
    }

    public void setPoker(String poker) {
        this.poker = poker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    protected Serializable pkVal() {
        return this.tableId;
    }

    @Override
    public String toString() {
        return JSONUtils.javaBeanToJSON(this).toString();
    }
}
