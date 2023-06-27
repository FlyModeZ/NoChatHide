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
import net.minecraft.client.gui.GuiScreen;

@Mixin(GuiScreen.class)
public class GuiScreenMixin {
    ChatManager chatManager = McMod.getChatManager();
    Minecraft mc = Minecraft.getMinecraft();

    // @Inject(method = "onGuiClosed", at = @At("HEAD"))
    // public void onGuiClosed(CallbackInfo ci) {
    //     if (this.getClass().equals(GuiDownloadTerrain.class)) {
    //         System.out.println("onGuiClosed END CALLED! " + chatManager.isChatShownPreGuiChange());
    //         if (chatManager.isChatShownPreGuiChange()) {
    //             System.out.println("CHAT SHOULD BE SHOWN HERE! " + chatManager.isChatShownPreGuiChange());
    //             mc.displayGuiScreen(new GuiChat());
    //         }
    //     }
    // }
}
