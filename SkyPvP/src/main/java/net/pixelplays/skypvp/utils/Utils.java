package net.pixelplays.skypvp.utils;

import net.pixelplays.skypvp.SkyPvP;
import net.pixelplays.skypvp.utils.npc.NPCUtil;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Utils {

    public String Prefix;

    public String Welcome;

    public String onlyPlayerCommand;

    public boolean SETUP_DONE = false;

    public void setupNPC() {
        if (!SETUP_DONE) {
            if (SkyPvP.getInstance().getLocationAPI().getLocation("NPC.Shop") != null) {
                NPCUtil npcUtil = SkyPvP.getInstance().getNpcUtil();
                npcUtil.appendNPC(SkyPvP.getInstance().getLocationAPI().getLocation("NPC.Shop"),
                        UUID.fromString("8886dba4-3c8d-4bb9-8f60-0f8a76819e04"), "§eSkyPvP Shop",
                        true, true, true, null);
                npcUtil.appendNPC(SkyPvP.getInstance().getLocationAPI().getLocation("NPC.Ranginfo"),
                        UUID.fromString("1e001e65-c775-46ee-abd6-be8f70f1218a"), "§aRanginfo",
                        true, true, true, null);
                npcUtil.appendNPC(SkyPvP.getInstance().getLocationAPI().getLocation("NPC.Kits"),
                        UUID.fromString("f5162219-3bf0-47f3-a79a-ff67d9f27630"), "§cKits",
                        true, true, true, null);
                npcUtil.appendNPC(SkyPvP.getInstance().getLocationAPI().getLocation("NPC.Job"),
                        UUID.fromString("6d260e3c-02ab-435a-87d6-7f2eb40f68d2"), "§9Jobs",
                        true, true, true, null);
                SETUP_DONE = true;
            }
        }
    }

    public void checkSetup(final Player player) {
        if (player.hasPermission(SkyPvP.getInstance().getPerms().apprenticePerms)) {
            StringBuilder stringBuilder = new StringBuilder();
            Location location = SkyPvP.getInstance().getLocationAPI().getLocation("Spawn");
            if (location == null) {
                stringBuilder.append(Prefix + "§7Es scheint, als w#re der Spawn nicht gesetzt worden zu sein. Bitte melde dich bei einem Admin");
            }
            if (!SETUP_DONE) {
                stringBuilder.append("§7Außerdem fehlen die Spawns für die NPC's");
            }
            player.sendMessage(stringBuilder.toString());
        }
    }

    //§7•

}
