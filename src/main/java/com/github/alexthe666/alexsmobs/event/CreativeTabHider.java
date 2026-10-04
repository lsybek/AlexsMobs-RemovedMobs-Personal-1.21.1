package com.github.alexthe666.alexsmobs.event;

import com.github.alexthe666.alexsmobs.block.AMBlockRegistry;
import com.github.alexthe666.alexsmobs.item.AMItemRegistry;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraft.world.item.CreativeModeTab;

@EventBusSubscriber(modid = "alexsmobs", bus = EventBusSubscriber.Bus.MOD)
public class CreativeTabHider {
    @SubscribeEvent
    public static void onBuildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        ItemStack[] toHide = new ItemStack[]{
            new ItemStack(AMItemRegistry.MAGGOT.get()),
            new ItemStack(AMItemRegistry.BLOOD_SAC.get()),
            new ItemStack(AMItemRegistry.MOSQUITO_PROBOSCIS.get()),
            new ItemStack(AMItemRegistry.BLOOD_SPRAYER.get()),
            new ItemStack(AMItemRegistry.CENTIPEDE_LEG.get()),
            new ItemStack(AMItemRegistry.CENTIPEDE_LEGGINGS.get()),
            new ItemStack(AMItemRegistry.MOSQUITO_LARVA.get()),
            new ItemStack(AMItemRegistry.COCKROACH_WING_FRAGMENT.get()),
            new ItemStack(AMItemRegistry.COCKROACH_WING.get()),
            new ItemStack(AMItemRegistry.COCKROACH_OOTHECA.get()),
            new ItemStack(AMItemRegistry.WARPED_MUSCLE.get()),
            new ItemStack(AMItemRegistry.HEMOLYMPH_SAC.get()),
            new ItemStack(AMItemRegistry.HEMOLYMPH_BLASTER.get()),
            new ItemStack(AMItemRegistry.WARPED_MIXTURE.get()),
            new ItemStack(AMItemRegistry.GONGYLIDIA.get()),
            new ItemStack(AMItemRegistry.LEAFCUTTER_ANT_PUPA.get()),
            new ItemStack(AMItemRegistry.TARANTULA_HAWK_WING_FRAGMENT.get()),
            new ItemStack(AMItemRegistry.TARANTULA_HAWK_WING.get()),
            new ItemStack(AMItemRegistry.TARANTULA_HAWK_ELYTRA.get()),
            new ItemStack(AMItemRegistry.MYSTERIOUS_WORM.get()),
            new ItemStack(AMItemRegistry.LOST_TENTACLE.get()),
            new ItemStack(AMItemRegistry.SQUID_GRAPPLE.get()),
            new ItemStack(AMItemRegistry.ELASTIC_TENDON.get()),
            new ItemStack(AMItemRegistry.TENDON_WHIP.get()),
            new ItemStack(AMItemRegistry.UNSETTLING_KIMONO.get()),
            new ItemStack(AMItemRegistry.STINK_BOTTLE.get()),
            new ItemStack(AMItemRegistry.STINK_RAY.get()),
            new ItemStack(AMItemRegistry.BANANA_SLUG_SLIME.get()),
            new ItemStack(AMItemRegistry.MOSQUITO_REPELLENT_STEW.get()),
            new ItemStack(AMItemRegistry.TRIOPS_BUCKET.get()),
            new ItemStack(AMBlockRegistry.LEAFCUTTER_ANTHILL.get().asItem()),
            new ItemStack(AMBlockRegistry.LEAFCUTTER_ANT_CHAMBER.get().asItem()),
            new ItemStack(AMBlockRegistry.BANANA_SLUG_SLIME_BLOCK.get().asItem()),
            new ItemStack(AMBlockRegistry.CRYSTALIZED_BANANA_SLUG_MUCUS.get().asItem()),
            new ItemStack(AMBlockRegistry.TRIOPS_EGGS.get().asItem()),
            new ItemStack(AMBlockRegistry.SKUNK_SPRAY.get().asItem())
        };
        for (ItemStack stack : toHide) {
            event.remove(stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
    }
}
