# NoChatHide
A legacy Forge mod that prevents the chat from getting cleared when you reload the world/change dimension/etc.

### Also works when a new GUI opens while you're typing in chat, your message will appear right back after you close the GUI

I've been told the feature is on the Lunar Client too.

# (dev question) Why is the mixin to show the chat inside NetworkManager?
TLDR; I couldn't find ANY other consistent way to show a chat in game except this one.

I tried probably a dozen different mixins and NOTHING else worked.

If you wanna see which ones I tried, look at the first commit on github and go to the mixins/ folder.

Now yes, this isn't the best as it gets called quite a lot which is something i'd like to avoid, but until I/someone else find some way to avoid that, it'll remain like that.

Nota that while (a bit) unoptimized, this however has the side effect to make this mod active at ALL times, eg when a GUI opens while you're typing in chat.
