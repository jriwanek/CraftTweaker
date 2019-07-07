package com.blamejared.crafttweaker.api.managers;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.annotations.ZenRegister;
import com.blamejared.crafttweaker.api.item.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.impl.actions.recipes.ActionRemoveRecipeByOutputInput;
import org.openzen.zencode.java.ZenCodeType;

/**
 * Default interface for Registry based handlers as they can all remove recipes by ResourceLocation.
 */
@ZenRegister
@ZenCodeType.Name("crafttweaker.api.registries.ICookingRecipeManager")
public interface ICookingRecipeManager extends IRecipeManager {
    
    /**
     * Adds a recipe based on given params.
     *
     * @param name     Name of the new recipe
     * @param output   IItemStack output of the recipe
     * @param input    IIngredient input of the recipe
     * @param xp       how much xp the player gets
     * @param cookTime how long it takes to cook
     */
    @ZenCodeType.Method
    void addRecipe(String name, IItemStack output, IIngredient input, float xp, int cookTime);
    
    /**
     * Removes a recipe based on it's output and input.
     *
     * @param output IItemStack output of the recipe.
     * @param input  IIngredient of the recipe to remove.
     */
    @ZenCodeType.Method
    default void removeRecipe(IItemStack output, IIngredient input) {
        CraftTweakerAPI.apply(new ActionRemoveRecipeByOutputInput(this, output, input));
    }
    
}