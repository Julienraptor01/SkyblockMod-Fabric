package com.kevinthegreat.skyblockmod.compatibility;

import com.kevinthegreat.skyblockmod.screen.SkyblockModOptionsScreen;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public class ModMenuCompat implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return SkyblockModOptionsScreen::new;
    }
}
