package war;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.mohit.war.Battalion;
import com.mohit.war.War;

public class calculateBattleResultTest1 {
	
	Map<Integer, Battalion> defenderMap = new HashMap<Integer, Battalion>();
	
	public calculateBattleResultTest1(){
		
		Battalion horseBattalion = new Battalion("H", 1 , 100, 100);
		Battalion elephantBattalion = new Battalion("E", 2, 50, 50);
		Battalion armouredTankBattalion = new Battalion("AT", 3, 10, 10);
		Battalion slingGunBattalion = new Battalion("SG", 4, 5, 5);
		defenderMap.put(1, horseBattalion);
		defenderMap.put(2, elephantBattalion);
		defenderMap.put(3, armouredTankBattalion);
		defenderMap.put(4, slingGunBattalion);
	}
	
	@Test
	public void test() {
		Map<Integer, Integer> attackerMap = new HashMap<Integer, Integer>();
		attackerMap.put(1, 100);
		attackerMap.put(2, 101);
		attackerMap.put(3, 20);
		attackerMap.put(4, 5);
		
		String output = War.calculateBattleResult(attackerMap, defenderMap);
		String expectedOutput = "WINS 52H 50E 10AT 3SG";
		if(output.equals(expectedOutput))
			System.out.println("Equal");
		assertEquals(output, expectedOutput);
	}
	
}
