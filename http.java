import java.io.*;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.*;

public class http
{
	public static void main(String arg[]) throws Exception
	{
		HttpServer ob = HttpServer.create(new InetSocketAddress(8000),0);
		ob.createContext("/name", new nameHandler());
		ob.createContext("/id", new idHandler());
		ob.setExecutor(null);
		ob.start();
	}
	
	static class nameHandler implements HttpHandler
	{
		public void handle(HttpExchange t) throws IOException
		{
			byte [] res = "<h1>Hello, I'm Tahmid Hasan</h1>".getBytes();
			t.sendResponseHeaders(200,res.length);
			OutputStream os = t.getResponseBody();
			os.write(res);
			os.close();
		}
	}

	static class idHandler implements HttpHandler
	{
		public void handle(HttpExchange t) throws IOException
		{
			byte [] res = "<h1>My ID is 193311067</h1>".getBytes();
			t.sendResponseHeaders(200,res.length);
			OutputStream os = t.getResponseBody();
			os.write(res);
			os.close();
		}
	}
}
