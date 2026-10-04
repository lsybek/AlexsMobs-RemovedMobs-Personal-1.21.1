package com.github.alexthe666.alexsmobs.event;

import com.github.alexthe666.alexsmobs.AlexsMobs;
import com.github.alexthe666.alexsmobs.config.AMConfig;
import com.github.alexthe666.alexsmobs.entity.AMEntityRegistry;
import com.github.alexthe666.alexsmobs.entity.EntityVoidWorm;
import com.github.alexthe666.alexsmobs.misc.AMAdvancementTriggerRegistry;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

import java.util.Random;
import java.util.UUID;

@EventBusSubscriber(modid = AlexsMobs.MODID)
public class VoidWormEnderEyeHandler {
    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        Level level = event.getLevel();
        if (level.isClientSide || !AMConfig.voidWormSummonable) return;
        if (level.getGameTime() % 10 != 0) return;
        net.minecraft.world.phys.AABB voidAABB = new net.minecraft.world.phys.AABB(-3.0E7, -64, -3.0E7, 3.0E7, -60, 3.0E7);
        for (Entity e : level.getEntitiesOfClass(net.minecraft.world.entity.item.ItemEntity.class, voidAABB)) {
            if (!(e instanceof ItemEntity itemEntity)) continue;
            if (itemEntity.isRemoved()) continue;
            boolean isEnderEye = itemEntity.getItem().is(Items.ENDER_EYE);
            boolean isMysteriousWorm = false;
            try {
                isMysteriousWorm = itemEntity.getItem().is(com.github.alexthe666.alexsmobs.item.AMItemRegistry.MYSTERIOUS_WORM.get());
            } catch (Exception ignored) {}
            if (!isEnderEye && !isMysteriousWorm) continue;
            String dim = level.dimension().location().toString();
            if (!AMConfig.voidWormSpawnDimensions.contains(dim)) continue;
            if (itemEntity.getY() >= -60) continue;
            itemEntity.kill();
            EntityVoidWorm worm = AMEntityRegistry.VOID_WORM.get().create(level);
            if (worm == null) continue;
            worm.setPos(itemEntity.getX(), 0, itemEntity.getZ());
            worm.setSegmentCount(25 + new Random().nextInt(15));
            worm.setXRot(-90.0F);
            worm.updatePostSummon = true;
            worm.setBaseMaxHealth(AMConfig.voidWormMaxHealth, true);
            Entity thrower = itemEntity.getOwner();
            if (thrower != null) {
                UUID uuid = thrower.getUUID();
                if (level.getPlayerByUUID(uuid) instanceof ServerPlayer sp) {
                    AMAdvancementTriggerRegistry.VOID_WORM_SUMMON.get().trigger(sp);
                }
            }
            level.addFreshEntity(worm);
        }
    }
}
