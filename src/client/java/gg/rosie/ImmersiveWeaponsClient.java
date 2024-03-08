package gg.rosie;

import gg.rosie.network.SyncCritFlagPacket;
import gg.rosie.invoker.LivingEntityInvoker;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

@Environment(EnvType.CLIENT)
public class ImmersiveWeaponsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ClientPlayNetworking.registerGlobalReceiver(SyncCritFlagPacket.PACKET,
				(client, handler, buf, responseSender) -> {
					SyncCritFlagPacket packet = new SyncCritFlagPacket(buf);
					if (client.world != null && client.world
							.getEntityById(packet.getEntityId()) instanceof LivingEntityInvoker invoker) {
						invoker.setCritical(packet.getFlag());
					}
				});
	}
}
