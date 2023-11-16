package com.example.L9.basket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AfrickaReprezentacija {

	private ArrayList<Igrac> igraci;

	public AfrickaReprezentacija() {
		super();
		this.igraci = new ArrayList<>();
		ucitajIgrace("src/main/resources/L9HomeworkChallengePlayersInput.csv");
		statistikaReprezentacije();
	}

	public void ucitajIgrace(String imeFajla) {
		String linija = "";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(imeFajla));
			linija = br.readLine();
			while ((linija = br.readLine()) != null) {
				String[] rez = linija.split(",");
				String ime = rez[0].trim();
				String poz = rez[1].trim();
				double bacanjaPogodjeno = Double.parseDouble(rez[2].trim());
				double bacanjaPokusano = Double.parseDouble(rez[3].trim());
				double dvaPoenaPogodjeno = Double.parseDouble(rez[4].trim());
				double dvaPoenaPokusano = Double.parseDouble(rez[5].trim());
				double triPoenaPogodjeno = Double.parseDouble(rez[6].trim());
				double triPoenaPokusano = Double.parseDouble(rez[7].trim());
				double skokovi = Double.parseDouble(rez[8].trim());
				double blokovi = Double.parseDouble(rez[9].trim());
				double asistencije = Double.parseDouble(rez[10].trim());
				double ukradene = Double.parseDouble(rez[11].trim());
				double izgubljene = Double.parseDouble(rez[12].trim());
				int indexIgraca = postojiIgrac(ime);
				if (indexIgraca == -1) {
					Igrac trenutni = new Igrac(ime, poz, bacanjaPogodjeno, bacanjaPokusano, dvaPoenaPogodjeno,
							dvaPoenaPokusano, triPoenaPogodjeno, triPoenaPokusano, skokovi, blokovi, asistencije,
							ukradene, izgubljene);
					igraci.add(trenutni);
				} else {
					igraci.get(indexIgraca).ponovnaPojava(bacanjaPogodjeno, bacanjaPokusano, dvaPoenaPogodjeno,
							dvaPoenaPokusano, triPoenaPogodjeno, triPoenaPokusano, skokovi, blokovi, asistencije,
							ukradene, izgubljene);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException IOE) {
					IOE.printStackTrace();
				}
			}
		}

	}

	public int postojiIgrac(String igrac) {
		for (int i = 0; i < igraci.size(); i++) {
			if (igraci.get(i).getIme().equals(igrac)) {
				return i;
			}
		}
		return -1;
	}
	
	public Igrac vratiIgraca(String igrac) {
		for (int i = 0; i < igraci.size(); i++) {
			String punoIme = igraci.get(i).getIme().split(" ")[0] + igraci.get(i).getIme().split(" ")[1];
			if (punoIme.equals(igrac)) {
				return igraci.get(i);
			}
		}
		return null;
	}
	
	public void statistikaReprezentacije() {
		for (Igrac i : igraci) {
			i.izracunajStatistikuIgraca();
			i.izvedeneStatistike();
		}
	}
}
