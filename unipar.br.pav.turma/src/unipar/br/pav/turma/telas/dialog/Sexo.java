package unipar.br.pav.turma.telas.dialog;

public enum Sexo {
	
	MASCULINO("M", "Masculino"),
	FEMININO("F", "Feminino"),
	BISEXUAL("B", "Bisexual"),
	ANDRÓGINO("A", "Andrógino"),
	BIGENERO("2", "Bigênero"),
	TRANSSEXUAL("T", "Transsexual");
	
	private Sexo(String sigla, String descricao){
		this.sigla = sigla;
		this.descricao = descricao;
	}
	
	private String sigla;
	private String descricao;
	
	public String getSigla() {
		return sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
