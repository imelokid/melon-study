package cn.melonkid.bugs.http;

import cn.melonkid.bugs.biz.UserController;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.netty.buffer.Unpooled.copiedBuffer;

/**
 * @author zhengyuanyuan05
 * @date 2021/12/16 22:39
 **/
public class HandleGet extends RequestHandler {

    Logger logger = LogManager.getLogger(HandleGet.class);

    @Override
    public FullHttpResponse handleRequest(FullHttpRequest fullHttpRequest) {
        Map<String, Object> params = getGetParamsFromChannel(fullHttpRequest);
        UserController controller = new UserController();
        String data = "GET method over" + controller.query((String) params.get("name"));
        ByteBuf buf = copiedBuffer(data, CharsetUtil.UTF_8);
        return responseOK(HttpResponseStatus.OK, buf);
    }

    /**
     * 获取GET方式传递的参数
     */
    private Map<String, Object> getGetParamsFromChannel(FullHttpRequest fullHttpRequest) {

        Map<String, Object> params = new HashMap<>();

        if (fullHttpRequest.method() == HttpMethod.GET) {
            // 处理get请求
            QueryStringDecoder decoder = new QueryStringDecoder(fullHttpRequest.uri());
            Map<String, List<String>> paramList = decoder.parameters();
            for (Map.Entry<String, List<String>> entry : paramList.entrySet()) {
                params.put(entry.getKey(), entry.getValue().get(0));
            }
            return params;
        } else {
            return null;
        }

    }
}
