
package game.soap.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per gameInfo complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="gameInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="singlePlayer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="multiPlayer" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="multiPlayerOnline" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="multiPlayerLocal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="coop" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="coopOnline" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gameInfo", propOrder = {
    "singlePlayer",
    "multiPlayer",
    "multiPlayerOnline",
    "multiPlayerLocal",
    "coop",
    "coopOnline"
})
public class GameInfo {

    protected boolean singlePlayer;
    protected boolean multiPlayer;
    protected boolean multiPlayerOnline;
    protected boolean multiPlayerLocal;
    protected boolean coop;
    protected boolean coopOnline;

    /**
     * Recupera il valore della proprietà singlePlayer.
     * 
     */
    public boolean isSinglePlayer() {
        return singlePlayer;
    }

    /**
     * Imposta il valore della proprietà singlePlayer.
     * 
     */
    public void setSinglePlayer(boolean value) {
        this.singlePlayer = value;
    }

    /**
     * Recupera il valore della proprietà multiPlayer.
     * 
     */
    public boolean isMultiPlayer() {
        return multiPlayer;
    }

    /**
     * Imposta il valore della proprietà multiPlayer.
     * 
     */
    public void setMultiPlayer(boolean value) {
        this.multiPlayer = value;
    }

    /**
     * Recupera il valore della proprietà multiPlayerOnline.
     * 
     */
    public boolean isMultiPlayerOnline() {
        return multiPlayerOnline;
    }

    /**
     * Imposta il valore della proprietà multiPlayerOnline.
     * 
     */
    public void setMultiPlayerOnline(boolean value) {
        this.multiPlayerOnline = value;
    }

    /**
     * Recupera il valore della proprietà multiPlayerLocal.
     * 
     */
    public boolean isMultiPlayerLocal() {
        return multiPlayerLocal;
    }

    /**
     * Imposta il valore della proprietà multiPlayerLocal.
     * 
     */
    public void setMultiPlayerLocal(boolean value) {
        this.multiPlayerLocal = value;
    }

    /**
     * Recupera il valore della proprietà coop.
     * 
     */
    public boolean isCoop() {
        return coop;
    }

    /**
     * Imposta il valore della proprietà coop.
     * 
     */
    public void setCoop(boolean value) {
        this.coop = value;
    }

    /**
     * Recupera il valore della proprietà coopOnline.
     * 
     */
    public boolean isCoopOnline() {
        return coopOnline;
    }

    /**
     * Imposta il valore della proprietà coopOnline.
     * 
     */
    public void setCoopOnline(boolean value) {
        this.coopOnline = value;
    }

}
