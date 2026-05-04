package project0.model;

import java.util.Objects;

import org.bson.codecs.pojo.annotations.BsonId;


public class Produto {

	@BsonId
	private String id;
	private String nome;
	private double prezo;
	
	public Produto() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezo() {
		return prezo;
	}
	public void setPrezo(double prezo) {
		this.prezo = prezo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", prezo=" + prezo + "]";
	}
	
	
}
