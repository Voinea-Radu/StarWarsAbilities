package dev.lightdream.starwarsabilities.command;

import dev.lightdream.commandmanager.CommandMain;
import dev.lightdream.commandmanager.annotation.Command;
import dev.lightdream.logger.Debugger;
import dev.lightdream.starwarsabilities.Main;
import dev.lightdream.starwarsabilities.ability.ForceThrow;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Command(aliases = {"sw-debug"}, permission = "starwarsabilities.debug", onlyForPlayers = true)
public class DebugCommand extends dev.lightdream.commandmanager.commands.Command {
    public DebugCommand() {
        super(Main.instance);
    }

    @Override
    public void exec(@NotNull Player player, @NotNull List<String> args) {
        Main.instance.abilityManager.getAbility(ForceThrow.class).use(player);
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, List<String> list) {
        return null;
    }


}
