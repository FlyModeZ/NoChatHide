package me.nixuge.nochathide.mixins.client.network;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.nixuge.nochathide.ChatManager;
import me.nixuge.nochathide.McMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S21PacketChunkData;

@Mixin(NetHandlerPlayClient.class)
public class NetHandlerPlayClientMixin {
    ChatManager chatManager = McMod.getChatManager();
    Minecraft mc = Minecraft.getMinecraft();

    @Inject(method = "handleJoinGame", at = @At("RETURN"))
    public void handleJoinGameEnd(S01PacketJoinGame packet, CallbackInfo ci) {
        System.out.println("HANDLEJOINGAME END CALLED! " + chatManager.isChatShown());
        if (chatManager.isChatShown()) {
            System.out.println("CHAT SHOULD BE SHOWN HERE! " + chatManager.isChatShown());
            mc.displayGuiScreen(new GuiChat());
        }
    }

    @Inject(method = "handleRespawn", at = @At("RETURN"))
    public void handleRespawn(S07PacketRespawn packet, CallbackInfo ci) {
        System.out.println("HANDLERESPAWN CALLED!!!!!");
        if (chatManager.isChatShown()) {
            System.out.println("CHAT SHOULD BE SHOWN HERE! " + chatManager.isChatShown());
            mc.displayGuiScreen(new GuiChat());
        }
    }
    
    @Inject(method = "handleChunkData", at = @At("HEAD"))
    public void handleRespawn(S21PacketChunkData packet, CallbackInfo ci) {
        System.out.println("handleChunkData CALLED!!!!!");
        if (chatManager.isChatShown()) {
            System.out.println("CHAT SHOULD BE SHOWN HERE! " + chatManager.isChatShown());
            mc.displayGuiScreen(new GuiChat());
        }
    }
}
