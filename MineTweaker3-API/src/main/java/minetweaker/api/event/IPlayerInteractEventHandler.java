/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package minetweaker.api.event;

import minetweaker.util.IEventHandler;
import stanhebben.zenscript.annotations.ZenClass;

/**
 *
 * @author Stan
 */
@ZenClass("minetweaker.event.IPlayerInteractEventHandler")
public interface IPlayerInteractEventHandler extends IEventHandler<PlayerInteractEvent> {
	@Override
	public void handle(PlayerInteractEvent event);
}