package com.github.zy.netty.rpc.strategy.server;

import com.github.zy.netty.rpc.common.protocol.DefaultMessagePacket;
import com.github.zy.netty.rpc.common.protocol.MessageType;
import com.github.zy.netty.rpc.domain.RpcMappingBean;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @version 1.0 created by zy on 2020/4/28 0:32
 */
public interface ServerMessageResolverStrategy {

    boolean support(MessageType messageType);

    void resolver(ChannelHandlerContext ctx, DefaultMessagePacket msg);

    default void validateMethodParams(List<RpcMappingBean.RpcMethodParam> methodParams) {
        if (!CollectionUtils.isEmpty(methodParams) && methodParams.size() > 1) {
            throw new RuntimeException("方法参数暂时只能支持单个");
        }
    }
}
