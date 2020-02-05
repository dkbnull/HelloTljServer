package cn.wbnull.hellotlj.entity;

import cn.wbnull.hellotlj.model.game.GameJoinAppRequestData;
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
public class Gametable extends Model<Gametable> {

    private static final long serialVersionUID = 1L;

    @TableId("tableId")
    private String tableId;

    @TableField("userId")
    private String userId;

    private String status;

    private String owner;

    public static Gametable build(GameJoinAppRequestData appRequestData, String owner) {
        Gametable gametable = new Gametable();
        gametable.tableId = appRequestData.getTableId();
        gametable.userId = appRequestData.getUserId();
        gametable.status = "1";
        gametable.owner = owner;

        return gametable;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
