/** This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://www.wtfpl.net/ for more details.
 */
package pl.betoncraft.flier.event;

import pl.betoncraft.flier.api.content.Game;
import pl.betoncraft.flier.core.MatchingEvent;

/**
 * Called when the Game is created.
 *
 * @author Jakub Sapalski
 */
public class FlierGameCreateEvent extends MatchingEvent {

	public FlierGameCreateEvent(Game game) {
		super(game);
	}

}