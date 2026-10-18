package org.code.crazy.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@org.spongepowered.asm.mixin.Mixin(MinecraftServer.class)
public class Mixin {
    @Inject(at = @At("HEAD"), method = "loadLevel")
    private void init(CallbackInfo info) {
        System.out.println("This just got mixed in");
        // This code is injected into the start of MinecraftServer.loadLevel()V
    }
}