package br.com.caelum.ingresso.model;

import java.time.LocalTime;

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
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}
// Criado por crtl+3 ggas
	
	public Integer getId() {
		return Id;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public Sala getSala() {
		return sala;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	

}
