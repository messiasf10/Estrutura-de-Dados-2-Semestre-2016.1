package arvoreSplay;

/**
 * 
 * @author Messias D. P. de M. Filho
 *
 */

public class NoBinaria {

	public Integer chave;
	private NoBinaria noEsquerdo;
	private NoBinaria noDireito;

	public NoBinaria() {
	}

	public NoBinaria(Integer chave) {
		setChave(chave);
	}

	public NoBinaria(Integer chave, NoBinaria leftNode, NoBinaria rigthNode) {
		setChave(chave);
		setNoEsquerdo(leftNode);
		setNoDireito(rigthNode);
	}

	public void setChave(Integer chave) {
		this.chave = chave;
	}

	public Integer getChave() {
		return chave;
	}

	public void setNoEsquerdo(NoBinaria leftNode) {
		this.noEsquerdo = leftNode;
	}

	public NoBinaria getNoEsquerdo() {
		return noEsquerdo;
	}

	public void setNoDireito(NoBinaria rigthNode) {
		this.noDireito = rigthNode;
	}

	public NoBinaria getNoDireito() {
		return noDireito;
	}

	public String toString() {
		String retorno = (new StringBuilder(" ")).append(chave).append(" ").toString();
		return retorno;
	}

}
