/**
 * Copyright (c) 2017 Jakub Sapalski
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 */
package pl.betoncraft.flier.bonus;

import java.util.Optional;

import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.scheduler.BukkitRunnable;

import pl.betoncraft.flier.api.Flier;
import pl.betoncraft.flier.api.content.Game;
import pl.betoncraft.flier.api.core.InGamePlayer;
import pl.betoncraft.flier.api.core.LoadingException;
import pl.betoncraft.flier.api.core.Owner;

/**
 * A Bonus without physical manifestation, activated by proximity.
 *
 * @author Jakub Sapalski
 */
public class ProximityBonus extends DefaultBonus {

	protected Location location;
	protected final double distance;
	protected BukkitRunnable checker;

	public ProximityBonus(ConfigurationSection section, Game game, Optional<Owner> owner) throws LoadingException {
		super(section, game, owner);
		distance = Math.pow(loader.loadNonNegativeDouble("distance"), 2);
		location = game.getArena().getLocationSet(loader.loadString("location")).getSingle();
	}
	
	public void check() {
		for (InGamePlayer player : game.getPlayers().values()) {
			if (player != null &&
					player.isPlaying() &&
					player.getPlayer().getLocation().distanceSquared(location) <= distance) {
				apply(player);
			}
		}
	}
	
	@Override
	public void release() {
		super.release();
		checker = new BukkitRunnable() {
			@Override
			public void run() {
				check();
			}
		};
		checker.runTaskTimer(Flier.getInstance(), 1, 1);
	}
	
	@Override
	public void block() {
		super.block();
		if (checker != null) {
			checker.cancel();
			checker = null;
		}
	}

}
