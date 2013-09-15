package com.gmail.dogking190;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class TreeGen extends BlockPopulator {

	
	public void populate(World world, Random random, Chunk chunk) {

		int cX = chunk.getX() * 16;
		int cZ = chunk.getZ() * 16;
		int cZOff = cX +random.nextInt(10);
		int cXOff = cZ + random.nextInt(10);
		
		if(random.nextInt(100) < 20){
		world.generateTree(new Location(world, cXOff, world.getHighestBlockYAt(cXOff, cZOff),cZOff), random.nextBoolean() ? TreeType.TREE : TreeType.TALL_REDWOOD);
				
			}
		}
	}


