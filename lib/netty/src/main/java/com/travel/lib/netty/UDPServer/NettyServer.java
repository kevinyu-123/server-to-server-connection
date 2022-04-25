package com.travel.lib.netty.UDPServer;

import com.travel.lib.netty.handler.BootNettyUdpSimpleChannelInboundHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServer {
    public void bind(int port) {
        log.info("-------------------------------udpServer-------------------------");
        // Represents a server connection listening thread group that specifically accepts  accept  New client client  Connect
        EventLoopGroup bossLoopGroup  = new NioEventLoopGroup();
        try {
            //1 , creating netty bootstrap  Startup class
            Bootstrap serverBootstrap = new Bootstrap();
            //2 , setting boostrap  Adj. eventLoopGroup Thread group
            serverBootstrap = serverBootstrap.group(bossLoopGroup);
            //3 , setting NIO UDP Connection channel
            serverBootstrap = serverBootstrap.channel(NioDatagramChannel.class);
            //4 Setting channel parameters  SO_BROADCAST Broadcast form
            serverBootstrap = serverBootstrap.option(ChannelOption.SO_BROADCAST, true);
            //5 Setting up the processing class   Assembly line
            serverBootstrap = serverBootstrap.handler((ChannelHandler) new BootNettyUdpSimpleChannelInboundHandler());
            //6 , binding server By calling the sync The () method blocks asynchronously until the binding succeeds
            ChannelFuture f = serverBootstrap.bind(port).sync();
            log.info(NettyServer.class.getName()+" started and listend on "+f.channel().localAddress());
            //7 Listening for channel closure events, the application will 1 Wait until channel Shut down
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            System.out.println("netty udp close!");
            //8  Shut down EventLoopGroup ,
            bossLoopGroup.shutdownGracefully();
        }
    }
}
