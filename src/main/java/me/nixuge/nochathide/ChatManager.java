package me.nixuge.nochathide;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatManager {
    private boolean isChatShown = false;
    private String chatMsg = "";
}
