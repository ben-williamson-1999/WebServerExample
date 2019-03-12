package example.network.app;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.notFound;
import static spark.Spark.port;

public class SparkTest {

    public static void main(String[] args){

        System.setProperty("com.spark.shaded.eclipse.jetty.LEVEL","OFF");

        port(8080);

        get("/hello", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "<html><head></head><body><p>Hello, HTTP World!</p></body></html>";
            }
        });

        get("/somethingelse", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "some other content...";
            }
        });

        get("/stats", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "<html><head></head><body><p> The Total amount of memory used by th JVM is: " +
                        Runtime.getRuntime().totalMemory() +
                        "\n The amount of free memory on the JVM is: " +
                        Runtime.getRuntime().freeMemory() +
                        "</p></body></html>";
            }
        });

        notFound("404 Not Found");

    }
}
