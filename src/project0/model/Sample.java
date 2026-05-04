package project0.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Sample {

	private String id;
	private Double weight;
	private LocalDateTime collectDateTime;
	
	public Sample() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public LocalDateTime getCollectDateTime() {
		return collectDateTime;
	}
	public void setCollectDateTime(LocalDateTime collectDateTime) {
		this.collectDateTime = collectDateTime;
	}
	@Override
	public int hashCode() {
		return Objects.hash(collectDateTime, id, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sample other = (Sample) obj;
		return Objects.equals(collectDateTime, other.collectDateTime) && Objects.equals(id, other.id)
				&& Objects.equals(weight, other.weight);
	}
	@Override
	public String toString() {
		return "Sample [id=" + id + ", weight=" + weight + ", collectDateTime=" + collectDateTime + "]";
	}
	
	
}
