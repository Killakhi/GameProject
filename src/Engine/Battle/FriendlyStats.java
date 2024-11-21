package Engine.Battle;

import Inventory.Inventory;
import Inventory.InventoryItem;

public class FriendlyStats {
    public int hpStat = 0;
    public int currentHp = 0;
    public int magicStat = 0;
    public int currentMagic = 0;
    public int attackStat = 0;
    public int speedStat = 0;
    public String partyMemberName;

    public FriendlyStats(String partyMemberName) {
        this.partyMemberName = partyMemberName;
    }

    public FriendlyStats clone() {
        FriendlyStats stats = new FriendlyStats(new String(this.partyMemberName));
        stats.hpStat = hpStat;
        stats.currentHp = currentHp;
        stats.magicStat = magicStat;
        stats.currentHp = currentMagic;
        stats.attackStat = attackStat;
        stats.speedStat = speedStat;

        return stats;
    }

    public FriendlyStats withItemModifier() {
        InventoryItem equipped = Inventory.INSTANCE.equipped;

        FriendlyStats modified = this.clone();
        if (equipped != null) {
            equipped.modifyStats(modified);
        }

        return modified;
    }
}
