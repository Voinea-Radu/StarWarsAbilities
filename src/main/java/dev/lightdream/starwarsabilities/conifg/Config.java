package dev.lightdream.starwarsabilities.conifg;

public class Config {

    public boolean debug = true;

    // Force Throw
    public long forceThrowCooldown = 0;

    // RallyingCry
    public long rallyingCryCooldown = 0;
    public int rallyingCrySpeed = 3;
    public int rallyingCrySpeedDuration = 60 * 20;

    public int rallyingCryResistance = 8;
    public int rallyingCryResistanceDuration = 60 * 20;
    public int rallyingCryResistanceTimer = 10 * 1000;
    public int rallyingCryResistanceDistance = 10;

    // DarkSideFury
    public int darkSideFuryCooldown = 30 * 1000;
    public int darkSideFuryDamageBoost = 2;
    public int darkSideFuryDamageBoostDuration = 5 * 20;
    public int darkSideFuryDamageBoostTimer = 5 * 1000;
    public int darkSideFuryDamageBoostDamageRequirement = 20;

    // Resurrection
    public int resurrectionCooldown = 0;
    public int resurrectionMaxHealth = 5;
    public int  resurrectionHealthAfterDeath = 5;

    // Grappling
    public int grapplingCooldown = 0;

    // JetPack
    public int jetPackCooldown = 16 * 1000;
    public int jetPackFlyTime = 10 * 1000;


}
