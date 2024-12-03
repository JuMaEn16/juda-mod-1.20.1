package de.dar1rojumaen.judamod.dar1ro.sound;

import de.dar1rojumaen.judamod.JuDaMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class DaModSounds {
    //public static final SoundEvent METAL_DETECTOR_FOUND_ORE = registerSoundEvent("metal_detector_found_ore");
    //
    //public static final SoundEvent SOUND_BLOCK_BREAK = registerSoundEvent("sound_block_break");
    //public static final SoundEvent SOUND_BLOCK_STEP = registerSoundEvent("sound_block_step");
    //public static final SoundEvent SOUND_BLOCK_PLACE = registerSoundEvent("sound_block_place");
    //public static final SoundEvent SOUND_BLOCK_HIT = registerSoundEvent("sound_block_hit");
    //public static final SoundEvent SOUND_BLOCK_FALL = registerSoundEvent("sound_block_fall");
    //
    //
    //public static final BlockSoundGroup SOUND_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
    //        DaModSounds.SOUND_BLOCK_BREAK, DaModSounds.SOUND_BLOCK_STEP, DaModSounds.SOUND_BLOCK_PLACE,
    //        DaModSounds.SOUND_BLOCK_HIT, DaModSounds.SOUND_BLOCK_FALL);

    public static final SoundEvent WEAPON_DARIRO = registerSoundEvent("weapon_dariro");
    public static final SoundEvent DOUBLE_JUMP = registerSoundEvent("double_jump");


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(JuDaMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        JuDaMod.LOGGER.info("Registering Dar1ro Sounds for " + JuDaMod.MOD_ID);
    }
}
