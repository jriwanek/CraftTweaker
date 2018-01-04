package crafttweaker.api.player;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.chat.IChatMessage;
import crafttweaker.api.data.IData;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.util.IPosition3f;
import stanhebben.zenscript.annotations.*;

/**
 * @author Stan
 */
@ZenClass("crafttweaker.player.IEntityPlayer")
@ZenRegister
public interface IEntityPlayer extends IEntityLivingBase, IPlayer {
    
    @ZenGetter("name")
    String getName();
    
    @ZenGetter("data")
    IData getData();
    
    @ZenGetter("xp")
    int getXP();
    
    @ZenSetter("xp")
    void setXP(int xp);
    
    @ZenMethod
    void removeXP(int xp);
    
    @ZenMethod
    void update(IData data);
    
    @ZenMethod
    void sendChat(IChatMessage message);
    
    @ZenMethod
    void sendChat(String message);
    
    @ZenGetter("hotbarSize")
    int getHotbarSize();
    
    @ZenMethod
    IItemStack getHotbarStack(int i);
    
    @ZenGetter("inventorySize")
    int getInventorySize();
    
    @ZenMethod
    IItemStack getInventoryStack(int i);
    
    @ZenGetter("currentItem")
    IItemStack getCurrentItem();
    
    @ZenGetter("creative")
    boolean isCreative();
    
    @ZenGetter("adventure")
    boolean isAdventure();
    
    @ZenMethod
    void give(IItemStack stack);
    
    // not an exposed method. risks abuse
    void openBrowser(String url);
    
    // not an exposed method, so far. would it be useful?
    void copyToClipboard(String value);
    
    @ZenMethod
    void teleport(IPosition3f pos);

    @ZenMethod
    @ZenGetter("score")
    int getScore();

    @ZenMethod
    void addScore(int amount);

    @ZenMethod
    @ZenSetter("score")
    void setScore(int amount);
    
    @ZenGetter("foodStats")
    IFoodStats getFoodStats();
}
