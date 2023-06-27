package me.nixuge.nochathide;

import lombok.Getter;
import lombok.Setter;

public class ChatManager {
    @Getter
    @Setter
    private boolean isChatShown = false;
    @Getter
    private boolean isChatShownPreGuiChange = false;

    public void guiChange() {
        System.out.println("GUI CHANGED!" + isChatShown);
        this.isChatShownPreGuiChange = isChatShown;
    }
}
