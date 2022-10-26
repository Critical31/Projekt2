package com.jsfcourse.calc;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
//@SessionScoped
public class KredytBB {
	private Double kwota;
	private Integer okres;
	private Double procent;
	private Double rata;

	@Inject
	FacesContext ctx;

	

	public Double getKwota() {
		return kwota;
	}

	public void setKwota(Double kwota) {
		this.kwota = kwota;
	}

	public Integer getOkres() {
		return okres;
	}

	public void setOkres(Integer okres) {
		this.okres = okres;
	}

	public Double getProcent() {
		return procent;
	}

	public void setProcent(Double procent) {
		this.procent = procent;
	}

	public Double getRata() {
		return rata;
	}

	public void setRata(Double rata) {
		this.rata = rata;
	}

	public boolean obliczRate() {
		//try {
			//double x = Double.parseDouble(this.kwota);
			//double y = Double.parseDouble(this.okres);
			//double z = Double.parseDouble(this.procent);
			
			double w = ((kwota + (kwota * procent))/okres);

			rata = (double) (Math.round(w*100.0)/100.0);

			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacja wykonana poprawnie", null));
			return true;
		//} catch (Exception e) {
			//ctx.addMessage(null,
					//new FacesMessage(FacesMessage.SEVERITY_ERROR, "Błąd podczas przetwarzania parametrów", null));
			//return false;
		//}
	}

	
	public String oblicz() {
		if (obliczRate()) {
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Wynik: " + rata, null));
		}
		return null;
	}


	
}
