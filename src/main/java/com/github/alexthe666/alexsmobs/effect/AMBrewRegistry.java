package com.github.alexthe666.alexsmobs.effect;

import com.github.alexthe666.alexsmobs.AlexsMobs;
import com.github.alexthe666.alexsmobs.item.AMItemRegistry;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.brewing.BrewingRecipe;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = AlexsMobs.MODID, bus = EventBusSubscriber.Bus.GAME)
public class AMBrewRegistry {
    @SubscribeEvent
    public static void onRegisterBrewingRecipes(RegisterBrewingRecipesEvent event) {
        var builder = event.getBuilder();
        builder.addRecipe(new BrewingRecipe(Ingredient.of(AMItemRegistry.POISON_BOTTLE.get()), Ingredient.of(Items.SPIDER_EYE), AMEffectRegistry.createPotion(AMEffectRegistry.POISON_RESISTANCE_POTION)));
        builder.addRecipe(new BrewingRecipe(Ingredient.of(AMItemRegistry.KOMODO_SPIT_BOTTLE.get()), Ingredient.of(Items.SPIDER_EYE), AMEffectRegistry.createPotion(AMEffectRegistry.POISON_RESISTANCE_POTION)));
        builder.addRecipe(new BrewingRecipe(Ingredient.of(AMEffectRegistry.createPotion(AMEffectRegistry.POISON_RESISTANCE_POTION)), Ingredient.of(AMItemRegistry.KOMODO_SPIT.get()), AMEffectRegistry.createPotion(AMEffectRegistry.LONG_POISON_RESISTANCE_POTION)));
    }
}
