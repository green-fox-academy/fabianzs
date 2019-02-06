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
        int numberOfRemainingAmmo = ammo;
        int numberOfAmmosToBeFilled = this.maxAmmo - this.ammo;
        if (this.ammo < this.maxAmmo && ammo > numberOfAmmosToBeFilled) {
            numberOfRemainingAmmo -= numberOfAmmosToBeFilled;
            this.ammo += numberOfAmmosToBeFilled;
            return numberOfRemainingAmmo;
        } else if (this.ammo < this.maxAmmo && ammo <= numberOfAmmosToBeFilled) {
            this.ammo += ammo;
            return 0;
        }
        return numberOfRemainingAmmo;
    }

    public String getType() {
        return this.type;
    }

    public String getStatus() {
        return "Type " + this.type + ", Ammo: " + this.ammo + ", Base Damage: " + this.baseDamage + ", All Damage: " + this.baseDamage * this.ammo;
    }

    public boolean isPriority() {
        if (this.type.equals("F35")) {
            return true;
        } else {
            return false;
        }
    }
}
