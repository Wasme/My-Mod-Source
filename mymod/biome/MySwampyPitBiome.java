package mymod.biome;

import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MySwampyPitBiome extends BiomeGenBase
{
    public MySwampyPitBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("The Swampy Pit Biome");
        
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.cobblestoneMossy.blockID;
        
        this.theBiomeDecorator.bigMushroomsPerChunk = 2;
        this.theBiomeDecorator.generateLakes = true;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 25, 5, 10));
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySlime.class, 15, 2, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 25, 4, 8));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWitch.class, 15, 1, 2));        
        
        
        this.setMinMaxHeight(0.1F, 0.2F);
        this.setTemperatureRainfall(0.9F, 1.5F);
   
    }
}