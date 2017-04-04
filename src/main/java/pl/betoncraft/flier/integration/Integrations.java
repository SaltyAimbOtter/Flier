/** This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package pl.betoncraft.flier.integration;

import org.bukkit.Bukkit;

import pl.betoncraft.betonquest.BetonQuest;
import pl.betoncraft.flier.api.Flier;
import pl.betoncraft.flier.integration.betonquest.GameCondition;
import pl.betoncraft.flier.integration.betonquest.JoinGameObjective;
import pl.betoncraft.flier.integration.betonquest.JoinLobbyObjective;
import pl.betoncraft.flier.integration.betonquest.LobbyCondition;

/**
 * Loads all possible integrations.
 *
 * @author Jakub Sapalski
 */
public class Integrations {
	
	public Integrations() {
		if (Bukkit.getPluginManager().isPluginEnabled("BetonQuest")) {
			BetonQuest bq = BetonQuest.getInstance();
			bq.registerConditions("ingame", GameCondition.class);
			bq.registerConditions("inlobby", LobbyCondition.class);
			bq.registerObjectives("joinlobby", JoinLobbyObjective.class);
			bq.registerObjectives("joingame", JoinGameObjective.class);
			Flier.getInstance().getLogger().info("Hooked into BetonQuest!");
		}
	}

}
