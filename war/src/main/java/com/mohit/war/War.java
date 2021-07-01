package com.mohit.war;

import java.util.HashMap;
import java.util.Map;

public class War {
	
	public static void main(String args[]) {
		
		if (args.length > 0)
        {
            String filePath = args[0];
            
            Map<Integer, Battalion> defenderMap = new HashMap<Integer, Battalion>();
    		
    		// H - Horses, E - Elephants, AT - Armoured Tanks, SG - Sling Guns
    		Battalion horseBattalion = new Battalion("H", WarConstants.HORSE_RANK, WarConstants.MAX_HORSES, WarConstants.MAX_HORSES);
    		Battalion elephantBattalion = new Battalion("E", WarConstants.ELEPHANT_RANK, WarConstants.MAX_ELEPHANTS, WarConstants.MAX_ELEPHANTS);
    		Battalion armouredTankBattalion = new Battalion("AT", WarConstants.ARMOURED_TANK_RANK, WarConstants.MAX_ARMOURED_TANKS, WarConstants.MAX_ARMOURED_TANKS);
    		Battalion slingGunBattalion = new Battalion("SG", WarConstants.SLING_GUN_RANK, WarConstants.MAX_SLING_GUNS, WarConstants.MAX_SLING_GUNS);
    		
    		defenderMap.put(WarConstants.HORSE_RANK, horseBattalion);
    		defenderMap.put(WarConstants.ELEPHANT_RANK, elephantBattalion);
    		defenderMap.put(WarConstants.ARMOURED_TANK_RANK, armouredTankBattalion);
    		defenderMap.put(WarConstants.SLING_GUN_RANK, slingGunBattalion);
    		
    		Map<Integer,Integer> attackerMap = FileReader.readInput(filePath);
    		
    		String result = calculateBattleResult(attackerMap,defenderMap);
    		System.out.println(result);
        }
        else {
            System.out.println("No command line arguments found.");
        }		
	}

	/**
	 * This method takes the attacker and defender's troops and calculates if the defender wins or loses and how many troops were required.
	 * @param attackerMap
	 * @param defenderMap
	 * @return String output
	 */
	public static String calculateBattleResult(Map<Integer, Integer> attackerMap, Map<Integer, Battalion> defenderMap) {
		
		boolean won = true;
		StringBuilder result = new StringBuilder();
		
		for(int rank = 1; rank <= WarConstants.BATTALION_COUNT; rank++) {
			if(attackerMap.containsKey(rank) && defenderMap.containsKey(rank)) {
				
				int attackerQty = (int)Math.ceil(attackerMap.get(rank)/2f);
				int defenderQty = defenderMap.get(rank).getQuantityLeft();
				int troopsUsed = 0;
						
				if(attackerQty <= defenderQty) {
					defenderMap.get(rank).setQuantityLeft(defenderQty - attackerQty);
					troopsUsed = defenderMap.get(rank).getMaxQty() - defenderMap.get(rank).getQuantityLeft();
					result.append(troopsUsed + defenderMap.get(rank).getType() + " ");
				}
				
				else {
					
					int prevBattalionQty = defenderMap.get(rank-1) != null? defenderMap.get(rank-1).getQuantityLeft() : 0;
					int nextBattalionQty = defenderMap.get(rank+1) != null? defenderMap.get(rank+1).getQuantityLeft() : 0;
					int remainingTroops = attackerQty - defenderQty;
					defenderMap.get(rank).setQuantityLeft(0);
					
					if(prevBattalionQty > 0) {
						if(prevBattalionQty < 2*remainingTroops) {
							defenderMap.get(rank-1).setQuantityLeft(0);
							troopsUsed = defenderMap.get(rank-1).getMaxQty();
							remainingTroops -= (int)Math.floor(prevBattalionQty/2f);
						}
						else {
							defenderMap.get(rank-1).setQuantityLeft(prevBattalionQty - 2*remainingTroops);
							remainingTroops = 0;
							troopsUsed = defenderMap.get(rank-1).getMaxQty() - defenderMap.get(rank-1).getQuantityLeft();
						}
						
						result = removeLastWord(result);
						result.append(troopsUsed + defenderMap.get(rank-1).getType() + " ");
						if(remainingTroops == 0) {
							troopsUsed = defenderMap.get(rank).getMaxQty();
							result.append(troopsUsed + defenderMap.get(rank).getType() + " ");
						}
					}
					
					if(remainingTroops > 0) {
						if((int)Math.ceil(remainingTroops/2f) > nextBattalionQty) {
							won = false;
						}
						else {
							defenderMap.get(rank+1).setQuantityLeft(nextBattalionQty - (int) Math.ceil(remainingTroops/2f));
						}
						troopsUsed = defenderMap.get(rank).getMaxQty();
						result.append(troopsUsed + defenderMap.get(rank).getType() + " ");
					}
				}
			}
		}
		
		if(won == true) {
			result.insert(0,"WINS ");
		}
		else {
			result.insert(0,"LOSES ");
		}
		return result.toString().trim();
	}

	/**
	 * This method removes the last word and returns the input stringBuilder
	 * @param result
	 * @return result
	 */
	private static StringBuilder removeLastWord(StringBuilder result) {
		if(result.length() != 0)
			result.setLength(result.length()-1);
		while(result.length() != 0 && result.charAt(result.length()-1) != ' ' ) {
			result.setLength(result.length()-1);
		}
		return result;
	}
}
