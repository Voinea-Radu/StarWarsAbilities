package dev.lightdream.starwarsabilities.command;

import dev.lightdream.commandmanager.CommandMain;
import dev.lightdream.commandmanager.annotation.Command;
import dev.lightdream.logger.Debugger;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Command(aliases = {"sw-debug"}, permission = "starwarsabilities.debug", onlyForPlayers = true)
public class DebugCommand extends dev.lightdream.commandmanager.commands.Command {
    public DebugCommand(CommandMain main) {
        super(main);
    }

    @Override
    public void exec(@NotNull Player player, @NotNull List<String> args) {
        Debugger.log("Debugging...");
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, List<String> list) {
        return null;
    }


}
