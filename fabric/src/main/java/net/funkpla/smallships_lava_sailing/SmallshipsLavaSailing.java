package net.funkpla.smallships_lava_sailing;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.entity.vehicle.Boat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmallshipsLavaSailing implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(Constants.MOD_ID);

	@Override
	public void onInitialize() {
        for (Boat.Type boat : Boat.Type.values()) {
            LOGGER.debug("{} => {}", boat.ordinal(), boat);
        }
	}
}