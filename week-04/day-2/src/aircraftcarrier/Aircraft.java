package aircraftcarrier;

public class Aircraft {
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

    public String getStatus() {
        return "Type " + getClass().getSimpleName() + ", Ammo: " + this.ammo + ", Base Damage: " + this.baseDamage + ", All Damage: " + this.baseDamage * this.ammo;
    }

    public boolean isPriority() {
        return getClass().getSimpleName().equals("F35");
    }
}
