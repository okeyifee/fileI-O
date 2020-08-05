//import needed java packages
import java.io.File;
import java.util.*;

class ConfigParser {

//    initialize a map
    HashMap <String, String> map = new HashMap <String, String>();

//  initializing variable to hold name
    String name;

//  parameterized constructor for class
    public ConfigParser(String fileName) {
        this.name = fileName;
        Extract();
    }

// checks and extracts data from file to map
    public void Extract(){
        Scanner scanner = null;
        boolean checkForapplication = false;

        try {
                scanner = new Scanner(new File(name));
                String line;

/*
    ..checks for line containing [application], returns a boolean
    ..if true, appends the name to keys on subsequent lines until an empty line is encountered
    ..if false, continue until end of loop
*/
                while(scanner.hasNext()){
                    line = scanner.nextLine();

                    if(line.contains("application")) {
                        checkForapplication = true;
                    }else if("".equals(line.trim())) {
                        checkForapplication = false;
                    }

                    if(checkForapplication){
                        setMapValues(line, "application.");
                    }else{
                        setMapValues(line);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            try{
                scanner.close();
            }catch (Exception e){
                e.getMessage();
            }
        }
    }

//  Split lines to keys and values using "=" checks for duplicate
    private void setMapValues(String value) {
        String[] arr = value.split("=");
        if(!map.containsKey(arr[0]) && arr.length == 2 ){
            map.put(arr[0], arr[1]);
        }
    }

//  checks for duplicates (for keys appended with a prefix)
    private void setMapValues(String value, String prefix) {
        String[] arr = value.split("=");
        if(!map.containsKey(prefix + arr[0]) && arr.length == 2 ){
            map.put(prefix + arr[0], arr[1]);
        }
    }

//  returns value for key
    public String get(String key) {
        System.out.println(map.toString());
        if (!map.containsKey(key)) {
            return "invalid key";
        }else{
            return map.get(key);
        }
    }
}



