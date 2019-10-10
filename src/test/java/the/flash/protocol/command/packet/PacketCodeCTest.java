package the.flash.protocol.command.packet;

import io.netty.buffer.ByteBuf;
import org.junit.Assert;
import org.junit.Test;
import the.flash.protocol.command.Packet;
import the.flash.protocol.command.PacketCodeC;
import the.flash.protocol.command.packet.LoginRequestPacket;
import the.flash.serialize.Serializer;
import the.flash.serialize.impl.JSONSerializer;

public class PacketCodeCTest {
    @Test
    public void encode() {

        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        loginRequestPacket.setVersion(((byte) 1));
        loginRequestPacket.setUserId(123);
        loginRequestPacket.setUsername("zhangsan");
        loginRequestPacket.setPassword("password");

        PacketCodeC packetCodeC = new PacketCodeC();
        ByteBuf byteBuf = packetCodeC.encode(loginRequestPacket);
        Packet decodedPacket = packetCodeC.decode(byteBuf);

        Assert.assertArrayEquals(serializer.serialize(loginRequestPacket), serializer.serialize(decodedPacket));

    }
}
