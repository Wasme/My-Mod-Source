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
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityMooshroom;    
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class MyBiome extends BiomeGenBase
{
    public MyBiome(int par1)
    {
        super(par1);
        
        this.setBiomeName("The Death Biome");
        
        this.topBlock = (byte)Block.sand.blockID;
        this.fillerBlock = (byte)Block.sandStone.blockID;
        
        this.theBiomeDecorator.deadBushPerChunk = 100;
        this.theBiomeDecorator.bigMushroomsPerChunk = 20;

        this.spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 25, 4, 8));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityBlaze.class, 15, 3, 6));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityGiantZombie.class, 4, 1, 5));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPigZombie.class, 20, 6, 12));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityVillager.class, 15, 4, 10));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityIronGolem.class, 10, 2, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCreeper.class, 15, 8, 10));
        
        this.setMinMaxHeight(0.1F, 0.5F);
        this.setTemperatureRainfall(0.5F, 0.3F);
   
    }
}