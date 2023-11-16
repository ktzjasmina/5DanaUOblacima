package com.example.L9.basket;

public class Igrac {

	private String Ime;
	private String Pozicija;
	private double BrPogodjenoBacanja;
	private double BrPokusanoBacanja;
	private double BrPogodjenoDvaPoena;
	private double BrPokusanoDvaPoena;
	private double BrPogodjenoTriPoena;
	private double BrPokusanoTriPoena;
	private double BrSkokova;
	private double BrBlokiranihSuteva;
	private double BrAsistencija;
	private double BrUkradenihLopti;
	private double BrIzgubljenihLopti;
	private double ProcenatBacanja;
	private double ProcenatZaDvaPoena;
	private double ProcenatZaTriPoena;
	private double Poeni;
	private double IndeksUspesnosti;
	private double EfektivniProcenatSuta;
	private double StvarniProcenatSuta;
	private double HolingerovOdnosAsistencija;
	private double BrUtakmica;

	public Igrac(String ime, String pozicija, double brPogodjenoBacanja, double brPokusanoBacanja,
			double brPogodjenoDvaPoena, double brPokusanoDvaPoena, double brPogodjenoTriPoena,
			double brPokusanoTriPoena, double brSkokova, double brBlokiranihSuteva, double brAsistencija,
			double brUkradenihLopti, double brIzgubljenihLopti) {

		super();
		Ime = ime;
		Pozicija = pozicija;
		BrPogodjenoBacanja = brPogodjenoBacanja;
		BrPokusanoBacanja = brPokusanoBacanja;
		BrPogodjenoDvaPoena = brPogodjenoDvaPoena;
		BrPokusanoDvaPoena = brPokusanoDvaPoena;
		BrPogodjenoTriPoena = brPogodjenoTriPoena;
		BrPokusanoTriPoena = brPokusanoTriPoena;
		BrSkokova = brSkokova;
		BrBlokiranihSuteva = brBlokiranihSuteva;
		BrAsistencija = brAsistencija;
		BrUkradenihLopti = brUkradenihLopti;
		BrIzgubljenihLopti = brIzgubljenihLopti;
		BrUtakmica = 1;

	}

	public String getIme() {
		return Ime;
	}

	public void izracunajProcenatBacanja() {
		ProcenatBacanja = BrPogodjenoBacanja / BrPokusanoBacanja * 100;
	}

	public void izracunajProcenatZaDvaPoena() {
		ProcenatZaDvaPoena = BrPogodjenoDvaPoena / BrPokusanoDvaPoena * 100;
	}

	public void izracunajProcenatZaTriPoena() {
		ProcenatZaTriPoena = BrPogodjenoTriPoena / BrPokusanoTriPoena * 100;
	}

	public void izracunajPoene() {
		Poeni = BrPogodjenoBacanja + 2 * BrPogodjenoDvaPoena + 3 * BrPogodjenoTriPoena;
	}

	public void izracunajUspesnost() {
		IndeksUspesnosti = (BrPogodjenoBacanja + 2 * BrPogodjenoDvaPoena + 3 * BrPogodjenoTriPoena + BrSkokova
				+ BrBlokiranihSuteva + BrAsistencija + BrUkradenihLopti)
				- (BrPokusanoBacanja - BrPogodjenoBacanja + BrPokusanoDvaPoena - BrPogodjenoDvaPoena
						+ BrPokusanoTriPoena - BrPogodjenoTriPoena + BrIzgubljenihLopti);
	}

	public void izracunajEfektivniProcenatSuta() {
		EfektivniProcenatSuta = (BrPogodjenoDvaPoena + 1.5 * BrPogodjenoTriPoena)
				/ (BrPokusanoDvaPoena + BrPokusanoTriPoena) * 100;
	}

	public void izracunajStvarniProcenatSuta() {
		StvarniProcenatSuta = Poeni / (2 * (BrPokusanoDvaPoena + BrPokusanoTriPoena + 0.475 * BrPokusanoBacanja))
				* 100;
	}

	public void izracunajHolingerovOdnos() {
		HolingerovOdnosAsistencija = BrAsistencija / (BrPokusanoDvaPoena + BrPokusanoTriPoena
				+ 0.475 * BrPokusanoBacanja + BrAsistencija + BrIzgubljenihLopti) * 100;
	}

