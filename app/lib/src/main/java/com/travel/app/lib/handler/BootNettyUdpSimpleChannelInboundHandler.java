package com.travel.app.lib.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BootNettyUdpSimpleChannelInboundHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        try {
            String strdata = msg.content().toString(CharsetUtil.UTF_8);
            // Print the received message
//            log.info("---------------------receive data--------------------------");
//            log.info(strdata);
//            log.info("---------------------receive data--------------------------");
            // Received udp Message, you can return the message in the same way, such as return timestamp
            ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("ok", CharsetUtil.UTF_8), msg.sender()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
