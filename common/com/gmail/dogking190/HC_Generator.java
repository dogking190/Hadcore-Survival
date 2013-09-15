package com.gmail.dogking190;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class HC_Generator extends ChunkGenerator {
	
	void setBlock(int x, int y, int z, byte[][] chunk, Material material) {
		//if the Block section the block is in hasn't been used yet, allocate it
		if (chunk[y >> 4] == null)
			chunk[y >> 4] = new byte[16 * 16 * 16];
		if (!(y <= 256 && y >= 0 && x <= 16 && x >= 0 && z <= 16 && z >= 0))
			return;
		try {
			chunk[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = (byte) material
					.getId();
		} catch (Exception e) {
			// do nothing
		}
		}

	public byte[][] generateBlockSections(World world, Random random,int chunkX, int chunkZ, BiomeGrid biomeGrid) {
		byte[][] result = new byte[world.getMaxHeight() / 16][]; // world height / chunk part height (=16,look above)
		for(int x = 0;x < 16; x++){
			for(int z= 0; z<16; z++){
				for(int y = 0;y <= 1;y++){

					setBlock(x, y, z, result, Material.BEDROCK);
				}
					
				
			}
			
		}
		
		for(int x = 0;x < 16; x++){
			for(int z= 0; z<16; z++){
				for(int y = 1;y <= 99;y++){

					setBlock(x, y, z, result, Material.DIRT);
				}
					
				
			}
			
		}
		
		for(int x = 0;x < 16; x++){
			for(int z= 0; z<16; z++){
				for(int y = 100;y <= 100;y++){

					setBlock(x, y, z, result, Material.GRASS);
				}
					
				
			}
			
		}
		return result;
	}
	
	
	
	
	
}