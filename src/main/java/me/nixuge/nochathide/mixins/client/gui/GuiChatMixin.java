package me.nixuge.nochathide.mixins.client.gui;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.nixuge.nochathide.ChatManager;
import me.nixuge.nochathide.McMod;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiTextField;

@Mixin(GuiChat.class)
public class GuiChatMixin {
    ChatManager chatManager = McMod.getChatManager();

    @Inject(method = "initGui", at = @At("HEAD"))
    public void initGui(CallbackInfo ci) {
        chatManager.setChatShown(true);
    }
    // this.displayGuiScreen(new GuiChat("/"));
    
    // @Inject(method = "onGuiClosed", at = @At("HEAD"))
    // public void onGuiClosed(CallbackInfo ci) {
    //     chatManager.setChatShown(false);
    // }

    @Inject(method = "keyTyped", at = @At("HEAD"))
    public void keyTyped(char typedChar, int keyCode, CallbackInfo ci) {
        // Same triggers as vanilla to close the chat
        if (keyCode == 1 || keyCode == 28 || keyCode == 156) {
            chatManager.setChatShown(false);
        }
    }
}
