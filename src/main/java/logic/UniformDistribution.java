package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Duvis Gómez && Martin Vivanco
 */
public class UniformDistribution {
    
    public static final Random RANDOM = ThreadLocalRandom.current();

    public static List<Double> generateAndMultiply(double min,double max,int amount,int simulatedHours){
        boolean isValid = false;
        List<Double> nums = new ArrayList<>();
        while (!isValid) {
            nums.clear();
            for (int i = 0; i < amount; i++) nums.add((min+((max-min)*Math.random()))*simulatedHours);
            isValid=TestUtils.testPk(nums, 95);
        }
        return nums;
    }
}
