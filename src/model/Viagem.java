/*
 *Teste:
 *	Ida: 27/11/2018 - 09:55 
 *	Australia/Sydney
 *
 *	Chegada: 27/11/2018 - 18:55
 *	America/Sao_Paulo
 */
package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Viagem {
	private String dadosSaida;
	private String localSaida;
	private String dadosChegada;
	private String localChegada;
	private Duration duracao;
	
	Scanner input = new Scanner(System.in);
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
	
	public Viagem(){
		criaIda();
		criaChegada();
		calculaDuracao();
	}
	
	private void criaIda() {
		System.out.println("Data e hora de ida no formato dd/MM/yyyy - HH:mm: ");
		this.dadosSaida = input.nextLine();
		
		System.out.println("Local de partida por Time Zone (ex: America/Sao_Paulo):");
		this.localSaida = input.nextLine();
	}
	
	private void criaChegada() {
		System.out.println("Data e hora de volta no formato dd/MM/yyyy - HH:mm: ");
		this.dadosChegada = input.nextLine();
		
		System.out.println("Local de chegada por Time Zone (ex: America/Sao_Paulo):");
		this.localChegada = input.nextLine();
	}
	
	private void calculaDuracao() {
		try {
			ZoneId zonaSaida = ZoneId.of(this.localSaida);
			ZoneId zonaChegada = ZoneId.of(this.localChegada);

			LocalDateTime localDateSaida = LocalDateTime.parse(dadosSaida, dateFormatter);
			LocalDateTime localDateChegada = LocalDateTime.parse(dadosChegada, dateFormatter);
				
			ZonedDateTime saida = ZonedDateTime.of(localDateSaida, zonaSaida);
			ZonedDateTime chegada = ZonedDateTime.of(localDateChegada, zonaChegada);
				
			duracao = Duration.between(saida, chegada);
			System.out.println("Duração da viagem: " + duracao);
		} catch (Exception e) {
			System.out.println("Dados inseridos incorretamente, tente novamente!!");
			e.printStackTrace();
		}
	}
}
