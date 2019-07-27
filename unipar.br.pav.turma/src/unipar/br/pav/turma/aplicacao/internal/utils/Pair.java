package unipar.br.pav.turma.aplicacao.internal.utils;

import static java.lang.String.format;

/**
 * Classe utilizada em lugares onde é usada execução assíncrona e a comunição
 * entre os Threads deve ser feita utilizando somente valores <code>final</code>.
 * @author Roberto Filho
 *
 * @param <L> - o esquerdista.
 * @param <R> - o direitista.
 */
public class Pair<L, R> {

	private L left;
	private R right;

	public Pair() {}
	
	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}
	
	public void setLeft(L left) {
		this.left = left;
	}
	
	public void setRight(R right) {
		this.right = right;
	}
	
	public void setBoth(L left, R right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}
	
	/**
	 * Retorna um par com os objetos informados. Método de utilidade.
	 * @param left - o objeto 1.
	 * @param right - o objeto 2.
	 * @return
	 */
	public static <L, R> Pair<L, R> create(L left, R right) {
		return new Pair<L, R>(left, right);
	}
	
	public static <L, R> Pair<L, R> create() {
		return new Pair<L, R>();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o instanceof ImmutablePair){
			// Não tem como fazer de uma maneira que usa generics, portanto é utilizada a anotação @SupressWarnings
			ImmutablePair pairo = (ImmutablePair) o;
			return this.left.equals(pairo.getLeft()) && this.right.equals(pairo.getRight());
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		return format("[%s, %s]", String.valueOf(left.toString()), String.valueOf(right.toString()));
	}

}
