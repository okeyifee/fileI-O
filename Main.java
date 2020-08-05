public class Main {

    public static void main(String[] args) {
        ConfigParser config = null;

//  Switching environment and specifying file to read from
        if (args.length == 0) {
            config = new ConfigParser("./src/config.txt");
        } else {
            switch (args[0].trim().toLowerCase()) {
                case "staging" -> config = new ConfigParser("./src/config-staging.txt");
                case "development" -> config = new ConfigParser("./src/config-dev.txt");
                default -> System.out.println("wrong input");
            }
            if (null == config) throw new AssertionError();
        }
//  Calling the get method in configParser class and returning the value for the argument(key)
        System.out.println( config.get("application.name"));
    }
}


























