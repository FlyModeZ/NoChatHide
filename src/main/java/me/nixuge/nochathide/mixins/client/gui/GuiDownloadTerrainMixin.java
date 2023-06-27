package me.nixuge.nochathide.mixins.client.gui;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.nixuge.nochathide.ChatManager;
import me.nixuge.nochathide.McMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.play.server.S01PacketJoinGame;

@Mixin(GuiDownloadTerrain.class)
public class GuiDownloadTerrainMixin {
    ChatManager chatManager = McMod.getChatManager();
    Minecraft mc = Minecraft.getMinecraft();
    
    // @Inject(method = "<init>", at = @At("RETURN"))
    // public void init(NetHandlerPlayClient netHandler, CallbackInfo ci) {
    //     chatManager.guiChange();
    // }
    // @Inject(method = "onGuiClosed", at = @At("HEAD"))
    // public void onGuiClosed(CallbackInfo ci) {
    //     System.out.println("onGuiClosed END CALLED! " + shouldBeShown);
    //     if (shouldBeShown) {
    //         System.out.println("CHAT SHOULD BE SHOWN HERE! " + shouldBeShown);
    //         mc.displayGuiScreen(new GuiChat());
    //     }
    // }
}
