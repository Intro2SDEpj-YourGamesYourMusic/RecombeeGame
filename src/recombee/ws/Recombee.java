package recombee.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import game.soap.ws.Game;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface Recombee {
	@WebMethod(operationName="registerUser")
    @WebResult(name="result") 
    public boolean registerUser(@WebParam(name="user") String user);
	
//1
    @WebMethod(operationName="getReccomendation")
    @WebResult(name="games") 
    public List<Game> getReccomendation(@WebParam(name="user") String user);
//2
    @WebMethod(operationName="getReccomendationByGenre")
    @WebResult(name="games") 
    public List<Game> getReccomendationByGenre(@WebParam(name="user") String user, @WebParam(name="genre") String genre);
    
    @WebMethod(operationName="addPurchase")
    @WebResult(name="result") 
    public boolean addPurchase(@WebParam(name="user") String user, @WebParam(name="appId") long appId);
    
    @WebMethod(operationName="deletePurchase")
    @WebResult(name="result") 
    public boolean deletePurchase(@WebParam(name="user") String user, @WebParam(name="appId") long appId);
    
    @WebMethod(operationName="showPurchases")
    @WebResult(name="games") 
    public List<Game> showPurchases(@WebParam(name="user") String user);
    
   
    @WebMethod(operationName="addRating")
    @WebResult(name="result") 
    public boolean addRating(@WebParam(name="user") String user, @WebParam(name="appId") long appId, @WebParam(name="rating") double rating);
   
    @WebMethod(operationName="deleteRating")
    @WebResult(name="result") 
    public boolean deleteRating(@WebParam(name="user") String user, @WebParam(name="appId") long appId);
    
    @WebMethod(operationName="showRatings")
    @WebResult(name="games") 
    public List<Game> showRatings(@WebParam(name="user") String user);
   
    
    @WebMethod(operationName="addBookmark")
    @WebResult(name="result") 
    public boolean addBookmark(@WebParam(name="user") String user, @WebParam(name="appId") long appId);
   
    @WebMethod(operationName="deleteBookmark")
    @WebResult(name="result") 
    public boolean deleteBookmark(@WebParam(name="user") String user, @WebParam(name="appId") long appId);
   
    @WebMethod(operationName="showBookmarks")
    @WebResult(name="games") 
    public List<Game> showBookmarks(@WebParam(name="user") String user);

	@WebMethod(operationName="randomGames")
    @WebResult(name="games") 
    public List<Game> randomGames();

	@WebMethod(operationName="checkSale")
    @WebResult(name="game") 
    public Game checkSale(@WebParam(name="appId") long appId, @WebParam(name="name") String name);
	

	@WebMethod(operationName="findGame")
    @WebResult(name="games") 
    public List<Game> findGame(@WebParam(name="name") String name);
	
	@WebMethod(operationName="randomUserByItem")
    @WebResult(name="obcjects") 
    public List<Object> randomUserByItem(@WebParam(name="name") String name);
}