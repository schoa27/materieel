//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.02 at 05:12:18 PM CET 
//


package nl.scholtens.generated.sources;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *       &lt;sequence&gt;
 *         &lt;element ref="{}lclist"/&gt;
 *         &lt;element ref="{}carlist"/&gt;
 *         &lt;element ref="{}operatorlist"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "lclist",
    "carlist",
    "operatorlist"
})
@XmlRootElement(name = "plan")
public class Plan {

    @XmlElement(required = true)
    protected Lclist lclist;
    @XmlElement(required = true)
    protected Carlist carlist;
    @XmlElement(required = true)
    protected Operatorlist operatorlist;

    /**
     * Gets the value of the lclist property.
     * 
     * @return
     *     possible object is
     *     {@link Lclist }
     *     
     */
    public Lclist getLclist() {
        return lclist;
    }

    /**
     * Sets the value of the lclist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Lclist }
     *     
     */
    public void setLclist(Lclist value) {
        this.lclist = value;
    }

    /**
     * Gets the value of the carlist property.
     * 
     * @return
     *     possible object is
     *     {@link Carlist }
     *     
     */
    public Carlist getCarlist() {
        return carlist;
    }

    /**
     * Sets the value of the carlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Carlist }
     *     
     */
    public void setCarlist(Carlist value) {
        this.carlist = value;
    }

    /**
     * Gets the value of the operatorlist property.
     * 
     * @return
     *     possible object is
     *     {@link Operatorlist }
     *     
     */
    public Operatorlist getOperatorlist() {
        return operatorlist;
    }

    /**
     * Sets the value of the operatorlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Operatorlist }
     *     
     */
    public void setOperatorlist(Operatorlist value) {
        this.operatorlist = value;
    }

}
