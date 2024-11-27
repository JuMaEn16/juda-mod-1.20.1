package de.dar1rojumaen.judamod.jumaen.item.custom.doubleJump;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import de.dar1rojumaen.judamod.jumaen.attribute.JuModAttributes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;

import java.util.UUID;

public class JuDoubleJumpBoots extends ArmorItem {
    private static final UUID SAFE_FALL_DISTANCE_MODIFIER_UUID = UUID.randomUUID();

    public JuDoubleJumpBoots(ArmorMaterial material, Type type, Settings settings) {
        super(material, Type.BOOTS, settings); // Use EquipmentSlot directly
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        // Ensure the attributes only apply to the boots slot
        if (slot == EquipmentSlot.FEET) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();

            // Add default armor modifiers
            builder.put(
                    EntityAttributes.GENERIC_ARMOR,
                    new EntityAttributeModifier(
                            "Armor modifier",
                            this.getMaterial().getProtection(Type.BOOTS),
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );

            // Add a custom safe fall distance attribute
            builder.put(
                    JuModAttributes.SAFE_FALL_DISTANCE, // No direct safe fall attribute in vanilla; choose a placeholder
                    new EntityAttributeModifier(
                            "Safe fall distance",
                            10.0, // Add 10 extra blocks to safe fall distance
                            EntityAttributeModifier.Operation.ADDITION
                    )
            );
            return builder.build();
        }
        return super.getAttributeModifiers(slot);
    }
}
