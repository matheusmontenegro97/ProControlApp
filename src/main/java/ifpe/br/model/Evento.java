package ifpe.br.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoEvento;
	private Long codigoEmpresa;
	private Long codigoPromotor;
	private String titulo;
	private String imgEmpresa;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate data;
	private Endereco endereco;
	private Boolean eventoRealizado;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataRealizacaoEvento;
	private String imgEventoRealizado;
	private String longitude;
	private String latitude;

	public Long getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(Long codigoEvento) {
		this.codigoEvento = codigoEvento;
	}

	public Long getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(Long codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImgEmpresa() {
		return imgEmpresa;
	}

	public void setImgEmpresa(String imgEmpresa) {
		this.imgEmpresa = imgEmpresa;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getCodigoPromotor() {
		return codigoPromotor;
	}

	public void setCodigoPromotor(Long codigoPromotor) {
		this.codigoPromotor = codigoPromotor;
	}

	public Boolean getEventoRealizado() {
		return eventoRealizado;
	}

	public void setEventoRealizado(Boolean eventoRealizado) {
		this.eventoRealizado = eventoRealizado;
	}

	public LocalDate getDataRealizacaoEvento() {
		return dataRealizacaoEvento;
	}

	public void setDataRealizacaoEvento(LocalDate dataRealizacaoEvento) {
		this.dataRealizacaoEvento = dataRealizacaoEvento;
	}

	public String getImgEventoRealizado() {
		return imgEventoRealizado;
	}

	public void setImgEventoRealizado(String imgEventoRealizado) {
		this.imgEventoRealizado = imgEventoRealizado;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
