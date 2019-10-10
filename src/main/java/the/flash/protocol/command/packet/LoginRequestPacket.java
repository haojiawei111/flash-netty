package the.flash.protocol.command.packet;

import lombok.Data;
import the.flash.protocol.command.Packet;

import static the.flash.protocol.command.Command.LOGIN_REQUEST;

@Data
public class LoginRequestPacket extends Packet {
    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
