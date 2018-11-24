/*
 * https://www.decolar.com/shop/flights/results/oneway/CBR/GRU/2018-11-27/1/0/0/NA/NA/NA/NA?from=SB&di=1-0
 * De acordo com o site:
 * 
 * Ida 27/NOV/2018 CBR Canberra --->GRU São Paulo
 * 
 * 09:55 Canberra ---> 2 paradas ---> 18:55 São Paulo 22h
 */
package view;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

//Para testar a entrada e saída de dados, descomentar linha abaixo:
//import model.Viagem;

public class TempoVoo {
	public static void main(String[] args) {
		//Para testar a entrada e saída de dados, descomentar linha abaixo:
		//Viagem a = new Viagem();

		ZoneId saoPaulo = ZoneId.of("America/Sao_Paulo");
		ZoneId dubai = ZoneId.of("Asia/Dubai");
		ZoneId autralia = ZoneId.of("Australia/Sydney");
		
		//São Paulo - Dubai pela Emirates:
		LocalDateTime emSP = LocalDateTime.of(2018, Month.MAY, 26, 1, 25);
		LocalDateTime emDB = LocalDateTime.of(2018, Month.MAY, 26, 22, 55);
		
		ZonedDateTime saidaSP = ZonedDateTime.of(emSP, saoPaulo);
		ZonedDateTime chegadaDB = ZonedDateTime.of(emDB, dubai);
		
		Duration duracao = Duration.between(saidaSP, chegadaDB);
		System.out.println("Duração GRU - DXB pela Emirates: " + duracao);
		
		//São Paulo - Dubai pela Turkish:
		emSP = LocalDateTime.of(2018, Month.MAY, 26, 3, 15);
		emDB = LocalDateTime.of(2018, Month.MAY, 28, 0, 20);
		
		saidaSP = ZonedDateTime.of(emSP, saoPaulo);
		chegadaDB = ZonedDateTime.of(emDB, dubai);
		
		duracao = Duration.between(saidaSP, chegadaDB);
		System.out.println("Duração GRU - DXB pela Turkish: " + duracao);
		
		//Austrália - São Paulo pela Qantas:
		LocalDateTime emAU = LocalDateTime.of(2018, Month.NOVEMBER, 27, 9, 55);
		emSP = LocalDateTime.of(2018, Month.NOVEMBER, 27, 18, 55);
		
		ZonedDateTime saidaAU = ZonedDateTime.of(emAU, autralia);
		ZonedDateTime chegadaSP = ZonedDateTime.of(emSP, saoPaulo);
		
		duracao = Duration.between(saidaAU, chegadaSP);
		System.out.println("Duração CBR - GRU pela Qantas: " + duracao);
		
	}

}
