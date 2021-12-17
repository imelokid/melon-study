package cn.melonkid.bugs.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;
import io.netty.util.CharsetUtil;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.netty.buffer.Unpooled.copiedBuffer;

/**
 * @author zhengyuanyuan05
 * @date 2021/12/16 22:39
 **/
public class HandlePost extends RequestHandler {


    @Override
    public FullHttpResponse handleRequest(FullHttpRequest fullHttpRequest) {
        System.out.println(getPostParamsFromChannel(fullHttpRequest));
        String data = "POST method over";
        ByteBuf content = copiedBuffer(data, CharsetUtil.UTF_8);
        return responseOK(HttpResponseStatus.OK, content);
    }

    /**
     * 获取POST方式传递的参数
     */
    private Map<String, Object> getPostParamsFromChannel(FullHttpRequest fullHttpRequest) {

        Map<String, Object> params = new HashMap<String, Object>();

        if (fullHttpRequest.method() == HttpMethod.POST) {
            // 处理POST请求
            String strContentType = fullHttpRequest.headers().get("Content-Type").trim();
            if (strContentType.contains("x-www-form-urlencoded")) {
                params  = getFormParams(fullHttpRequest);
            } else if (strContentType.contains("application/json")) {
                try {
                    params = getJSONParams(fullHttpRequest);
                } catch (UnsupportedEncodingException e) {
                    return null;
                }
            } else {
                return null;
            }
            return params;
        } else {
            return null;
        }
    }

    /**
     * 解析from表单数据（Content-Type = x-www-form-urlencoded）
     */
    private Map<String, Object> getFormParams(FullHttpRequest fullHttpRequest) {
        Map<String, Object> params = new HashMap<String, Object>();

        HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(new DefaultHttpDataFactory(false), fullHttpRequest);
        List<InterfaceHttpData> postData = decoder.getBodyHttpDatas();

        for (InterfaceHttpData data : postData) {
            if (data.getHttpDataType() == InterfaceHttpData.HttpDataType.Attribute) {
                MemoryAttribute attribute = (MemoryAttribute) data;
                params.put(attribute.getName(), attribute.getValue());
            }
        }

        return params;
    }

    /**
     * 解析json数据（Content-Type = application/json）
     */
    private Map<String, Object> getJSONParams(FullHttpRequest fullHttpRequest) throws UnsupportedEncodingException {
        Map<String, Object> params = new HashMap<String, Object>();

        ByteBuf content = fullHttpRequest.content();
        byte[] reqContent = new byte[content.readableBytes()];
        content.readBytes(reqContent);
        String strContent = new String(reqContent, "UTF-8");

        JSONObject jsonParams = JSON.parseObject(strContent);
        for (Object key : jsonParams.keySet()) {
            params.put(key.toString(), jsonParams.get(key));
        }

        return params;
    }
}
