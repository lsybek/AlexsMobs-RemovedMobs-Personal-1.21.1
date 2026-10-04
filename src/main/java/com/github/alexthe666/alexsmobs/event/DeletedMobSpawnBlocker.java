package com.github.alexthe666.alexsmobs.event;

import com.github.alexthe666.alexsmobs.AlexsMobs;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

import java.util.Set;

@EventBusSubscriber(modid = AlexsMobs.MODID, bus = EventBusSubscriber.Bus.GAME)
public class DeletedMobSpawnBlocker {
    private static final Set<String> DELETED_IDS = Set.of(
            "alexsmobs:fly",
            "alexsmobs:crimson_mosquito",
            "alexsmobs:mosquito_spit",
            "alexsmobs:centipede_head",
            "alexsmobs:centipede_body",
            "alexsmobs:centipede_tail",
            "alexsmobs:cockroach",
            "alexsmobs:cockroach_egg",
            "alexsmobs:warped_mosco",
            "alexsmobs:leafcutter_ant",
            "alexsmobs:tarantula_hawk",
            "alexsmobs:anteater",
            "alexsmobs:giant_squid",
            "alexsmobs:squid_grapple",
            "alexsmobs:murmur",
            "alexsmobs:murmur_head",
            "alexsmobs:tendon_segment",
            "alexsmobs:skunk",
            "alexsmobs:fart",
            "alexsmobs:banana_slug",
            "alexsmobs:triops"
    );

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        EntityType<?> type = event.getEntity().getType();
        ResourceLocation id = BuiltInRegistries.ENTITY_TYPE.getKey(type);
        if (id != null && DELETED_IDS.contains(id.toString())) {
            event.setCanceled(true);
            event.getEntity().discard();
        }
    }
}
