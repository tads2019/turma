package unipar.br.pav.turma.aplicacao.enums;

/**
 * Enum de exemplo
 * 
 * @author Prof. Filipe Wutzke
 */
public enum SexoEnum {
	
	MASCULINO("M", "Masculino"),
	FEMININO("F", "Feminino"),
	BISEXUAL("B", "Bisexual"),
	CARLOS("A", "Andrógino"),
	BIGENERO("2", "Bigênero"),
	TRANSSEXUAL("T", "Transsexual");
	
	private SexoEnum(String sigla, String descricao){
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
