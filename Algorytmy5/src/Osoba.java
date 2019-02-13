import java.io.Serializable;

public class Osoba implements Serializable {
private int pesel;
private String nazwisko;
private String imie;
private double waga;
private double wzrost;
private double BMI;
private String wynik;
private String data;

public Osoba() {
	pesel=0;
	nazwisko="Domyslny";
	imie="Domyslny";
	waga=0;
	wzrost=0;
	BMI=waga/wzrost;
	wynik=podajWynik();
	data="01.01.1999";
}

public Osoba(int pesel,String nazwisko,String imie, double waga,double wzrost,String data) {
	this.pesel=pesel;
	this.nazwisko=nazwisko;
	this.imie=imie;
	this.waga=waga;
	this.wzrost=wzrost;
	this.data=data;
	BMI=this.waga/(this.wzrost*this.wzrost)*10000;
	wynik=podajWynik();
}
public String podajWynik() {
	if(BMI<20) {
		return "niedowaga";
	}
	if(BMI>=20 && BMI<25) {
		return "norma";
	}
	if(BMI>=25 && BMI<30) {
		return "nadwaga";
		
	}
	if(BMI>=30 && BMI<35) {
		return "oty³oœæ stopieñ 1";
	}
	if(BMI>=35 && BMI<40) {
		return "osty³oœæ stopieñ 2";
	}
	if(BMI>=40) {
		return "oty³oœæ stopieñ 3";
	}
	else {
		return "B³¹d w danych";
	}
}
public String toString() {
	return "Pesel to: "+pesel+" "+"Nazwisko to: "+nazwisko+" "+"Imie to: "+imie+" "+"Waga to: "+waga+" "+"Wzrost to: "+wzrost+" "+"Wskaznik BMI to: "+BMI+" "+"Data urodzenia to: "+data+" "+"Wynik to: "+wynik;
}

public String getData() {
	return data;
}

public void setData(String data) {
	this.data = data;
}

public int getPesel() {
	return pesel;
}

public void setPesel(int pesel) {
	this.pesel = pesel;
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

public double getWaga() {
	return waga;
}

public void setWaga(double waga) {
	this.waga = waga;
}

public double getWzrost() {
	return wzrost;
}

public void setWzrost(double wzrost) {
	this.wzrost = wzrost;
}

public double getBMI() {
	return BMI;
}

public void setBMI(double bMI) {
	BMI = bMI;
}

public String getWynik() {
	return wynik;
}

public void setWynik(String wynik) {
	this.wynik = wynik;
}

}
