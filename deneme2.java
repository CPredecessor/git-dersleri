import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
	public static void main(String args[])
    {	int yil=0;int ay; int gun; int ig=0;int sg=0; int ilkgunn=-1;
    	String ilkgun = new String();
    	String Deneme = new String();
    	boolean artik;String a="";
    	Scanner input = new Scanner(System.in);
		do {
			System.out.print("Lütfen yýlý giriniz:");
			yil = input.nextInt();
			artik=isLeapYear(yil);
			}while(1900>yil | yil>2100);
		// Fahri Mert Eskici 170203031
		String[] gunler = new String[]{"Pazartesi","Salý","Çarþamba","Persembe","Cuma","Cumartesi","Pazar"};
		do {
			System.out.print("Lütfen Yýlýn Ýlk Gününü Giriniz:");
			ilkgun = input.next();
			}while(!Arrays.asList(gunler).contains(ilkgun));
		do {
			System.out.print("Lütfen Hangi Ay olduðunu rakamla giriniz:");
			ay = input.nextInt();}
			while(1>ay | ay>12);
		do {
			System.out.print("Lütfen Hangi Gun olduðunu rakamla giriniz:");
			gun = input.nextInt();
			ig =1;
			if(ay==1 | ay==3 | ay==5 | ay==7 | ay==8 | ay==10 | ay==12) {		
				sg=31;
			}else if(ay==2) {
				if(artik == true) {
					sg=29;
				}else {sg=28;
				}	
			}else {sg=30;
			}
			}while(ig>gun | gun>sg);
		
		for(int i=0;i<gunler.length;i++)
		{	
			Deneme=gunler[i];
			if(ilkgun.compareTo(Deneme)==0) {
				ilkgunn=i;
			}		
		}
		
		String b = findWeekday(gun,ay,yil,ilkgunn);
		
		System.out.print("\n"+gun+"."+ay+"."+yil+" "+b);
		
		
		
    }

	
	
	private static boolean isLeapYear(int yil) {
		if(yil==2000)
		{
			return false;}
		
		else if(yil%4==0){
			return true;
		}else {return false;}
	}
	
	private static String findWeekday(int gun,int ay,int yil,int ilkgun) {
		boolean artik=isLeapYear(yil);int topgun=0;int formul =0;
		int[] aylar;
		String[] gunler = new String[]{"Pazartesi","Salý","Çarþamba","Persembe","Cuma","Cumartesi","Pazar"};
		if(artik==true)
		{
			aylar=new int[] {31,29,31,30,31,30,31,31,30,31,30,31};
		}else 
		{
			aylar=new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		}
		
		for(int i=0;i<ay-1;i++) {
			topgun+=aylar[i];
		}
		formul = (((topgun + gun -1)%7)+ilkgun)%7;
		return gunler[formul];
	}
	
	    
}
