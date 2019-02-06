package aircraftcarrier;

public class Aircraft {
    String type;
    int ammo;
    protected int maxAmmo;
    protected int baseDamage;

    public Aircraft() {
        this.ammo = 0;
    }

    public int fight() {
        int damage = this.ammo * this.baseDamage;
        this.ammo = 0;

        return damage;
    }

    public int refill(int ammo) {
        int numberOfAmmosToBeFilled = this.maxAmmo - this.ammo;
        if (numberOfAmmosToBeFilled > 0 && ammo <= numberOfAmmosToBeFilled) {
            this.ammo += ammo;
            return 0;
        } else {
            this.ammo += numberOfAmmosToBeFilled;
            return ammo -= numberOfAmmosToBeFilled;
        }
    }

    public String getType() {
        return " Type " + this.type;
    }

    public String getStatus() {
        return this.getType() + ", Ammo: " + this.ammo + ", Base Damage: " + this.baseDamage + ", All Damage: " + this.baseDamage * this.ammo;
    }

    public boolean isPriority() {
        if (this.type.equals("F35")) {
            return true;
        } else {
            return false;
        }
    }
}
