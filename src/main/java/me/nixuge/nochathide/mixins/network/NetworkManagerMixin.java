package me.nixuge.nochathide.mixins.network;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.nixuge.nochathide.ChatManager;
import me.nixuge.nochathide.McMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;

@SuppressWarnings("rawtypes")
@Mixin(NetworkManager.class)
public class NetworkManagerMixin {
    ChatManager chatManager = McMod.getChatManager();
    Minecraft mc = Minecraft.getMinecraft();

    @Inject(method = "sendPacket", at = @At("HEAD"))
    public void sendPacket(Packet packetIn, CallbackInfo ci) {
        // Only if shown previously & no GUI currently shown
        if (chatManager.isChatShown() && (mc.currentScreen == null || mc.currentScreen.getClass().equals(GuiIngameMenu.class))) 
            mc.displayGuiScreen(new GuiChat(chatManager.getChatMsg())); 
    }   
}
