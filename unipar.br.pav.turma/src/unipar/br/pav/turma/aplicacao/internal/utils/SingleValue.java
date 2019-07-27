package unipar.br.pav.turma.aplicacao.internal.utils;

/**
 * Possui a mesma utilidade da classe {@link Pair}, com a diferença
 * que contém somente um valor.
 * @author Roberto Filho
 *
 * @param <T>
 */
public class SingleValue<T> {
	private T theValue;
	
	private SingleValue(T value) {
		super();
		this.theValue = value;
	}

	public T get() {
		return theValue;
	}
	
	public void set(T value) {
		this.theValue = value;
	}
	
	public boolean isPresent() {
		return theValue != null;
	}
	
	public static final <T> SingleValue<T> create() {
		return create(null);
	}
	
	public static final <T> SingleValue<T> create(T obj) {
		return new SingleValue<T>(obj);
	}
}
