//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.30 at 03:00:35 PM CET 
//


package nl.scholtens.material.sources;

import java.math.BigInteger;
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
 *       &lt;attribute name="V_max" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="cargo" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="carids" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="centertrain" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="centertrainonly" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="class" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="commuter" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="inatpre2in" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="lcid" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="length" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="location" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="prev_id" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="prev_ori" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" /&gt;
 *       &lt;attribute name="prev_x" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="prev_y" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="secondnextblock" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="secondnextblock4wait" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="shiftonly" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="shortin" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="swaptrainimage" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "operatorTrain")
public class OperatorTrain {

    @XmlAttribute(name = "V_max", required = true)
    protected BigInteger vMax;
    @XmlAttribute(name = "cargo", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String cargo;
    @XmlAttribute(name = "carids", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String carids;
    @XmlAttribute(name = "centertrain")
    protected BigInteger centertrain;
    @XmlAttribute(name = "centertrainonly")
    protected Boolean centertrainonly;
    @XmlAttribute(name = "class", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String clazz;
    @XmlAttribute(name = "commuter")
    protected Boolean commuter;
    @XmlAttribute(name = "id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String id;
    @XmlAttribute(name = "inatpre2in")
    protected Boolean inatpre2In;
    @XmlAttribute(name = "lcid", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String lcid;
    @XmlAttribute(name = "length", required = true)
    protected BigInteger length;
    @XmlAttribute(name = "location")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String location;
    @XmlAttribute(name = "prev_id", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String prevId;
    @XmlAttribute(name = "prev_ori", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String prevOri;
    @XmlAttribute(name = "prev_x", required = true)
    protected BigInteger prevX;
    @XmlAttribute(name = "prev_y", required = true)
    protected BigInteger prevY;
    @XmlAttribute(name = "secondnextblock")
    protected Boolean secondnextblock;
    @XmlAttribute(name = "secondnextblock4wait")
    protected Boolean secondnextblock4Wait;
    @XmlAttribute(name = "shiftonly", required = true)
    protected boolean shiftonly;
    @XmlAttribute(name = "shortin")
    protected Boolean shortin;
    @XmlAttribute(name = "swaptrainimage", required = true)
    protected boolean swaptrainimage;

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
     * Gets the value of the cargo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Sets the value of the cargo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCargo(String value) {
        this.cargo = value;
    }

    /**
     * Gets the value of the carids property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarids() {
        return carids;
    }

    /**
     * Sets the value of the carids property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarids(String value) {
        this.carids = value;
    }

    /**
     * Gets the value of the centertrain property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCentertrain() {
        return centertrain;
    }

    /**
     * Sets the value of the centertrain property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCentertrain(BigInteger value) {
        this.centertrain = value;
    }

    /**
     * Gets the value of the centertrainonly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCentertrainonly() {
        return centertrainonly;
    }

    /**
     * Sets the value of the centertrainonly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCentertrainonly(Boolean value) {
        this.centertrainonly = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the commuter property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCommuter() {
        return commuter;
    }

    /**
     * Sets the value of the commuter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCommuter(Boolean value) {
        this.commuter = value;
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
     * Gets the value of the inatpre2In property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInatpre2In() {
        return inatpre2In;
    }

    /**
     * Sets the value of the inatpre2In property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInatpre2In(Boolean value) {
        this.inatpre2In = value;
    }

    /**
     * Gets the value of the lcid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLcid() {
        return lcid;
    }

    /**
     * Sets the value of the lcid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLcid(String value) {
        this.lcid = value;
    }

    /**
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLength(BigInteger value) {
        this.length = value;
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
     * Gets the value of the secondnextblock property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSecondnextblock() {
        return secondnextblock;
    }

    /**
     * Sets the value of the secondnextblock property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSecondnextblock(Boolean value) {
        this.secondnextblock = value;
    }

    /**
     * Gets the value of the secondnextblock4Wait property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSecondnextblock4Wait() {
        return secondnextblock4Wait;
    }

    /**
     * Sets the value of the secondnextblock4Wait property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSecondnextblock4Wait(Boolean value) {
        this.secondnextblock4Wait = value;
    }

    /**
     * Gets the value of the shiftonly property.
     * 
     */
    public boolean isShiftonly() {
        return shiftonly;
    }

    /**
     * Sets the value of the shiftonly property.
     * 
     */
    public void setShiftonly(boolean value) {
        this.shiftonly = value;
    }

    /**
     * Gets the value of the shortin property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShortin() {
        return shortin;
    }

    /**
     * Sets the value of the shortin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShortin(Boolean value) {
        this.shortin = value;
    }

    /**
     * Gets the value of the swaptrainimage property.
     * 
     */
    public boolean isSwaptrainimage() {
        return swaptrainimage;
    }

    /**
     * Sets the value of the swaptrainimage property.
     * 
     */
    public void setSwaptrainimage(boolean value) {
        this.swaptrainimage = value;
    }

}
