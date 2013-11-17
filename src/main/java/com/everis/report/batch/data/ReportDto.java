package com.everis.report.batch.data;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 
 * @author kmunizpe
 *
 */
@Component("reportDto")
public class ReportDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2610529867759627280L;
	private String modulo;
	private String entorno;
	private String batch;
	private String fecha;
	private String min;
	private String seg;
	private String script;
	private String fecha2;
	private String min2;
	private String seg2;
	private String RC;
	private String RC2;
	private String estado;
	private String tiempo;
	private String observaciones;
	private String cadena;
	
	
	
	
	public ReportDto(String modulo, String entorno, String batch, String fecha,
			String min, String seg, String script, String fecha2, String min2,
			String seg2, String rC, String rC2, String estado, String tiempo,
			String observaciones, String cadena) {
		super();
		this.modulo = modulo;
		this.entorno = entorno;
		this.batch = batch;
		this.fecha = fecha;
		this.min = min;
		this.seg = seg;
		this.script = script;
		this.fecha2 = fecha2;
		this.min2 = min2;
		this.seg2 = seg2;
		RC = rC;
		RC2 = rC2;
		this.estado = estado;
		this.tiempo = tiempo;
		this.observaciones = observaciones;
		this.cadena = cadena;
	}
	public ReportDto(){
		
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getEntorno() {
		return entorno;
	}
	public void setEntorno(String entorno) {
		this.entorno = entorno;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getRC() {
		return RC;
	}
	public void setRC(String rC) {
		RC = rC;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getSeg() {
		return seg;
	}

	public void setSeg(String seg) {
		this.seg = seg;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public String getFecha2() {
		return fecha2;
	}

	public void setFecha2(String fecha2) {
		this.fecha2 = fecha2;
	}

	public String getMin2() {
		return min2;
	}

	public void setMin2(String min2) {
		this.min2 = min2;
	}

	public String getSeg2() {
		return seg2;
	}

	public void setSeg2(String seg2) {
		this.seg2 = seg2;
	}

	public String getRC2() {
		return RC2;
	}

	public void setRC2(String rC2) {
		RC2 = rC2;
	}

}
