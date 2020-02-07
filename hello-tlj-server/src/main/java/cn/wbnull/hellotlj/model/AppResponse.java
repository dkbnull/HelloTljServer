package cn.wbnull.hellotlj.model;

import cn.wbnull.hellotlj.constant.ResponseCode;
import cn.wbnull.hellotlj.util.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * 后台响应信息
 *
 * @author dukunbiao(null)  2020-02-05
 * https://github.com/dkbnull/HelloTljServer
 */
@Data
public class AppResponse {

    private String code;
    private String message;
    private JSON data;

    public static JSONObject success() {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.SUCCESS.code();
        aipResponse.message = "SUCCESS";

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject success(String message) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.SUCCESS.code();
        aipResponse.message = message;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject success(JSON data) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.SUCCESS.code();
        aipResponse.message = "SUCCESS";
        aipResponse.data = data;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject success(String message, JSONObject data) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.SUCCESS.code();
        aipResponse.message = message;
        aipResponse.data = data;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject fail() {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.FAIL.code();
        aipResponse.message = "FAIL";

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject fail(String message) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.FAIL.code();
        aipResponse.message = message;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject fail(JSONObject data) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.FAIL.code();
        aipResponse.message = "FAIL";
        aipResponse.data = data;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject fail(String message, JSONObject data) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.FAIL.code();
        aipResponse.message = message;
        aipResponse.data = data;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject error(String message) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.ERROR.code();
        aipResponse.message = message;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject paramError(String message) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.PARAM_ERROR.code();
        aipResponse.message = message;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject exception(String message) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = ResponseCode.EXCEPTION.code();
        aipResponse.message = message;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject response(ResponseCode responseCode, String message) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = responseCode.code();
        aipResponse.message = message;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }

    public static JSONObject response(ResponseCode responseCode, String message, JSONObject data) {
        AppResponse aipResponse = new AppResponse();
        aipResponse.code = responseCode.code();
        aipResponse.message = message;
        aipResponse.data = data;

        return JSONUtils.javaBeanToJSON(aipResponse);
    }
}
