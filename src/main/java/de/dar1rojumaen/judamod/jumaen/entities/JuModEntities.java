package de.dar1rojumaen.judamod.jumaen.entities;

import de.dar1rojumaen.judamod.JuDaMod;
import de.dar1rojumaen.judamod.jumaen.item.custom.tridents.astral.JuAstralTridentEntity;
import de.dar1rojumaen.judamod.jumaen.item.custom.tridents.hellfork.JuHellForkTridentEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JuModEntities {
    public static final EntityType<JuAstralTridentEntity> ASTRAL_TRIDENT_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(JuDaMod.MOD_ID, "astral_trident"),
            FabricEntityTypeBuilder.<JuAstralTridentEntity>create(
                            SpawnGroup.MISC,
                            JuAstralTridentEntity::new
                    )
                    .dimensions(EntityDimensions.fixed(0.5F, 0.5F)) // Adjust entity dimensions if needed
                    .trackRangeBlocks(80)
                    .trackedUpdateRate(10)
                    .build()
    );

    public static final EntityType<JuHellForkTridentEntity> HELLFORK_TRIDENT_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(JuDaMod.MOD_ID, "hellfork_trident"),
            FabricEntityTypeBuilder.<JuHellForkTridentEntity>create(
                            SpawnGroup.MISC,
                            JuHellForkTridentEntity::new
                    )
                    .dimensions(EntityDimensions.fixed(0.5F, 0.5F)) // Adjust entity dimensions if needed
                    .trackRangeBlocks(80)
                    .trackedUpdateRate(10)
                    .build()
    );

    public static void register() {
        System.out.println("Registering JuMaEn Mod entities for " + JuDaMod.MOD_ID); // Debugging purposes
    }
}