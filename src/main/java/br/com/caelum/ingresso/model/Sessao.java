package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

	@OneToMany(mappedBy = "sessao", fetch = FetchType.EAGER)
	private Set<Ingresso> ingressos = new HashSet<>();

	private BigDecimal preco;

	/**
	 * @deprecated apenas para o Hybernate
	 */
	public Sessao() {
		// TODO Auto-generated constructor stub
	}

	public Sessao(LocalTime horario, Filme filme, Sala sala) {
		this.horario = horario;
		this.sala = sala;
		this.filme = filme;
		this.preco = sala.getPreco().add(filme.getPreco());
	}

	public LocalDateTime getHorarioTermino() {
		LocalDate hoje = LocalDate.now();
		return this.horario.atDate(hoje).plusMinutes(
				this.filme.getDuracao().toMinutes());
	}

	public Map<String, List<Lugar>> getMapaDeLugares() {
		return sala.getMapaDeLugares();
	}

	// Criado por crtl+3 ggas

	public boolean isDisponivel(Lugar lugarSelecionado) {
		return ingressos.stream().map(Ingresso::getLugar)
				.noneMatch(lugar -> lugar.equals(lugarSelecionado));
	}

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

	public BigDecimal getPreco() {
		if (this.preco == null) {
			return BigDecimal.ZERO;
		}
		return preco.setScale(2, RoundingMode.HALF_UP);
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

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
