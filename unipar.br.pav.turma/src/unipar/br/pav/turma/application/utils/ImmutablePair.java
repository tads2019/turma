package unipar.br.pav.turma.application.utils;

public class ImmutablePair<L, R> {

	private final L left;
	private final R right;

	public ImmutablePair(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}

	@Override
	public int hashCode() {
		return left.hashCode() ^ right.hashCode();
	}
	
	/**
	 * Retorna um par com os objetos informados. Método de utilidade.
	 * @param left - o objeto 1.
	 * @param right - o objeto 2.
	 * @return
	 */
	public static <L, R> ImmutablePair<L, R> create(L left, R right) {
		return new ImmutablePair<L, R>(left, right);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof ImmutablePair))
			return false;
		// Não tem como fazer de uma maneira que usa generics, portanto é utilizada a anotação @SupressWarnings
		ImmutablePair pairo = (ImmutablePair) o;
		return this.left.equals(pairo.getLeft()) && this.right.equals(pairo.getRight());
	}

}