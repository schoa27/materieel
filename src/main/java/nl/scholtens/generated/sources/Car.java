//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.03.12 at 02:28:51 PM CET 
//


package nl.scholtens.generated.sources;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}fundef" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="V_cru_hint" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="V_max" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="V_max_hint" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="V_max_loaded" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="V_mid_hint" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="V_min_hint" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="addr" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="bus" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="catnr" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="color" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="commuter" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="dectype" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="desc" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="docu" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="era" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="f0vcmd" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="fnlights" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="home" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="ident" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="iid" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="image" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="invdir" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="len" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="location" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="manuid" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="maxloadweight" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="number" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="owner" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="placing" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="prev_id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="prev_ori" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="prev_x" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="prev_y" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="prevlocation1" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="prevlocation2" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="prevlocation3" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="prot" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="protver" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="purchased" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="identifier" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="remark" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="roadname" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="show" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="spcnt" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="status" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="subtype" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="usedir" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="uselights" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="waybill" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="weight_empty" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="weight_loaded" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fundef"
})
@XmlRootElement(name = "car")
public class Car {

    protected List<Fundef> fundef;
    @XmlAttribute(name = "V_cru_hint", required = true)
    protected BigInteger vCruHint;
    @XmlAttribute(name = "V_max", required = true)
    protected BigInteger vMax;
    @XmlAttribute(name = "V_max_hint", required = true)
    protected BigInteger vMaxHint;
    @XmlAttribute(name = "V_max_loaded", required = true)
    protected BigInteger vMaxLoaded;
    @XmlAttribute(name = "V_mid_hint", required = true)
    protected BigInteger vMidHint;
    @XmlAttribute(name = "V_min_hint", required = true)
    protected BigInteger vMinHint;
    @XmlAttribute(name = "addr", required = true)
    protected BigInteger addr;
    @XmlAttribute(name = "bus", required = true)
    protected BigInteger bus;
    @XmlAttribute(name = "catnr", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String catnr;
    @XmlAttribute(name = "color", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String color;
    @XmlAttribute(name = "commuter", required = true)
    protected boolean commuter;
    @XmlAttribute(name = "dectype", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String dectype;
    @XmlAttribute(name = "desc")
    @XmlSchemaType(name = "anySimpleType")
    protected String desc;
    @XmlAttribute(name = "docu", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String docu;
    @XmlAttribute(name = "era", required = true)
    protected BigInteger era;
    @XmlAttribute(name = "f0vcmd", required = true)
    protected boolean f0Vcmd;
    @XmlAttribute(name = "fnlights", required = true)
    protected BigInteger fnlights;
    @XmlAttribute(name = "home")
    @XmlSchemaType(name = "anySimpleType")
    protected String home;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    @XmlAttribute(name = "ident")
    @XmlSchemaType(name = "anySimpleType")
    protected String ident;
    @XmlAttribute(name = "iid", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String iid;
    @XmlAttribute(name = "image", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String image;
    @XmlAttribute(name = "invdir", required = true)
    protected boolean invdir;
    @XmlAttribute(name = "len", required = true)
    protected BigInteger len;
    @XmlAttribute(name = "location", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String location;
    @XmlAttribute(name = "manuid", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String manuid;
    @XmlAttribute(name = "maxloadweight", required = true)
    protected BigInteger maxloadweight;
    @XmlAttribute(name = "number", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String number;
    @XmlAttribute(name = "owner", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String owner;
    @XmlAttribute(name = "placing", required = true)
    protected boolean placing;
    @XmlAttribute(name = "prev_id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String prevId;
    @XmlAttribute(name = "prev_ori")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String prevOri;
    @XmlAttribute(name = "prev_x")
    protected BigInteger prevX;
    @XmlAttribute(name = "prev_y")
    protected BigInteger prevY;
    @XmlAttribute(name = "prevlocation1")
    @XmlSchemaType(name = "anySimpleType")
    protected String prevlocation1;
    @XmlAttribute(name = "prevlocation2")
    @XmlSchemaType(name = "anySimpleType")
    protected String prevlocation2;
    @XmlAttribute(name = "prevlocation3")
    @XmlSchemaType(name = "anySimpleType")
    protected String prevlocation3;
    @XmlAttribute(name = "prot", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String prot;
    @XmlAttribute(name = "protver", required = true)
    protected BigInteger protver;
    @XmlAttribute(name = "purchased", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String purchased;
    @XmlAttribute(name = "identifier")
    @XmlSchemaType(name = "anySimpleType")
    protected String identifier;
    @XmlAttribute(name = "remark", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String remark;
    @XmlAttribute(name = "roadname", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String roadname;
    @XmlAttribute(name = "show", required = true)
    protected boolean show;
    @XmlAttribute(name = "spcnt", required = true)
    protected BigInteger spcnt;
    @XmlAttribute(name = "status", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String status;
    @XmlAttribute(name = "subtype")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String subtype;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String type;
    @XmlAttribute(name = "usedir", required = true)
    protected boolean usedir;
    @XmlAttribute(name = "uselights", required = true)
    protected boolean uselights;
    @XmlAttribute(name = "value", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String value;
    @XmlAttribute(name = "waybill", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String waybill;
    @XmlAttribute(name = "weight_empty", required = true)
    protected BigInteger weightEmpty;
    @XmlAttribute(name = "weight_loaded", required = true)
    protected BigInteger weightLoaded;

    /**
     * Gets the value of the fundef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fundef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFundef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fundef }
     * 
     * 
     */
    public List<Fundef> getFundef() {
        if (fundef == null) {
            fundef = new ArrayList<Fundef>();
        }
        return this.fundef;
    }

    /**
     * Gets the value of the vCruHint property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVCruHint() {
        return vCruHint;
    }

    /**
     * Sets the value of the vCruHint property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVCruHint(BigInteger value) {
        this.vCruHint = value;
    }

    /**
     * Gets the value of the vMax property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVMax() {
        return vMax;
    }

    /**
     * Sets the value of the vMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVMax(BigInteger value) {
        this.vMax = value;
    }

    /**
     * Gets the value of the vMaxHint property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVMaxHint() {
        return vMaxHint;
    }

    /**
     * Sets the value of the vMaxHint property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVMaxHint(BigInteger value) {
        this.vMaxHint = value;
    }

    /**
     * Gets the value of the vMaxLoaded property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVMaxLoaded() {
        return vMaxLoaded;
    }

    /**
     * Sets the value of the vMaxLoaded property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVMaxLoaded(BigInteger value) {
        this.vMaxLoaded = value;
    }

    /**
     * Gets the value of the vMidHint property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVMidHint() {
        return vMidHint;
    }

    /**
     * Sets the value of the vMidHint property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVMidHint(BigInteger value) {
        this.vMidHint = value;
    }

    /**
     * Gets the value of the vMinHint property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVMinHint() {
        return vMinHint;
    }

    /**
     * Sets the value of the vMinHint property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVMinHint(BigInteger value) {
        this.vMinHint = value;
    }

    /**
     * Gets the value of the addr property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAddr() {
        return addr;
    }

    /**
     * Sets the value of the addr property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAddr(BigInteger value) {
        this.addr = value;
    }

    /**
     * Gets the value of the bus property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBus() {
        return bus;
    }

    /**
     * Sets the value of the bus property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBus(BigInteger value) {
        this.bus = value;
    }

    /**
     * Gets the value of the catnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatnr() {
        return catnr;
    }

    /**
     * Sets the value of the catnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatnr(String value) {
        this.catnr = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the commuter property.
     * 
     */
    public boolean isCommuter() {
        return commuter;
    }

    /**
     * Sets the value of the commuter property.
     * 
     */
    public void setCommuter(boolean value) {
        this.commuter = value;
    }

    /**
     * Gets the value of the dectype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDectype() {
        return dectype;
    }

    /**
     * Sets the value of the dectype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDectype(String value) {
        this.dectype = value;
    }

    /**
     * Gets the value of the desc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets the value of the desc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesc(String value) {
        this.desc = value;
    }

    /**
     * Gets the value of the docu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocu() {
        return docu;
    }

    /**
     * Sets the value of the docu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocu(String value) {
        this.docu = value;
    }

    /**
     * Gets the value of the era property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEra() {
        return era;
    }

    /**
     * Sets the value of the era property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEra(BigInteger value) {
        this.era = value;
    }

    /**
     * Gets the value of the f0Vcmd property.
     * 
     */
    public boolean isF0Vcmd() {
        return f0Vcmd;
    }

    /**
     * Sets the value of the f0Vcmd property.
     * 
     */
    public void setF0Vcmd(boolean value) {
        this.f0Vcmd = value;
    }

    /**
     * Gets the value of the fnlights property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFnlights() {
        return fnlights;
    }

    /**
     * Sets the value of the fnlights property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFnlights(BigInteger value) {
        this.fnlights = value;
    }

    /**
     * Gets the value of the home property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHome() {
        return home;
    }

    /**
     * Sets the value of the home property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHome(String value) {
        this.home = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the ident property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdent() {
        return ident;
    }

    /**
     * Sets the value of the ident property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdent(String value) {
        this.ident = value;
    }

    /**
     * Gets the value of the iid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIid() {
        return iid;
    }

    /**
     * Sets the value of the iid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIid(String value) {
        this.iid = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the invdir property.
     * 
     */
    public boolean isInvdir() {
        return invdir;
    }

    /**
     * Sets the value of the invdir property.
     * 
     */
    public void setInvdir(boolean value) {
        this.invdir = value;
    }

    /**
     * Gets the value of the len property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLen() {
        return len;
    }

    /**
     * Sets the value of the len property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLen(BigInteger value) {
        this.len = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the manuid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManuid() {
        return manuid;
    }

    /**
     * Sets the value of the manuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManuid(String value) {
        this.manuid = value;
    }

    /**
     * Gets the value of the maxloadweight property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxloadweight() {
        return maxloadweight;
    }

    /**
     * Sets the value of the maxloadweight property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxloadweight(BigInteger value) {
        this.maxloadweight = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the placing property.
     * 
     */
    public boolean isPlacing() {
        return placing;
    }

    /**
     * Sets the value of the placing property.
     * 
     */
    public void setPlacing(boolean value) {
        this.placing = value;
    }

    /**
     * Gets the value of the prevId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevId() {
        return prevId;
    }

    /**
     * Sets the value of the prevId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevId(String value) {
        this.prevId = value;
    }

    /**
     * Gets the value of the prevOri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevOri() {
        return prevOri;
    }

    /**
     * Sets the value of the prevOri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevOri(String value) {
        this.prevOri = value;
    }

    /**
     * Gets the value of the prevX property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPrevX() {
        return prevX;
    }

    /**
     * Sets the value of the prevX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPrevX(BigInteger value) {
        this.prevX = value;
    }

    /**
     * Gets the value of the prevY property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPrevY() {
        return prevY;
    }

    /**
     * Sets the value of the prevY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPrevY(BigInteger value) {
        this.prevY = value;
    }

    /**
     * Gets the value of the prevlocation1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevlocation1() {
        return prevlocation1;
    }

    /**
     * Sets the value of the prevlocation1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevlocation1(String value) {
        this.prevlocation1 = value;
    }

    /**
     * Gets the value of the prevlocation2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevlocation2() {
        return prevlocation2;
    }

    /**
     * Sets the value of the prevlocation2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevlocation2(String value) {
        this.prevlocation2 = value;
    }

    /**
     * Gets the value of the prevlocation3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrevlocation3() {
        return prevlocation3;
    }

    /**
     * Sets the value of the prevlocation3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrevlocation3(String value) {
        this.prevlocation3 = value;
    }

    /**
     * Gets the value of the prot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProt() {
        return prot;
    }

    /**
     * Sets the value of the prot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProt(String value) {
        this.prot = value;
    }

    /**
     * Gets the value of the protver property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProtver() {
        return protver;
    }

    /**
     * Sets the value of the protver property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProtver(BigInteger value) {
        this.protver = value;
    }

    /**
     * Gets the value of the purchased property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPurchased() {
        return purchased;
    }

    /**
     * Sets the value of the purchased property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPurchased(String value) {
        this.purchased = value;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifier(String value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the remark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemark() {
        return remark;
    }

    /**
     * Sets the value of the remark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    /**
     * Gets the value of the roadname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoadname() {
        return roadname;
    }

    /**
     * Sets the value of the roadname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoadname(String value) {
        this.roadname = value;
    }

    /**
     * Gets the value of the show property.
     * 
     */
    public boolean isShow() {
        return show;
    }

    /**
     * Sets the value of the show property.
     * 
     */
    public void setShow(boolean value) {
        this.show = value;
    }

    /**
     * Gets the value of the spcnt property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpcnt() {
        return spcnt;
    }

    /**
     * Sets the value of the spcnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpcnt(BigInteger value) {
        this.spcnt = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the subtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubtype() {
        return subtype;
    }

    /**
     * Sets the value of the subtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubtype(String value) {
        this.subtype = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the usedir property.
     * 
     */
    public boolean isUsedir() {
        return usedir;
    }

    /**
     * Sets the value of the usedir property.
     * 
     */
    public void setUsedir(boolean value) {
        this.usedir = value;
    }

    /**
     * Gets the value of the uselights property.
     * 
     */
    public boolean isUselights() {
        return uselights;
    }

    /**
     * Sets the value of the uselights property.
     * 
     */
    public void setUselights(boolean value) {
        this.uselights = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the waybill property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaybill() {
        return waybill;
    }

    /**
     * Sets the value of the waybill property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaybill(String value) {
        this.waybill = value;
    }

    /**
     * Gets the value of the weightEmpty property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWeightEmpty() {
        return weightEmpty;
    }

    /**
     * Sets the value of the weightEmpty property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWeightEmpty(BigInteger value) {
        this.weightEmpty = value;
    }

    /**
     * Gets the value of the weightLoaded property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getWeightLoaded() {
        return weightLoaded;
    }

    /**
     * Sets the value of the weightLoaded property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setWeightLoaded(BigInteger value) {
        this.weightLoaded = value;
    }

}
