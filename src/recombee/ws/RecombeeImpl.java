package recombee.ws;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.jws.WebService;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.AddBookmark;
import com.recombee.api_client.api_requests.AddItem;
import com.recombee.api_client.exceptions.ApiException;

import game.soap.ws.Game;
import game.soap.ws.Game.Genres;
import game.soap.ws.Games;
import game.soap.ws.GamesService;
//import game.soap.external.ExternalAPICaller;
//import model.Game;

import com.recombee.api_client.api_requests.AddItemProperty;
import com.recombee.api_client.api_requests.AddPurchase;
import com.recombee.api_client.api_requests.AddRating;
import com.recombee.api_client.api_requests.AddUser;
import com.recombee.api_client.api_requests.DeleteBookmark;
import com.recombee.api_client.api_requests.DeleteItem;
import com.recombee.api_client.api_requests.DeletePurchase;
import com.recombee.api_client.api_requests.DeleteRating;
import com.recombee.api_client.api_requests.DeleteUser;
import com.recombee.api_client.api_requests.ListItemPurchases;
import com.recombee.api_client.api_requests.ListItems;
import com.recombee.api_client.api_requests.ListUserBookmarks;
import com.recombee.api_client.api_requests.ListUserPurchases;
import com.recombee.api_client.api_requests.ListUserRatings;
import com.recombee.api_client.api_requests.SetItemValues;
import com.recombee.api_client.api_requests.UserBasedRecommendation;
import com.recombee.api_client.bindings.Bookmark;
import com.recombee.api_client.bindings.Item;
import com.recombee.api_client.bindings.Purchase;
import com.recombee.api_client.bindings.Rating;
import com.recombee.api_client.bindings.Recommendation;


@WebService(endpointInterface = "recombee.ws.Recombee",
serviceName="RecombeeService")
public class RecombeeImpl implements Recombee{
	
	final String dbName= "commandersdenis";
	final String dbKey = "0wLbkL2YI1TWkD9mdwoQ5zRb3mzHjWCN4PoXYJTBk8fHOcEfCcFX6ChOQ8ATDtkz";
	RecombeeClient client = new RecombeeClient(dbName,dbKey);
	GamesService gs = new GamesService();
	Games gamesImpl = gs.getGamesImplPort();
	//static ExternalAPICaller api = new ExternalAPICaller();
	
	/*public static void main(String[] args) {
		//deleteItems();
		Init();
	}*/
	
	/*public void Init() {
		//List<Game> games = api.initRange(0,150);
		//List<Game> games = api.initRange(150,300);
		//List<Game> games = api.initRange(300,450);
		//List<Game> games = api.initRange(450,600);
		//List<Game> games = api.initRange(600,750);
		//List<Game> games = api.initRange(750,900);
		//List<Game> games = api.initRange(900,1050);
		//AddItemProperty("name","string");
		//AddItemProperty("genres","set");
		/*for(Game g : games) {
			if(g.getGenere()!=null)
				SendItem(g.getAppId()+"", g.getName(), g.getGenere());
		}
		System.out.println("Import finished!");
	}*/
	
