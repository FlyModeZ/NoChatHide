package me.nixuge.nochathide;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventHandler {
    @SubscribeEvent
    public void onConfigurationChangeEvent(final PlayerEvent.PlayerLoggedInEvent event) {
        System.out.println("TRANSPORTEZD!!!!");
    }
}
