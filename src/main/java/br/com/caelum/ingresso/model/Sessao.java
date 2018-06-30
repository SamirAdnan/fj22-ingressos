package br.com.caelum.ingresso.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
public class Sessao {
	@Id
	@GeneratedValue
	private Integer Id;
	private LocalTime horario;
	
	@ManyToOne
	private Sala sala;
	@ManyToOne
	private Filme filme;

	/**
	 * @deprecated apenas para o Hybernate
	 */
	public Sessao() {
		// TODO Auto-generated constructor stub
	}
	
	public Sessao (LocalTime horario, Filme filme, Sala sala){
		this.horario = horario;
		this.sala = sala;
		this.filme = filme;
	}
	
	public LocalDateTime getHorarioTermino () {
		LocalDate hoje = LocalDate.now();
		return this.horario.atDate(hoje).plusMinutes(this.filme.getDuracao().toMinutes());
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
