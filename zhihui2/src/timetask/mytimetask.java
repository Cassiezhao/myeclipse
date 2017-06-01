package timetask;

import javax.annotation.Resource;

import chris.service.BizService;

public class mytimetask {
	@Resource(name = "BizService")
	private BizService bizService;

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	
}
