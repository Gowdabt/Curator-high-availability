/**
 * 
 */
package com.infinera.dna.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Harshith Gowda B T
 *
 */
@Entity
@Table(name="alert")
public class Alert  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 6804933315087595099L;
	private Integer id;
     private int lockversion;
     private String groupname;
     private String category;
     private Integer severity;
     private Integer previousseverity;
     private String entity;
     private Long createtime;
     private Long modtime;
     private String mmessage;
     private String source;
     private String mapname;
     private String who;
     private Integer stage;
     private String webnms;
     private String ownername;
     private String elocation;
     private String epcause;
     private String edirection;
     private String etype;
     private String esubtype;
     private String elogtype;
     private String serviceaffecting;
     private String eadditionaltext;
     private Integer elogid;
     private Long alarmcorrelationid;
     private Integer aggsentryid;
     private Integer notificationid;
     private String chassisid;
     private String nodeid;
     private String faultaid;
     private String motype;
     private String acktext;
     private String ackuser;
     private Long acktime;
     private String nodename;
     private String nodelabel;
     private Long eventreceivedtime;
     private String currentvaluetce;
     private String currentthresholdtce;
     private String uniquecode;
     private String faultconditions;
     private String inputparamlist;
     private Integer priority;
     private String circuitid;
     private Integer nodenumber;
     private int outstanding;
     private Integer netypenumber;
     private String userinformation;
     private String duserinformation;
     private String objectname;
     private String layerrate;
     private String discoveredname;
     private String rdnsource;
     private String customdescription;
     private String sourcelabel;

    public Alert() {
    }

	
    public Alert(int lockversion, int outstanding) {
        this.lockversion = lockversion;
        this.outstanding = outstanding;
    }
    public Alert(int lockversion, String groupname, String category, Integer severity, Integer previousseverity, String entity, Long createtime, Long modtime, String mmessage, String source, String mapname, String who, Integer stage, String webnms, String ownername, String elocation, String epcause, String edirection, String etype, String esubtype, String elogtype, String serviceaffecting, String eadditionaltext, Integer elogid, Long alarmcorrelationid, Integer aggsentryid, Integer notificationid, String chassisid, String nodeid, String faultaid, String motype, String acktext, String ackuser, Long acktime, String nodename, String nodelabel, Long eventreceivedtime, String currentvaluetce, String currentthresholdtce, String uniquecode, String faultconditions, String inputparamlist, Integer priority, String circuitid, Integer nodenumber, int outstanding, Integer netypenumber, String userinformation, String duserinformation, String objectname, String layerrate, String discoveredname, String rdnsource, String customdescription, String sourcelabel) {
       this.lockversion = lockversion;
       this.groupname = groupname;
       this.category = category;
       this.severity = severity;
       this.previousseverity = previousseverity;
       this.entity = entity;
       this.createtime = createtime;
       this.modtime = modtime;
       this.mmessage = mmessage;
       this.source = source;
       this.mapname = mapname;
       this.who = who;
       this.stage = stage;
       this.webnms = webnms;
       this.ownername = ownername;
       this.elocation = elocation;
       this.epcause = epcause;
       this.edirection = edirection;
       this.etype = etype;
       this.esubtype = esubtype;
       this.elogtype = elogtype;
       this.serviceaffecting = serviceaffecting;
       this.eadditionaltext = eadditionaltext;
       this.elogid = elogid;
       this.alarmcorrelationid = alarmcorrelationid;
       this.aggsentryid = aggsentryid;
       this.notificationid = notificationid;
       this.chassisid = chassisid;
       this.nodeid = nodeid;
       this.faultaid = faultaid;
       this.motype = motype;
       this.acktext = acktext;
       this.ackuser = ackuser;
       this.acktime = acktime;
       this.nodename = nodename;
       this.nodelabel = nodelabel;
       this.eventreceivedtime = eventreceivedtime;
       this.currentvaluetce = currentvaluetce;
       this.currentthresholdtce = currentthresholdtce;
       this.uniquecode = uniquecode;
       this.faultconditions = faultconditions;
       this.inputparamlist = inputparamlist;
       this.priority = priority;
       this.circuitid = circuitid;
       this.nodenumber = nodenumber;
       this.outstanding = outstanding;
       this.netypenumber = netypenumber;
       this.userinformation = userinformation;
       this.duserinformation = duserinformation;
       this.objectname = objectname;
       this.layerrate = layerrate;
       this.discoveredname = discoveredname;
       this.rdnsource = rdnsource;
       this.customdescription = customdescription;
       this.sourcelabel = sourcelabel;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="LOCKVERSION", nullable=false)
    public int getLockversion() {
        return this.lockversion;
    }
    
    public void setLockversion(int lockversion) {
        this.lockversion = lockversion;
    }

    
    @Column(name="GROUPNAME", length=100)
    public String getGroupname() {
        return this.groupname;
    }
    
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    
    @Column(name="CATEGORY", length=100)
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }

    
    @Column(name="SEVERITY")
    public Integer getSeverity() {
        return this.severity;
    }
    
    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    
    @Column(name="PREVIOUSSEVERITY")
    public Integer getPreviousseverity() {
        return this.previousseverity;
    }
    
    public void setPreviousseverity(Integer previousseverity) {
        this.previousseverity = previousseverity;
    }

    
    @Column(name="ENTITY", length=500)
    public String getEntity() {
        return this.entity;
    }
    
    public void setEntity(String entity) {
        this.entity = entity;
    }

    
    @Column(name="CREATETIME")
    public Long getCreatetime() {
        return this.createtime;
    }
    
    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    
    @Column(name="MODTIME")
    public Long getModtime() {
        return this.modtime;
    }
    
    public void setModtime(Long modtime) {
        this.modtime = modtime;
    }

    
    @Column(name="MMESSAGE", length=65535)
    public String getMmessage() {
        return this.mmessage;
    }
    
    public void setMmessage(String mmessage) {
        this.mmessage = mmessage;
    }

    
    @Column(name="SOURCE")
    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }

    
    @Column(name="MAPNAME", length=100)
    public String getMapname() {
        return this.mapname;
    }
    
    public void setMapname(String mapname) {
        this.mapname = mapname;
    }

    
    @Column(name="WHO", length=100)
    public String getWho() {
        return this.who;
    }
    
    public void setWho(String who) {
        this.who = who;
    }

    
    @Column(name="STAGE")
    public Integer getStage() {
        return this.stage;
    }
    
    public void setStage(Integer stage) {
        this.stage = stage;
    }

    
    @Column(name="WEBNMS", length=100)
    public String getWebnms() {
        return this.webnms;
    }
    
    public void setWebnms(String webnms) {
        this.webnms = webnms;
    }

    
    @Column(name="OWNERNAME", length=50)
    public String getOwnername() {
        return this.ownername;
    }
    
    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    
    @Column(name="ELOCATION", length=100)
    public String getElocation() {
        return this.elocation;
    }
    
    public void setElocation(String elocation) {
        this.elocation = elocation;
    }

    
    @Column(name="EPCAUSE")
    public String getEpcause() {
        return this.epcause;
    }
    
    public void setEpcause(String epcause) {
        this.epcause = epcause;
    }

    
    @Column(name="EDIRECTION", length=100)
    public String getEdirection() {
        return this.edirection;
    }
    
    public void setEdirection(String edirection) {
        this.edirection = edirection;
    }

    
    @Column(name="ETYPE", length=100)
    public String getEtype() {
        return this.etype;
    }
    
    public void setEtype(String etype) {
        this.etype = etype;
    }

    
    @Column(name="ESUBTYPE", length=100)
    public String getEsubtype() {
        return this.esubtype;
    }
    
    public void setEsubtype(String esubtype) {
        this.esubtype = esubtype;
    }

    
    @Column(name="ELOGTYPE", length=100)
    public String getElogtype() {
        return this.elogtype;
    }
    
    public void setElogtype(String elogtype) {
        this.elogtype = elogtype;
    }

    
    @Column(name="SERVICEAFFECTING", length=10)
    public String getServiceaffecting() {
        return this.serviceaffecting;
    }
    
    public void setServiceaffecting(String serviceaffecting) {
        this.serviceaffecting = serviceaffecting;
    }

    
    @Column(name="EADDITIONALTEXT", length=65535)
    public String getEadditionaltext() {
        return this.eadditionaltext;
    }
    
    public void setEadditionaltext(String eadditionaltext) {
        this.eadditionaltext = eadditionaltext;
    }

    
    @Column(name="ELOGID")
    public Integer getElogid() {
        return this.elogid;
    }
    
    public void setElogid(Integer elogid) {
        this.elogid = elogid;
    }

    
    @Column(name="ALARMCORRELATIONID")
    public Long getAlarmcorrelationid() {
        return this.alarmcorrelationid;
    }
    
    public void setAlarmcorrelationid(Long alarmcorrelationid) {
        this.alarmcorrelationid = alarmcorrelationid;
    }

    
    @Column(name="AGGSENTRYID")
    public Integer getAggsentryid() {
        return this.aggsentryid;
    }
    
    public void setAggsentryid(Integer aggsentryid) {
        this.aggsentryid = aggsentryid;
    }

    
    @Column(name="NOTIFICATIONID")
    public Integer getNotificationid() {
        return this.notificationid;
    }
    
    public void setNotificationid(Integer notificationid) {
        this.notificationid = notificationid;
    }

    
    @Column(name="CHASSISID")
    public String getChassisid() {
        return this.chassisid;
    }
    
    public void setChassisid(String chassisid) {
        this.chassisid = chassisid;
    }

    
    @Column(name="NODEID")
    public String getNodeid() {
        return this.nodeid;
    }
    
    public void setNodeid(String nodeid) {
        this.nodeid = nodeid;
    }

    
    @Column(name="FAULTAID")
    public String getFaultaid() {
        return this.faultaid;
    }
    
    public void setFaultaid(String faultaid) {
        this.faultaid = faultaid;
    }

    
    @Column(name="MOTYPE")
    public String getMotype() {
        return this.motype;
    }
    
    public void setMotype(String motype) {
        this.motype = motype;
    }

    
    @Column(name="ACKTEXT", length=65535)
    public String getAcktext() {
        return this.acktext;
    }
    
    public void setAcktext(String acktext) {
        this.acktext = acktext;
    }

    
    @Column(name="ACKUSER", length=256)
    public String getAckuser() {
        return this.ackuser;
    }
    
    public void setAckuser(String ackuser) {
        this.ackuser = ackuser;
    }

    
    @Column(name="ACKTIME")
    public Long getAcktime() {
        return this.acktime;
    }
    
    public void setAcktime(Long acktime) {
        this.acktime = acktime;
    }

    
    @Column(name="NODENAME")
    public String getNodename() {
        return this.nodename;
    }
    
    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    
    @Column(name="NODELABEL")
    public String getNodelabel() {
        return this.nodelabel;
    }
    
    public void setNodelabel(String nodelabel) {
        this.nodelabel = nodelabel;
    }

    
    @Column(name="EVENTRECEIVEDTIME")
    public Long getEventreceivedtime() {
        return this.eventreceivedtime;
    }
    
    public void setEventreceivedtime(Long eventreceivedtime) {
        this.eventreceivedtime = eventreceivedtime;
    }

    
    @Column(name="CURRENTVALUETCE")
    public String getCurrentvaluetce() {
        return this.currentvaluetce;
    }
    
    public void setCurrentvaluetce(String currentvaluetce) {
        this.currentvaluetce = currentvaluetce;
    }

    
    @Column(name="CURRENTTHRESHOLDTCE")
    public String getCurrentthresholdtce() {
        return this.currentthresholdtce;
    }
    
    public void setCurrentthresholdtce(String currentthresholdtce) {
        this.currentthresholdtce = currentthresholdtce;
    }

    
    @Column(name="UNIQUECODE", length=250)
    public String getUniquecode() {
        return this.uniquecode;
    }
    
    public void setUniquecode(String uniquecode) {
        this.uniquecode = uniquecode;
    }

    
    @Column(name="FAULTCONDITIONS", length=65535)
    public String getFaultconditions() {
        return this.faultconditions;
    }
    
    public void setFaultconditions(String faultconditions) {
        this.faultconditions = faultconditions;
    }

    
    @Column(name="INPUTPARAMLIST", length=65535)
    public String getInputparamlist() {
        return this.inputparamlist;
    }
    
    public void setInputparamlist(String inputparamlist) {
        this.inputparamlist = inputparamlist;
    }

    
    @Column(name="PRIORITY")
    public Integer getPriority() {
        return this.priority;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    
    @Column(name="CIRCUITID", length=65535)
    public String getCircuitid() {
        return this.circuitid;
    }
    
    public void setCircuitid(String circuitid) {
        this.circuitid = circuitid;
    }

    
    @Column(name="NODENUMBER")
    public Integer getNodenumber() {
        return this.nodenumber;
    }
    
    public void setNodenumber(Integer nodenumber) {
        this.nodenumber = nodenumber;
    }

    
    @Column(name="OUTSTANDING", nullable=false)
    public int getOutstanding() {
        return this.outstanding;
    }
    
    public void setOutstanding(int outstanding) {
        this.outstanding = outstanding;
    }

    
    @Column(name="NETYPENUMBER")
    public Integer getNetypenumber() {
        return this.netypenumber;
    }
    
    public void setNetypenumber(Integer netypenumber) {
        this.netypenumber = netypenumber;
    }

    
    @Column(name="USERINFORMATION")
    public String getUserinformation() {
        return this.userinformation;
    }
    
    public void setUserinformation(String userinformation) {
        this.userinformation = userinformation;
    }

    
    @Column(name="DUSERINFORMATION")
    public String getDuserinformation() {
        return this.duserinformation;
    }
    
    public void setDuserinformation(String duserinformation) {
        this.duserinformation = duserinformation;
    }

    
    @Column(name="OBJECTNAME")
    public String getObjectname() {
        return this.objectname;
    }
    
    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    
    @Column(name="LAYERRATE")
    public String getLayerrate() {
        return this.layerrate;
    }
    
    public void setLayerrate(String layerrate) {
        this.layerrate = layerrate;
    }

    
    @Column(name="DISCOVEREDNAME")
    public String getDiscoveredname() {
        return this.discoveredname;
    }
    
    public void setDiscoveredname(String discoveredname) {
        this.discoveredname = discoveredname;
    }

    
    @Column(name="RDNSOURCE")
    public String getRdnsource() {
        return this.rdnsource;
    }
    
    public void setRdnsource(String rdnsource) {
        this.rdnsource = rdnsource;
    }

    
    @Column(name="CUSTOMDESCRIPTION", length=128)
    public String getCustomdescription() {
        return this.customdescription;
    }
    
    public void setCustomdescription(String customdescription) {
        this.customdescription = customdescription;
    }

    
    @Column(name="SOURCELABEL", length=128)
    public String getSourcelabel() {
        return this.sourcelabel;
    }
    
    public void setSourcelabel(String sourcelabel) {
        this.sourcelabel = sourcelabel;
    }

    @Override
    public String toString() {
        return "Alert{" + "id=" + id + ", lockversion=" + lockversion + ", groupname=" + groupname + ", category=" + category + ", severity=" + severity + ", previousseverity=" + previousseverity + ", entity=" + entity + ", createtime=" + createtime + ", modtime=" + modtime + ", mmessage=" + mmessage + ", source=" + source + ", mapname=" + mapname + ", who=" + who + ", stage=" + stage + ", webnms=" + webnms + ", ownername=" + ownername + ", elocation=" + elocation + ", epcause=" + epcause + ", edirection=" + edirection + ", etype=" + etype + ", esubtype=" + esubtype + ", elogtype=" + elogtype + ", serviceaffecting=" + serviceaffecting + ", eadditionaltext=" + eadditionaltext + ", elogid=" + elogid + ", alarmcorrelationid=" + alarmcorrelationid + ", aggsentryid=" + aggsentryid + ", notificationid=" + notificationid + ", chassisid=" + chassisid + ", nodeid=" + nodeid + ", faultaid=" + faultaid + ", motype=" + motype + ", acktext=" + acktext + ", ackuser=" + ackuser + ", acktime=" + acktime + ", nodename=" + nodename + ", nodelabel=" + nodelabel + ", eventreceivedtime=" + eventreceivedtime + ", currentvaluetce=" + currentvaluetce + ", currentthresholdtce=" + currentthresholdtce + ", uniquecode=" + uniquecode + ", faultconditions=" + faultconditions + ", inputparamlist=" + inputparamlist + ", priority=" + priority + ", circuitid=" + circuitid + ", nodenumber=" + nodenumber + ", outstanding=" + outstanding + ", netypenumber=" + netypenumber + ", userinformation=" + userinformation + ", duserinformation=" + duserinformation + ", objectname=" + objectname + ", layerrate=" + layerrate + ", discoveredname=" + discoveredname + ", rdnsource=" + rdnsource + ", customdescription=" + customdescription + ", sourcelabel=" + sourcelabel + '}';
    }

}