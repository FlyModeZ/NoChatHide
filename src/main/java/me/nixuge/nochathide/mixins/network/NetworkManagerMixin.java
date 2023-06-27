package me.nixuge.nochathide.mixins.network;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.nixuge.nochathide.ChatManager;
import me.nixuge.nochathide.McMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

@SuppressWarnings("raw")
@Mixin(NetworkManager.class)
public class NetworkManagerMixin {
    ChatManager chatManager = McMod.getChatManager();
    Minecraft mc = Minecraft.getMinecraft();

    @Inject(method = "sendPacket", at = @At("HEAD"))
    public void sendPacket(Packet packetIn, CallbackInfo ci) {
        System.out.println("sendPacket CALLED!!!!!");
        if (chatManager.isChatShown()) {
            System.out.println("CHAT SHOULD BE SHOWN HERE! " + chatManager.isChatShown());
            mc.displayGuiScreen(new GuiChat());
        }
    }   
}
