package Ipjasic_Beat_05;

public class PlayAndStopMusic_Singleton {

	private PlayAndStopMusic_Singleton(){}
	private static PlayAndStopMusic_Singleton itc = new PlayAndStopMusic_Singleton();
	public static PlayAndStopMusic_Singleton getInstance() { return itc; }
	
	
}
