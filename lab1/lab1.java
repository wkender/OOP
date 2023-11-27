
package test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
class Music_Albums implements Comparable<Music_Albums>{
    private String musician;
    private String albumname;
    private int price;
    private int quantity;
    
    public Music_Albums(String musician, String albumname, int price, int quantity){
        this.musician = musician;
        this.albumname = albumname;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Music_Albums(){
        this.musician = "";
        this.albumname = "";
        this.price = 0;
        this.quantity = 0;
    }
    
    public int GetPrice(){
        return this.price;
    }
    
    public void Write(FileWriter file){
    	try {
    	file.write(this.musician + " - " + this.albumname + " price " + this.price + " quantity " + this.quantity);
        file.append("\n");
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public int compareTo(Music_Albums al){
        return al.GetPrice()-this.price;
    }
    
}

public class Main
{
   
    
	public static void main(String[] args) {
		Music_Albums alb[] = new Music_Albums[13];
		alb[0] = new Music_Albums("Deftones","Diamond Eyes",300,10);
		alb[1] = new Music_Albums("Type O Negative","Life Is Killing Me",150,15);
		alb[2] = new Music_Albums("Placebo","Placebo",200,30);
		alb[3] = new Music_Albums("Crystal Castles","Crystal Castles",400,30);
		alb[4] = new Music_Albums("Metallica","Kill em All",1000,12);
		alb[5] = new Music_Albums("Nirvana","Bleach",400,30);
		alb[6] = new Music_Albums("Bring Me The Horizon","Semphiternal",220,84);
		alb[7] = new Music_Albums("Kanye West","Graduation",310,21);
		alb[8] = new Music_Albums("Young Thug","Barter 6",321,13);
		alb[9] = new Music_Albums("2Pac","All Eyez on Me",212,16);
		alb[10] = new Music_Albums("Depeche Mode","Violator",14,16);
		alb[11] = new Music_Albums("Destroy Lonely","If Looks Could Kill",315,20);
		alb[12] = new Music_Albums("Kendrick Lamar","good kid M.a.a.d. city",320,20);
		Arrays.sort(alb);
		try (FileWriter file = new FileWriter("text.txt",false)){
		for (Music_Albums al : alb){
		    al.Write(file);
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
