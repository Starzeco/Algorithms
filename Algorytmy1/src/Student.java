import java.io.Serializable;

public class Student implements Serializable {
private String nazwisko;
private String imie;
private long album;
private int rok;
private double srednia;

public Student() {
	nazwisko="kowalski";
	imie="michal";
	album=0;
	rok=0;
	srednia=0;
}
public Student(String nazwisko,String imie,long album,int rok,double srednia) {
	this.nazwisko=nazwisko;
	this.imie=imie;
	this.album=album;
	this.rok=rok;
	this.srednia=srednia;
}
public String getNazwisko() {
	return nazwisko;
}

public void setNazwisko(String nazwisko) {
	this.nazwisko = nazwisko;
}
public String getImie() {
	return imie;
}
public void setImie(String imie) {
	this.imie = imie;
}
public long getAlbum() {
	return album;
}
public void setAlbum(long album) {
	this.album = album;
}
public int getRok() {
	return rok;
}
public void setRok(int rok) {
	this.rok = rok;
}
public double getSrednia() {
	return srednia;
}
public void setSrednia(double srednia) {
	this.srednia = srednia;
}
public void wyswietl() {
	System.out.printf("I%-10s I%-10s I%8d I%5d I%7.2f I",nazwisko,imie,album,rok,srednia);
	}
public String toString() {
	return String.format("%s,%s,%d,%d,%.2f",nazwisko,imie,album,rok,srednia);
}
}
