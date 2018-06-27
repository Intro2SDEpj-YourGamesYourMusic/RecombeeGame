
package game.soap.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the game.soap.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetGameListResponse_QNAME = new QName("http://ws.soap.game/", "getGameListResponse");
    private final static QName _GetGameList_QNAME = new QName("http://ws.soap.game/", "getGameList");
    private final static QName _InitResponse_QNAME = new QName("http://ws.soap.game/", "initResponse");
    private final static QName _GetGame_QNAME = new QName("http://ws.soap.game/", "getGame");
    private final static QName _Init_QNAME = new QName("http://ws.soap.game/", "init");
    private final static QName _Game_QNAME = new QName("http://ws.soap.game/", "Game");
    private final static QName _GetGameResponse_QNAME = new QName("http://ws.soap.game/", "getGameResponse");
    private final static QName _GameInfo_QNAME = new QName("http://ws.soap.game/", "GameInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: game.soap.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Game }
     * 
     */
    public Game createGame() {
        return new Game();
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link GameInfo }
     * 
     */
    public GameInfo createGameInfo() {
        return new GameInfo();
    }

    /**
     * Create an instance of {@link GetGameResponse }
     * 
     */
    public GetGameResponse createGetGameResponse() {
        return new GetGameResponse();
    }

    /**
     * Create an instance of {@link GetGameList }
     * 
     */
    public GetGameList createGetGameList() {
        return new GetGameList();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link GetGame }
     * 
     */
    public GetGame createGetGame() {
        return new GetGame();
    }

    /**
     * Create an instance of {@link GetGameListResponse }
     * 
     */
    public GetGameListResponse createGetGameListResponse() {
        return new GetGameListResponse();
    }

    /**
     * Create an instance of {@link Game.Genres }
     * 
     */
    public Game.Genres createGameGenres() {
        return new Game.Genres();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGameListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.game/", name = "getGameListResponse")
    public JAXBElement<GetGameListResponse> createGetGameListResponse(GetGameListResponse value) {
        return new JAXBElement<GetGameListResponse>(_GetGameListResponse_QNAME, GetGameListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGameList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.game/", name = "getGameList")
    public JAXBElement<GetGameList> createGetGameList(GetGameList value) {
        return new JAXBElement<GetGameList>(_GetGameList_QNAME, GetGameList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.game/", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGame }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.game/", name = "getGame")
    public JAXBElement<GetGame> createGetGame(GetGame value) {
        return new JAXBElement<GetGame>(_GetGame_QNAME, GetGame.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.game/", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Game }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.game/", name = "Game")
    public JAXBElement<Game> createGame(Game value) {
        return new JAXBElement<Game>(_Game_QNAME, Game.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.game/", name = "getGameResponse")
    public JAXBElement<GetGameResponse> createGetGameResponse(GetGameResponse value) {
        return new JAXBElement<GetGameResponse>(_GetGameResponse_QNAME, GetGameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GameInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.soap.game/", name = "GameInfo")
    public JAXBElement<GameInfo> createGameInfo(GameInfo value) {
        return new JAXBElement<GameInfo>(_GameInfo_QNAME, GameInfo.class, null, value);
    }

}
