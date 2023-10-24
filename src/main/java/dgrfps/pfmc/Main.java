package dgrfps.pfmc;

import dgrfps.pfmc.items.ItemRegistry;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("pfmc");
	public static final String MODID = "pfmc";

	@Override
	public void onInitialize() {
		ItemRegistry.Init();
		LOGGER.info(MODID + " MOD LOADED.");
	}
}