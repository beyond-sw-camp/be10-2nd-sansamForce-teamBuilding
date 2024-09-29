package sansam.team.common.websocket;

import lombok.RequiredArgsConstructor;
import okhttp3.*;
import okio.ByteString;
import org.springframework.stereotype.Component;
import sansam.team.common.websocket.dto.TeamChatMessageDTO;
import sansam.team.common.websocket.dto.TeamChatMessageType;
import sansam.team.team.query.dto.chat.TeamChatRoomResponse;

@Component
@RequiredArgsConstructor
public class WebSocketClient extends WebSocketListener {
    private final OkHttpClient client = new OkHttpClient();
    private WebSocket webSocket;
    private String userNickName;
    private Long teamChatSeq;
    private Long teamMemberSeq;

    public void start(TeamChatRoomResponse teamChatRoom) {
        Request request = new Request.Builder()
                .url("ws://localhost:8086/ws/chat/" + teamChatRoom.getTeamChatSeq())
                .build();

        this.teamChatSeq = teamChatRoom.getTeamChatSeq();
        this.userNickName = teamChatRoom.getUserNickName();
        this.teamMemberSeq = teamChatRoom.getTeamMemberSeq();

        webSocket = client.newWebSocket(request, this); // this = WebSocketListner
    }

    public void sendMessage(TeamChatMessageDTO teamChatMessage) {
        webSocket.send(makeMessage(teamChatMessage));
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        System.out.println("Connected to server");

        TeamChatMessageDTO teamChatMessage = new TeamChatMessageDTO();
        teamChatMessage.setMessageType(TeamChatMessageType.ENTER);
        teamChatMessage.setTeamChatSeq(teamChatSeq);
        teamChatMessage.setTeamMemberSeq(teamMemberSeq);
        teamChatMessage.setMessage(userNickName + "님이 입장하였습니다.");

        webSocket.send(makeMessage(teamChatMessage));
    }

    @Override
    public void onMessage(WebSocket webSocket, String message) {

        System.out.println("Received message: " + message);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        System.out.println("Received bytes: " + bytes.hex());
    }

    @Override
    public void onClosed(WebSocket webSocket, int code, String reason) {
        System.out.println("Disconnected from server: " + reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        t.printStackTrace();
    }

    public String makeMessage(TeamChatMessageDTO teamChatMessageDTO) {
        String messageJson = "{"
                + "\"messageType\" : \""+ teamChatMessageDTO.getMessageType() +"\","
                + "\"teamChatSeq\" : \"" + teamChatMessageDTO.getTeamChatSeq() + "\","
                + "\"teamMemberSeq\" : \"" + teamChatMessageDTO.getTeamMemberSeq() + "\","
                + "\"message\" : \"" + teamChatMessageDTO.getMessage() + "\""
                + "}";

        return messageJson;
    }
}
