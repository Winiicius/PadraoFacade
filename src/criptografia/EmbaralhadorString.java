package criptografia;

import java.util.Calendar;

public class EmbaralhadorString {

	private String stringBase;

	private String chaveEmbaralhamento;

	private boolean horarioSistema;

	public EmbaralhadorString(String stringBase) {
		this.stringBase = stringBase;
	}

	public void adicionarHorarioDoSistema() {
		this.horarioSistema = true;
	}

	public void removerHorarioDoSistema() {
		this.horarioSistema = false;
	}

	public void adicionarChaveDeEmbaralhamento(String chaveEmbaralhamento) {
		this.chaveEmbaralhamento = chaveEmbaralhamento;
	}

	public void removerChaveDeEmbaralhamento() {
		this.chaveEmbaralhamento = null;
	}

	@Override
	public String toString() {
		return embaralhar();
	}

	public String embaralhar() {

		StringBuffer strBuffer = new StringBuffer();

		if (this.horarioSistema)
			strBuffer.append(Calendar.getInstance().getTimeInMillis());
		if (this.chaveEmbaralhamento != null)
			strBuffer.append(this.chaveEmbaralhamento);
		strBuffer.append(this.stringBase);

		return strBuffer.toString();
	}
}
