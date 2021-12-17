package cn.melonkid.bugs.http;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.*;

public abstract class RequestHandler {

    abstract FullHttpResponse handleRequest(FullHttpRequest fullHttpRequest);

    protected FullHttpResponse responseOK(HttpResponseStatus status, ByteBuf content) {
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, status, content);
        if (content != null) {
            response.headers().set("Content-Type", "text/plain;charset=UTF-8");
            response.headers().set("Content_Length", response.content().readableBytes());
        }
        return response;
    }
}
