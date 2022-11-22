package dynamic_beat_4;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] numbers = {4, 455, 6, 4, -1, 45, 6};
		int[] answer = {};
		String direction = "left";
		System.out.println(numbers.length);
        
        if(direction.equals("right")){
            for(int i = 0; i<numbers.length-1; i++){
                numbers[0] = numbers[numbers.length-1];
                numbers[i] = numbers[i+1];
            }
        }
        else{
            for(int i = 0; i<numbers.length-1; i++){
                numbers[numbers.length-1] = numbers[0];
                numbers[i+1] = numbers[i];
            }
        }
        
        
		
		
	}

}
