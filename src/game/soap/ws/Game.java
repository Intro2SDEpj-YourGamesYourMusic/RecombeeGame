
package game.soap.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per game complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="game">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="fullPrice" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="rating" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="genres" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GameInfo" type="{http://ws.soap.game/}gameInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "game", propOrder = {
    "appId",
    "name",
    "price",
    "fullPrice",
    "rating",
    "genres",
    "date",
    "gameInfo"
})
public class Game {

    protected long appId;
    protected String name;
    protected float price;
    protected float fullPrice;
    protected float rating;
    protected Game.Genres genres;
    protected String date;
    @XmlElement(name = "GameInfo")
    protected GameInfo gameInfo;

    /**
     * Recupera il valore della proprietà appId.
     * 
     */
    public long getAppId() {
        return appId;
    }

    /**
     * Imposta il valore della proprietà appId.
     * 
     */
    public void setAppId(long value) {
        this.appId = value;
    }

    /**
     * Recupera il valore della proprietà name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprietà name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Recupera il valore della proprietà price.
     * 
     */
    public float getPrice() {
        return price;
    }

    /**
     * Imposta il valore della proprietà price.
     * 
     */
    public void setPrice(float value) {
        this.price = value;
    }

    /**
     * Recupera il valore della proprietà fullPrice.
     * 
     */
    public float getFullPrice() {
        return fullPrice;
    }

    /**
     * Imposta il valore della proprietà fullPrice.
     * 
     */
    public void setFullPrice(float value) {
        this.fullPrice = value;
    }

    /**
     * Recupera il valore della proprietà rating.
     * 
     */
    public float getRating() {
        return rating;
    }

    /**
     * Imposta il valore della proprietà rating.
     * 
     */
    public void setRating(float value) {
        this.rating = value;
    }

    /**
     * Recupera il valore della proprietà genres.
     * 
     * @return
     *     possible object is
     *     {@link Game.Genres }
     *     
     */
    public Game.Genres getGenres() {
        return genres;
    }

    /**
     * Imposta il valore della proprietà genres.
     * 
     * @param value
     *     allowed object is
     *     {@link Game.Genres }
     *     
     */
    public void setGenres(Game.Genres value) {
        this.genres = value;
    }

    /**
     * Recupera il valore della proprietà date.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Imposta il valore della proprietà date.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Recupera il valore della proprietà gameInfo.
     * 
     * @return
     *     possible object is
     *     {@link GameInfo }
     *     
     */
    public GameInfo getGameInfo() {
        return gameInfo;
    }

    /**
     * Imposta il valore della proprietà gameInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link GameInfo }
     *     
     */
    public void setGameInfo(GameInfo value) {
        this.gameInfo = value;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "genre"
    })
    public static class Genres {

        protected List<String> genre;

        /**
         * Gets the value of the genre property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the genre property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGenre().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getGenre() {
            if (genre == null) {
                genre = new ArrayList<String>();
            }
            return this.genre;
        }

    }

}
