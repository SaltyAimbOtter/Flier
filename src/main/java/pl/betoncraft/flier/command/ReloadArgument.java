/** This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package pl.betoncraft.flier.command;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;

import pl.betoncraft.flier.api.Flier;
import pl.betoncraft.flier.api.core.CommandArgument;
import pl.betoncraft.flier.util.LangManager;

/**
 * Reloads the plugin.
 *
 * @author Jakub Sapalski
 */
class ReloadArgument implements CommandArgument {
	
	private Permission permission = new Permission("flier.admin.reload");

	@Override
	public void parse(CommandSender sender, String currentCommand, Iterator<String> it) {
		Flier f = Flier.getInstance();
		f.reload();
		LangManager.sendMessage(sender, "reloaded");
	}

	@Override
	public String getName() {
		return "reload";
	}

	@Override
	public List<String> getAliases() {
		return Arrays.asList(new String[]{"reload"});
	}

	@Override
	public String getDescription(CommandSender sender) {
		return LangManager.getMessage(sender, "reload_desc");
	}

	@Override
	public String getHelp(CommandSender sender) {
		return "";
	}

	@Override
	public Permission getPermission() {
		return permission;
	}

	@Override
	public User getUser() {
		return User.ANYONE;
	}

}