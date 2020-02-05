package cn.wbnull.hellotlj.entity;

import cn.wbnull.hellotlj.model.user.RegisterAppRequestData;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author dukunbiao(null)
 * @since 2020-02-05
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String password;

    public static User build(RegisterAppRequestData appRequestData) {
        User user = new User();
        user.id = UUID.randomUUID().toString();
        user.username = appRequestData.getUsername();
        user.password = appRequestData.getPassword();

        return user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                "}";
    }
}
