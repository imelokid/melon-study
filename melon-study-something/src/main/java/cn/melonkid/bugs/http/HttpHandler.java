package cn.melonkid.bugs.http;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengyuanyuan05
 * @date 2021/12/16 22:29
 **/
public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    static Map<String, RequestHandler> requestHandlers = new HashMap<>();

    static{
        requestHandlers.put(HttpMethod.GET.name(), new HandleGet());
        requestHandlers.put(HttpMethod.POST.name(), new HandlePost());
    }

    /**
     * 处理请求
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) {
        System.out.println(fullHttpRequest);

        FullHttpResponse response = null;
        if (fullHttpRequest.method() == HttpMethod.GET) {
            response = requestHandlers.get(HttpMethod.GET.name()).handleRequest(fullHttpRequest);
        }

        else if (fullHttpRequest.method() == HttpMethod.POST) {
            response = requestHandlers.get(HttpMethod.POST.name()).handleRequest(fullHttpRequest);
        }

        else {
            //...
        }
        // 发送响应
        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }


}
