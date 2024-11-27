package de.dar1rojumaen.judamod.jumaen.attribute;

import de.dar1rojumaen.judamod.JuDaMod;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class JuModAttributes {

    public static final EntityAttribute SAFE_FALL_DISTANCE = createAttribute(
            "safe_fall_distance",
            0.0, // Default value
            0.0, // Minimum value
            1024.0 // Maximum value
    );

    // Helper method to create and register attributes
    private static EntityAttribute createAttribute(String name, double defaultValue, double minValue, double maxValue) {
        EntityAttribute attribute = new ClampedEntityAttribute(
                "attribute.juda_mod." + name,
                defaultValue,
                minValue,
                maxValue
        ).setTracked(true); // Ensures synchronization with the client
        Registry.register(Registries.ATTRIBUTE, new Identifier(JuDaMod.MOD_ID, name), attribute);
        return attribute;
    }

    public static void register() {

    }
}
