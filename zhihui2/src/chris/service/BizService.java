package chris.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import chris.biz.iAreaBiz;
import chris.biz.iBuletoothBiz;
import chris.biz.iGuideBiz;
import chris.biz.iGuidegroupBiz;
import chris.biz.iGuidemBiz;
import chris.biz.iGuidemdtBiz;
import chris.biz.iGuidemonitorBiz;
import chris.biz.iMemoryBiz;
import chris.biz.iMessageBiz;
import chris.biz.iSessionBiz;
import chris.biz.iSysScoreBiz;
import chris.biz.iTotalBiz;
import chris.biz.iUserBiz;
import chris.biz.iYoukemBiz;

@Service("BizService")
public class BizService {
	@Resource(name="UserBiz")
	private iUserBiz userBiz;
	@Resource(name="GuideBiz")
	private iGuideBiz guideBiz;
	@Resource(name="GuidemBiz")
	private iGuidemBiz guidemBiz;
	@Resource(name="YouKemBiz")
	private iYoukemBiz youkemBiz;
	@Resource(name="TotalBiz")
	private iTotalBiz totalBiz;
	@Resource(name="SessionBiz")
	private iSessionBiz sessionBiz;
	
	@Resource(name="MessageBiz")
	private iMessageBiz messageBiz;
	
	
	@Resource(name="SysScoreBiz")
	private iSysScoreBiz sysScoreBiz;
	@Resource(name="MemoryBiz")
	private iMemoryBiz memoryBiz;
	
	@Resource(name="GuidemdtBiz")
	private iGuidemdtBiz guidemdtBiz;
	
	@Resource(name="BuletoothBiz")
	private iBuletoothBiz buletoothBiz;
	
	
	@Resource(name="AreaBiz")
	private iAreaBiz areaBiz;
	
	@Resource(name="GuidegroupBiz")
	private iGuidegroupBiz guidegroupBiz;
	
	@Resource(name="GuidemonitorBiz")
	private iGuidemonitorBiz guidemonitorBiz;
	
	public iGuidemonitorBiz getGuidemonitorBiz() {
		return guidemonitorBiz;
	}
	public void setGuidemonitorBiz(iGuidemonitorBiz guidemonitorBiz) {
		this.guidemonitorBiz = guidemonitorBiz;
	}
	public iGuidegroupBiz getGuidegroupBiz() {
		return guidegroupBiz;
	}
	public void setGuidegroupBiz(iGuidegroupBiz guidegroupBiz) {
		this.guidegroupBiz = guidegroupBiz;
	}
	public iAreaBiz getAreaBiz() {
		return areaBiz;
	}
	public void setAreaBiz(iAreaBiz areaBiz) {
		this.areaBiz = areaBiz;
	}
	public iBuletoothBiz getBuletoothBiz() {
		return buletoothBiz;
	}
	public void setBuletoothBiz(iBuletoothBiz buletoothBiz) {
		this.buletoothBiz = buletoothBiz;
	}

	public iGuidemdtBiz getGuidemdtBiz() {
		return guidemdtBiz;
	}

	public void setGuidemdtBiz(iGuidemdtBiz guidemdtBiz) {
		this.guidemdtBiz = guidemdtBiz;
	}

	public iMemoryBiz getMemoryBiz() {
		return memoryBiz;
	}

	public void setMemoryBiz(iMemoryBiz memoryBiz) {
		this.memoryBiz = memoryBiz;
	}

	public iSysScoreBiz getSysScoreBiz() {
		return sysScoreBiz;
	}

	public void setSysScoreBiz(iSysScoreBiz sysScoreBiz) {
		this.sysScoreBiz = sysScoreBiz;
	}

	public iMessageBiz getMessageBiz() {
		return messageBiz;
	}

	public void setMessageBiz(iMessageBiz messageBiz) {
		this.messageBiz = messageBiz;
	}

	public iTotalBiz getTotalBiz() {
		return totalBiz;
	}

	public void setTotalBiz(iTotalBiz totalBiz) {
		this.totalBiz = totalBiz;
	}

	public iSessionBiz getSessionBiz() {
		return sessionBiz;
	}

	public void setSessionBiz(iSessionBiz sessionBiz) {
		this.sessionBiz = sessionBiz;
	}

	public iYoukemBiz getYoukemBiz() {
		return youkemBiz;
	}

	public void setYoukemBiz(iYoukemBiz youkemBiz) {
		this.youkemBiz = youkemBiz;
	}

	public iGuidemBiz getGuidemBiz() {
		return guidemBiz;
	}

	public void setGuidemBiz(iGuidemBiz guidemBiz) {
		this.guidemBiz = guidemBiz;
	}

	public iGuideBiz getGuideBiz() {
		return guideBiz;
	}

	public void setGuideBiz(iGuideBiz guideBiz) {
		this.guideBiz = guideBiz;
	}

	public iUserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(iUserBiz userBiz) {
		this.userBiz = userBiz;
	}

	
}
