package com.travel.lib.netty;


import com.travel.lib.netty.UDPServer.NettyServer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class NettyApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(NettyApplication.class,args);
    }

    @Async
    @Override
    public void run(String[] args){
        new NettyServer().bind(8080);
    }
}
