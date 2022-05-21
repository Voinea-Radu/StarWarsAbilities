package dev.lightdream.starwarsabilities;

import dev.lightdream.commandmanager.CommandMain;
import dev.lightdream.commandmanager.dto.CommandLang;
import dev.lightdream.commandmanager.manager.CommandManager;
import dev.lightdream.filemanager.FileManager;
import dev.lightdream.filemanager.FileManagerMain;
import dev.lightdream.logger.LoggableMain;
import dev.lightdream.logger.Logger;
import dev.lightdream.messagebuilder.MessageBuilderManager;
import dev.lightdream.starwarsabilities.conifg.Config;
import dev.lightdream.starwarsabilities.conifg.Lang;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements CommandMain, LoggableMain, FileManagerMain {

    public static Main instance;

    // Config
    public Config config;
    public Lang lang;

    // Managers
    public CommandManager commandManager;
    public FileManager fileManager;


    @Override
    public void onEnable() {
        instance = this;
        Logger.init(this);

        fileManager = new FileManager(this);
        MessageBuilderManager.init(fileManager);
        loadConfigs();

        this.commandManager = new CommandManager(this);
    }

    public void loadConfigs() {
        config = fileManager.load(Config.class);
        lang = fileManager.load(Lang.class);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public CommandLang getLang() {
        return lang;
    }

    @Override
    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public String getPackageName() {
        return "dev.lightdream.starwarsabilities";
    }

    @Override
    public boolean debug() {
        return config.debug;
    }

    @Override
    public void log(String s) {
        System.out.println(s);
    }
}

/*

Force Throw - Allows Luke to pickup a block (duplicates block ability is right clicked on as a falling block) and hurl it towards his enemies dealing high damage on impact
Rallying Cry - Grants a 10% speed boost to all allies no matter where they are and grants resistance for 8 to any allies in a 10 block radius 10 seconds after the ability is first activated. Rex is highlighted during this ability to all allies.
Darkside Fury - Grants Vader a damange bonus of 20% for 5 seconds if he takes 20 hearts of damage in a 5 second period. 30 second cooldown.
Resurrection - If activated while under 5 hearts, for the duration of five seconds, Sidious will be revived to half heath after dying. Ability is removed for this second life
Grappling Hook - Rapidly pulls Aurra towards the landing point of the grappling hook. Great for vertical movement. When user lands it on a target, they are pulled towards the user.
Jetpack - Activated with double space, holding down space gains altitude, crouch lowers altitude. WASD flight controls. 10 seconds of flight time, 16 seconds to refuel jetpack.
 */
