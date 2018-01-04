package crafttweaker.api.event;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.player.IEntityPlayer;
import stanhebben.zenscript.annotations.*;

/**
 * @author Stan
 */
@ZenClass("crafttweaker.event.PlayerPickupEvent")
@ZenRegister
public class PlayerPickupEvent implements IEventCancelable {
    
    private final IEntityPlayer player;
    private final IEntity entity;
    private boolean canceled;
    private boolean processed;
    
    public PlayerPickupEvent(IEntityPlayer player, IEntity entity) {
        this.player = player;
        this.entity = entity;
        
        canceled = false;
        processed = false;
    }
    
    @Override
    public void cancel() {
        canceled = true;
    }
    
    /**
     * Processes the event (picks up the entity).
     */
    @ZenMethod
    public void process() {
        processed = true;
    }
    
    @Override
    public boolean isCanceled() {
        return canceled;
    }
    
    @ZenGetter("processed")
    public boolean isProcessed() {
        return processed;
    }
    
    @ZenGetter("player")
    public IEntityPlayer getPlayer() {
        return player;
    }
    
    @ZenGetter("entity")
    public IEntity getEntity() {
        return entity;
    }
}
