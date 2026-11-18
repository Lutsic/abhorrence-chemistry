package com.abhorrence.chemistry.recipe;

import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.IResourceManagerReloadListener;

import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class RecipeManagerHandler {

    // Вызывается при каждой загрузке datapack-ов
    public static void onAddReloadListener(
            AddReloadListenerEvent event
    ) {
        event.addListener(
                (IResourceManagerReloadListener) resourceManager -> {

                    MinecraftServer server =
                            ServerLifecycleHooks.getCurrentServer();

                    // При первоначальной загрузке сервер ещё может отсутствовать
                    if (server == null) {
                        return;
                    }

                    applyChanges(server);
                }
        );
    }

    // Первоначальное применение после запуска сервера
    public static void onServerStarted(
            FMLServerStartedEvent event
    ) {
        applyChanges(event.getServer());
    }

    private static void applyChanges(MinecraftServer server) {

        System.out.println("[Chemistry] Applying recipe changes!");

        RecipeEditor editor = new RecipeEditor(
                server.getRecipeManager()
        );

        RecipeModifications.apply(editor);

        editor.apply();

        System.out.println(
                "[Chemistry] Recipes updated: " + editor.size()
        );
    }
}
