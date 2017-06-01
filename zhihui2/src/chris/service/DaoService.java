package chris.service;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import chris.dao.AreaDAO;
import chris.dao.BuletoothDAO;
import chris.dao.GuideDAO;
import chris.dao.GuidegroupDAO;
import chris.dao.GuidemDAO;
import chris.dao.GuidemdtDAO;
import chris.dao.GuidemonitorDAO;
import chris.dao.MemoryDAO;
import chris.dao.MessageDAO;
import chris.dao.SessionDAO;
import chris.dao.SystemscoreDAO;
import chris.dao.TotalDAO;
import chris.dao.UserDAO;
import chris.dao.YoukemDAO;

@Service("DaoService")
public class DaoService {
		@Resource(name="GuideDAO")
		private GuideDAO gdao;
		@Resource(name="GuidemDAO")
		private GuidemDAO gmdao;
		@Resource(name="UserDAO")
		private UserDAO udao;
		@Resource(name="YoukemDAO")
		private YoukemDAO youkeDao;
		@Resource(name="TotalDAO")
		private TotalDAO totalDao;
		@Resource(name="SessionDAO")
		private SessionDAO sessionDao;
		@Resource(name="MessageDAO")
		private MessageDAO messageDao; 
		@Resource(name="SystemscoreDAO")
		private SystemscoreDAO systemScoreDao;
		@Resource(name="MemoryDAO")
		private MemoryDAO memoryDao;
		@Resource(name="GuidemdtDAO")
		private GuidemdtDAO guidemdtDAO;
		@Resource(name="BuletoothDAO")
		private BuletoothDAO buletoothDAO;
		@Resource(name="AreaDAO")
		private AreaDAO areaDAO;
		
		@Resource(name="GuidemonitorDAO")
		private GuidemonitorDAO guidemonitorDAO;
		
		@Resource(name="GuidegroupDAO")
		private GuidegroupDAO guidegroup;
		
		public GuidemonitorDAO getGuidemonitorDAO() {
			return guidemonitorDAO;
		}
		public void setGuidemonitorDAO(GuidemonitorDAO guidemonitorDAO) {
			this.guidemonitorDAO = guidemonitorDAO;
		}
		public GuidegroupDAO getGuidegroup() {
			return guidegroup;
		}
		public void setGuidegroup(GuidegroupDAO guidegroup) {
			this.guidegroup = guidegroup;
		}
		public AreaDAO getAreaDAO() {
			return areaDAO;
		}
		public void setAreaDAO(AreaDAO areaDAO) {
			this.areaDAO = areaDAO;
		}
		public BuletoothDAO getBuletoothDAO() {
			return buletoothDAO;
		}
		public void setBuletoothDAO(BuletoothDAO buletoothDAO) {
			this.buletoothDAO = buletoothDAO;
		}
		public GuidemdtDAO getGuidemdtDAO() {
			return guidemdtDAO;
		}
		public void setGuidemdtDAO(GuidemdtDAO guidemdtDAO) {
			this.guidemdtDAO = guidemdtDAO;
		}
		public MemoryDAO getMemoryDao() {
			return memoryDao;
		}
		public void setMemoryDao(MemoryDAO memoryDao) {
			this.memoryDao = memoryDao;
		}
		public SystemscoreDAO getSystemScoreDao() {
			return systemScoreDao;
		}
		public void setSystemScoreDao(SystemscoreDAO systemScoreDao) {
			this.systemScoreDao = systemScoreDao;
		}
		public MessageDAO getMessageDao() {
			return messageDao;
		}
		public void setMessageDao(MessageDAO messageDao) {
			this.messageDao = messageDao;
		}
		public SessionDAO getSessionDao() {
			return sessionDao;
		}
		public void setSessionDao(SessionDAO sessionDao) {
			this.sessionDao = sessionDao;
		}
		public TotalDAO getTotalDao() {
			return totalDao;
		}
		public void setTotalDao(TotalDAO totalDao) {
			this.totalDao = totalDao;
		}
		public YoukemDAO getYoukeDao() {
			return youkeDao;
		}
		public void setYoukeDao(YoukemDAO youkeDao) {
			this.youkeDao = youkeDao;
		}
		public GuideDAO getGdao() {
			return gdao;
		}
		public void setGdao(GuideDAO gdao) {
			this.gdao = gdao;
		}
		public GuidemDAO getGmdao() {
			return gmdao;
		}
		public void setGmdao(GuidemDAO gmdao) {
			this.gmdao = gmdao;
		}
		public UserDAO getUdao() {
			return udao;
		}
		public void setUdao(UserDAO udao) {
			this.udao = udao;
		}
}
