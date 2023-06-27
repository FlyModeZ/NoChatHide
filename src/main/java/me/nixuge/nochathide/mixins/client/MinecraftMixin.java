package me.nixuge.nochathide.mixins.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.nixuge.nochathide.ChatManager;
import me.nixuge.nochathide.McMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    // Could maybe be done without mixins
    // net.minecraftforge.client.event.GuiOpenEvent
    // along with
    // Mc.getMc().currentScreen (not yet modified when event called)
    ChatManager chatManager = McMod.getChatManager();
    Minecraft mc = Minecraft.getMinecraft();

    // @Inject(method = "loadWorld(Lnet/minecraft/client/multiplayer/WorldClient;Ljava/lang/String;)V", at = @At("RETURN"))
    // public void loadWorld(WorldClient worldClientIn, String loadingMessage, CallbackInfo ci) {
    //     System.out.println("loadWorld END CALLED! " + chatManager.isChatShown());
    //     if (chatManager.isChatShown()) {
    //         System.out.println("CHAT SHOULD BE SHOWN HERE! " + chatManager.isChatShown());
    //         // mc.displayGuiScreen(new GuiChat());
    //     }
    // }
}
