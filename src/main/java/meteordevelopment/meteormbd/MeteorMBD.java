package meteordevelopment.meteormbd;

import meteordevelopment.orbit.EventHandler;
import minegame159.meteorclient.MeteorClient;
import minegame159.meteorclient.events.meteor.ClientInitialisedEvent;
import minegame159.meteorclient.modules.Modules;
import minegame159.meteorclient.modules.misc.AutoMountBypassDupe;
import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MeteorMBD implements ClientModInitializer {
	public static final Logger LOG = LogManager.getLogger();

	@Override
	public void onInitializeClient() {
		LOG.info("Initializing Meteor MBD Addon");
		MeteorClient.EVENT_BUS.subscribe(this);
	}

	@EventHandler
	private void onMeteorInitialised(ClientInitialisedEvent event) {
		Modules.get().addModule(new AutoMountBypassDupe());
	};
}