	public List<Game> getReccomendation(String user){
		Recommendation[] result;
		try {
			result = client.send(new UserBasedRecommendation(user, 5).setReturnProperties(true));
			
			if(result == null)
				return null;

			System.out.println(result.length+"");
			System.out.println(result[0].getValues().get("itemId").toString());
			
			List<Game> games = new ArrayList<Game>();
			
			for(int i = 0; i < result.length; i++) {
				Game g = new Game();
				long appId = Long.parseLong(result[i].getValues().get("itemId").toString());
				String name = result[i].getValues().get("name").toString();

				System.out.println(name);
				System.out.println(appId+"");
				g = gamesImpl.getGame(appId, name);
				if(g!=null)
					games.add(g);
				System.out.println(g.getName());
			}
			return games;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Game> getReccomendationByGenre(String user, String genre){
		Recommendation[] result;
		try {
			String filter = "\""+genre+"\" in 'genres'";
			result = client.send(new UserBasedRecommendation(user, 5).setReturnProperties(true).setFilter(filter));
			if(result == null)
				return null;
			
			List<Game> games = new ArrayList<Game>();
			
			for(int i = 0; i < result.length; i++) {
				Game g = new Game();
				long appId = Long.parseLong(result[i].getValues().get("itemId").toString());
				String name = result[i].getValues().get("name").toString();
				g = gamesImpl.getGame(appId, name);
				if(g!=null)
					games.add(g);
			}
			return games;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void deleteItems()
	{
		try {
			Item[] results = client.send(new ListItems().setReturnProperties(true));
			for(Item item : results) {
				String id = item.getValues().get("itemId").toString();
				client.send(new DeleteItem(id));
			}
			
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void SendItem(String appId, String name, String[] genres) {
		HashMap<String, Object> hm = new HashMap<String,Object>();
		hm.put("name",name);
		hm.put("genres", genres);
		
		try {
			client.send(new SetItemValues(appId,hm).setCascadeCreate(true));
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void AddItem(String itemId) {
		try {
			client.send(new AddItem(itemId));
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void AddItemProperty(String propertyName, String type) {
		try {
			client.send(new AddItemProperty(propertyName, type));
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public boolean addPurchase(String user, long appId) {
		try {
			String tmp = client.send(new AddPurchase(user, appId+"").setTimestamp(new Date()).setAmount(1).setCascadeCreate(true));
			System.out.println("User: "+user+ "   appId: "+appId);
			System.out.println(tmp);
			return true;
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public boolean addRating(String user, long appId, double rating) {
		try {
			client.send(new AddRating(user, appId+"", rating).setCascadeCreate(true));
			return true;
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public boolean deleteRating(String user, long appId) {
		try {
			client.send(new DeleteRating(user, appId+""));
			return true;
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private Game getGameById(String appId) {
		Item[] result;
		try {
			 result = client.send(new ListItems().setReturnProperties(true).setFilter("\""+appId+"\" in 'itemId'"));
			 if(result==null)
				 return null;
			 Game g= new Game();
			 long id = Long.parseLong(appId);
			 g.setAppId(id);
			 g.setName(result[0].getValues().get("name").toString());
			 return g;
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Game> showRatings(String user) {
		Rating [] result; 
		
		try {
			result = client.send(new ListUserRatings(user));
			if(result==null)
				return null;
			List<Game> games = new ArrayList<Game>();
			for(Rating r : result) {
				Game g = new Game();
				g = getGameById(r.getItemId());
				if(g!=null)
					games.add(g);
			}
			return games;
			
		} catch (ApiException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public boolean addBookmark(String user, long appId) {
		try {
			client.send(new AddBookmark(user, appId+"").setCascadeCreate(true));
			return true;
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public boolean deleteBookmark(String user, long appId) {
		try {
			client.send(new DeleteBookmark(user, appId+""));
			return true;
		} catch (ApiException e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public List<Game> showBookmarks(String user) {
		try {
			Bookmark [] result = client.send(new ListUserBookmarks(user));
			if(result==null)
				return null;
			List<Game> games = new ArrayList<Game>();
			for(Bookmark b : result) {
				Game g = new Game();
				g = getGameById(b.getItemId());
				if(g!=null)
					games.add(g);
			}
			return games;
			
			
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean registerUser(String user) {
		try {
			client.send(new AddUser(user));
			return true;
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Game> randomGames() {
		//"Action","Indie","Strategy","RPG","Casual","Simulation","Racing","Violent"
		List<Game> games = new ArrayList<Game>();
		Random random = new Random();
		try {
			Item[] action = client.send(new ListItems().setReturnProperties(true).setFilter("\"Action\" in 'genres'"));
			Item[] indie = client.send(new ListItems().setReturnProperties(true).setFilter("\"Indie\" in 'genres'"));
			Item[] strategy = client.send(new ListItems().setReturnProperties(true).setFilter("\"Strategy\" in 'genres'"));
			Item[] rpg = client.send(new ListItems().setReturnProperties(true).setFilter("\"RPG\" in 'genres'"));
			Item[] casual = client.send(new ListItems().setReturnProperties(true).setFilter("\"Casual\" in 'genres'"));
			Item[] simulation = client.send(new ListItems().setReturnProperties(true).setFilter("\"Simulation\" in 'genres'"));
			Item[] racing= client.send(new ListItems().setReturnProperties(true).setFilter("\"Racing\" in 'genres'"));
			Item[] violent= client.send(new ListItems().setReturnProperties(true).setFilter("\"Violent\" in 'genres'"));
			
			Game game1 = new Game();
			Item item = action[random.nextInt(action.length)];
			game1.setAppId(Long.parseLong(item.getValues().get("itemId").toString()));
			game1.setName(item.getValues().get("name").toString());
			Genres genres = new Genres();
			for(String s : item.getValues().get("genres").toString().split(","))
			{
				genres.getGenre().add(s);
			}
			game1.setGenres(genres);
			games.add(game1);
			
			Game game2 = new Game();
			item = indie[random.nextInt(indie.length)];
			game2.setAppId(Long.parseLong(item.getValues().get("itemId").toString()));
			game2.setName(item.getValues().get("name").toString());
			genres = new Genres();
			for(String s : item.getValues().get("genres").toString().split(","))
			{
				genres.getGenre().add(s);
			}
			game2.setGenres(genres); 
			games.add(game2);
			
			Game game3 = new Game();
			item = strategy[random.nextInt(strategy.length)];
			game3.setAppId(Long.parseLong(item.getValues().get("itemId").toString()));
			game3.setName(item.getValues().get("name").toString());
			genres = new Genres();
			for(String s : item.getValues().get("genres").toString().split(","))
			{
				genres.getGenre().add(s);
			}
			game3.setGenres(genres); 
			games.add(game3);
			
			Game game4 = new Game();
			item = rpg[random.nextInt(rpg.length)];
			game4.setAppId(Long.parseLong(item.getValues().get("itemId").toString()));
			game4.setName(item.getValues().get("name").toString());
			genres = new Genres();
			for(String s : item.getValues().get("genres").toString().split(","))
			{
				genres.getGenre().add(s);
			}
			game4.setGenres(genres); 
			games.add(game4);
			
			Game game5 = new Game();
			item = casual[random.nextInt(casual.length)];
			game5.setAppId(Long.parseLong(item.getValues().get("itemId").toString()));
			game5.setName(item.getValues().get("name").toString());
			genres = new Genres();
			for(String s : item.getValues().get("genres").toString().split(","))
			{
				genres.getGenre().add(s);
			}
			game5.setGenres(genres); 
			games.add(game5);
			
			Game game6 = new Game();
			item = simulation[random.nextInt(simulation.length)];
			game6.setAppId(Long.parseLong(item.getValues().get("itemId").toString()));
			game6.setName(item.getValues().get("name").toString());
			genres = new Genres();
			for(String s : item.getValues().get("genres").toString().split(","))
			{
				genres.getGenre().add(s);
			}
			game6.setGenres(genres); 
			games.add(game6);
			
			Game game7 = new Game();
			item = racing[random.nextInt(racing.length)];
			game7.setAppId(Long.parseLong(item.getValues().get("itemId").toString()));
			game7.setName(item.getValues().get("name").toString());
			genres = new Genres();
			for(String s : item.getValues().get("genres").toString().split(","))
			{
				genres.getGenre().add(s);
			}
			game7.setGenres(genres); 
			games.add(game7);
			
			Game game8 = new Game();
			item = violent[random.nextInt(violent.length)];
			game8.setAppId(Long.parseLong(item.getValues().get("itemId").toString()));
			game8.setName(item.getValues().get("name").toString());
			genres = new Genres();
			for(String s : item.getValues().get("genres").toString().split(","))
			{
				genres.getGenre().add(s);
			}
			game8.setGenres(genres); 
			games.add(game8);
			
			return games;
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deletePurchase(String user, long appId) {
		try {
			client.send(new DeletePurchase(user, appId+""));
			return true;
		} catch (ApiException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Game> showPurchases(String user) {
		try {
			Purchase [] result = client.send(new ListUserPurchases(user));
			if(result==null)
				return null;
			List<Game> games = new ArrayList<Game>();
			for(Purchase p : result) {
				Game g = new Game();
				g = getGameById(p.getItemId());
				if(g!=null)
					games.add(g);
			}
			return games;
			
			
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Game checkSale(long appId, String name) {
		return gamesImpl.getGame(appId, name);
	}

	@Override
	public List<Game> findGame(String name) {
		String[] words = name.split(" ");
		List<Game> games = new ArrayList<Game>();
		try {
			Item[] result = client.send(new ListItems().setReturnProperties(true));
			if(result!=null)
			{
				for(Item i : result) {
					String item_name = i.getValues().get("name").toString();
					String[] splitted = item_name.split(" ");
					for(String s : splitted) {
						for(String word : words) {
							s = s.toLowerCase();
							word = word.toLowerCase();
							if(s.equals(word)) {
								Game g = new Game();
								g.setAppId(Long.parseLong(i.getValues().get("itemId").toString()));
								g.setName(item_name);
								if(!games.contains(g))
									games.add(g);
							}
						}
					}
				}
			
			}
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return games;
	}

	@Override
	public List<Object> randomUserByItem(String name) {
		String user = null;
		Game g = null;
		try {
			Purchase [] result = client.send(new ListUserPurchases(name));
			if(result == null)
				return null;
			Random r = new Random();
			int i = r.nextInt(result.length);
			g = new Game();
			g = getGameById(result[i].getItemId().toString());
			
			Purchase[] items = client.send(new ListItemPurchases(g.getAppId()+""));
			if(items==null)
				return null;
			while(items.length>1 && user==null) {
				int u = r.nextInt(items.length);
				user = items[u].getUserId();
				if(user.equals(name))
					user = null;
			}
			
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Object> list = new ArrayList<Object>();
		list.add(user);
		list.add(g);
		return list;
	}
	
	
	@Override
	public boolean deleteUser(String user) {
		try {
			client.send(new DeleteUser(user));
			return true;
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
