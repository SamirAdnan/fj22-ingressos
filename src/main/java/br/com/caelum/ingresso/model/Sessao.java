package br.com.caelum.ingresso.model;

public class Sessao {
	private Integer Id;
	private LocalTime horario;
	private Sala sala;
	private Filme filme;
	
	public Sessao (LocalTime horario, Filme filme, Sala sala){
		this.horario = horario;
		this.sala = sala;
		this.filme = filme;
	}
	
	public LocalTime getHorarioTermino (){
		return this.horario.PlusMinutes(filme.getDuracao().toMinutes())
	}


}
