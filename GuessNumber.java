package Interview;
import java.util.*;

public class GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		System.out.println("*****Welcome to Number Guessing Game******");
		System.out.println("before Starting your game please understand the game concept ");
		System.out.println("+ mention the number is correct and the correct position ");
		System.out.println("- mention the number is correct the position is wrong ");
             System.out.println("******** lets start your game *******");		
		Random random=new Random();
		System.out.println("Enter your name");
		
		String name=sc.nextLine();
		int[] numToguess = generateRandomNumber(random);
		int numberOfTries=0;
		long startTime=System.currentTimeMillis();
		while(true) {
			System.out.println("Guess the 4 digit number");
			String guess=sc.nextLine();
			if(guess.length()!=4) {
				System.out.println("Invalid input! Please enter 4 digit number ");
				continue;
			}
			for(int i=0;i<numToguess.length;i++) {
				System.out.print(numToguess[i]);
			}System.out.println();
			
			numberOfTries++;
			String result=checkGuess(numToguess,guess);
			System.out.println(result);
			if(result.equals("++++")) {
				long endTime=System.currentTimeMillis();
				long timeTaken = endTime - startTime;
				System.out.println("Congratultions,"+name+"your won"+numberOfTries+"tries and "+timeTaken/1000+"seconds.");
				break;
			}
		}
	}
private static int[] generateRandomNumber(Random random) {
	//int number=random.nextInt(9000)+1000;
	//return number;
	List<Integer> digits=new ArrayList();
	for(int i=0;i<=9;i++) {
		digits.add(i);
	}
	Collections.shuffle(digits);
	int[] randomNumber=new int[4];
	for(int i=0;i<4;i++) {
		randomNumber[i]=digits.get(i);
	}return randomNumber;
	
}
 private static String checkGuess(int[] numToguess,String guess) {
	 char[] numToguessArray=String.valueOf(numToguess).toCharArray();
	 char[] guessArray = guess.toCharArray();
	 StringBuilder result =new StringBuilder();
	 for(int i=0;i<4;i++)
   {
		 if(guessArray[i]==numToguessArray[i])
		 {
			 result.append("+");
		 }
		 else if(String.valueOf(numToguessArray).contains(String.valueOf(guessArray[i])))
		 {
			 result.append("-");
		 }
		 else 
		 {
			 result.append(" ");
			 
		 }
	 }
	 return result.toString();
	 
	 
 }
	
	
	
	
}

