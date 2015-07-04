package contest.domain;

import contest.ui.graphic.action.BusinessException;

public class WithProtocol extends Status {
	
	public WithProtocol(String status, String justification, String type) throws BusinessException {
		super(status, justification);
		if(type.contains("aprovado"))
			statusType = Type.APROVADO;
		else if (type.contains("reprovado"))
			statusType = Type.REPROVADO;
		else
			throw new BusinessException("bad status type");
	}
	
	private enum Type { APROVADO, REPROVADO };
	private Type statusType;
	
	public String getStatusType() {
		return statusType.toString();
	}
}