	public void izvedeneStatistike() {
		izracunajProcenatBacanja();
		izracunajProcenatZaDvaPoena();
		izracunajProcenatZaTriPoena();
		izracunajPoene();
		izracunajUspesnost();
		izracunajEfektivniProcenatSuta();
		izracunajStvarniProcenatSuta();
		izracunajHolingerovOdnos();
	}
	
	public void ponovnaPojava(double pogodjenoBacanja, double pokusanoBacanja, double pogodjenoDvaPoena,
			double pokusanoDvaPoena, double pogodjenoTriPoena, double pokusanoTriPoena, double skokova,
			double blokiranih, double asistencija, double ukradenih, double izgubljenih) {

		BrPogodjenoBacanja += pogodjenoBacanja;
		BrPokusanoBacanja += pokusanoBacanja;
		BrPogodjenoDvaPoena += pogodjenoDvaPoena;
		BrPokusanoDvaPoena += pokusanoDvaPoena;
		BrPogodjenoTriPoena += pogodjenoTriPoena;
		BrPokusanoTriPoena += pokusanoTriPoena;
		BrSkokova += skokova;
		BrBlokiranihSuteva += blokiranih;
		BrAsistencija += asistencija;
		BrUkradenihLopti += ukradenih;
		BrIzgubljenihLopti += izgubljenih;
		BrUtakmica++;
	}

	public void izracunajStatistikuIgraca() {

		BrPogodjenoBacanja /= BrUtakmica;
		BrPokusanoBacanja /= BrUtakmica;
		BrPogodjenoDvaPoena /= BrUtakmica;
		BrPokusanoDvaPoena /= BrUtakmica;
		BrPogodjenoTriPoena /= BrUtakmica;
		BrPokusanoTriPoena /= BrUtakmica;
		BrSkokova /= BrUtakmica;
		BrBlokiranihSuteva /= BrUtakmica;
		BrAsistencija /= BrUtakmica;
		BrUkradenihLopti /= BrUtakmica;
		BrIzgubljenihLopti /= BrUtakmica;
	}

	@Override
	public String toString() {
		return "{" + "\n" +
				"\"playerName\": \" " + Ime + "\",\n" +
				"\"gamesPlayed\": \" " + BrUtakmica + ",\n" +
				"\"traditional\": \" " + "{\n" +
				"\t\"freeThrows\": { \n" +
				"\t\t\"attempts\": " + BrPokusanoBacanja + ",\n" +
				"\t\t\"made\": " + BrPogodjenoBacanja + ",\n" +
				"\t\t\"shootingPercentage\": " + ProcenatBacanja + "\n" +
				"\t\t},\n" +
				"\t\"twoPoints\": { \n" +
				"\t\t\"attempts\": " + BrPokusanoDvaPoena + ",\n" +
				"\t\t\"made\": " + BrPogodjenoDvaPoena + ",\n" +
				"\t\t\"shootingPercentage\": " + ProcenatZaDvaPoena + "\n" +
				"\t\t},\n" +
				"\t\"threePoints\": { \n" +
				"\t\t\"attempts\": " + BrPokusanoTriPoena + ",\n" +
				"\t\t\"made\": " + BrPogodjenoTriPoena + ",\n" +
				"\t\t\"shootingPercentage\": " + ProcenatZaTriPoena + "\n" +
				"\t\t},\n" +
				"\t\"points\": " + Poeni + ",\n" +
				"\t\"rebounds\": " + BrSkokova + ",\n" +
				"\t\"blocks\": " + BrBlokiranihSuteva + ",\n" +
				"\t\"assists\": " + BrAsistencija + ",\n" +
				"\t\"steals\": " + BrUkradenihLopti + ",\n" +
				"\t\"turnovers\": " + BrIzgubljenihLopti + ",\n" +
				"\t},\n" +
				"\"advanced\": \" " + "{\n" +
				"\t\"valorization\": " + IndeksUspesnosti + ",\n" +
				"\t\"effectiveFieldGoalPercentage\": " + EfektivniProcenatSuta + ",\n" +
				"\t\"trueShootingPercentage\": " + StvarniProcenatSuta + ",\n" +
				"\t\"hollingerAssistRatio\": " + HolingerovOdnosAsistencija + ",\n" +
				"\t}\n" +
				"}";
	}
	
}
