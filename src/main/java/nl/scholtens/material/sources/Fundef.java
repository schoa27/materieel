//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.30 at 03:04:04 PM CET 
//


package nl.scholtens.material.sources;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="addr" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="fn" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="icon" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="mappedfn" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *       &lt;attribute name="offblockid" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="offevent" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="onblockid" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="onevent" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="sound" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="text" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="timer" type="{http://www.w3.org/2001/XMLSchema}integer" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "fundef")
public class Fundef {

    @XmlAttribute(name = "addr")
    protected BigInteger addr;
    @XmlAttribute(name = "fn", required = true)
    protected BigInteger fn;
    @XmlAttribute(name = "icon", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String icon;
    @XmlAttribute(name = "mappedfn")
    protected BigInteger mappedfn;
    @XmlAttribute(name = "offblockid")
    @XmlSchemaType(name = "anySimpleType")
    protected String offblockid;
    @XmlAttribute(name = "offevent")
    @XmlSchemaType(name = "anySimpleType")
    protected String offevent;
    @XmlAttribute(name = "onblockid")
    @XmlSchemaType(name = "anySimpleType")
    protected String onblockid;
    @XmlAttribute(name = "onevent")
    @XmlSchemaType(name = "anySimpleType")
    protected String onevent;
    @XmlAttribute(name = "sound")
    @XmlSchemaType(name = "anySimpleType")
    protected String sound;
    @XmlAttribute(name = "text", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String text;
    @XmlAttribute(name = "timer")
    protected BigInteger timer;

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
     * Gets the value of the fn property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFn() {
        return fn;
    }

    /**
     * Sets the value of the fn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFn(BigInteger value) {
        this.fn = value;
    }

    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcon(String value) {
        this.icon = value;
    }

    /**
     * Gets the value of the mappedfn property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMappedfn() {
        return mappedfn;
    }

    /**
     * Sets the value of the mappedfn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMappedfn(BigInteger value) {
        this.mappedfn = value;
    }

    /**
     * Gets the value of the offblockid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffblockid() {
        return offblockid;
    }

    /**
     * Sets the value of the offblockid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffblockid(String value) {
        this.offblockid = value;
    }

    /**
     * Gets the value of the offevent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffevent() {
        return offevent;
    }

    /**
     * Sets the value of the offevent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffevent(String value) {
        this.offevent = value;
    }

    /**
     * Gets the value of the onblockid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnblockid() {
        return onblockid;
    }

    /**
     * Sets the value of the onblockid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnblockid(String value) {
        this.onblockid = value;
    }

    /**
     * Gets the value of the onevent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOnevent() {
        return onevent;
    }

    /**
     * Sets the value of the onevent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOnevent(String value) {
        this.onevent = value;
    }

    /**
     * Gets the value of the sound property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSound() {
        return sound;
    }

    /**
     * Sets the value of the sound property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSound(String value) {
        this.sound = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the timer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimer() {
        return timer;
    }

    /**
     * Sets the value of the timer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimer(BigInteger value) {
        this.timer = value;
    }

}
