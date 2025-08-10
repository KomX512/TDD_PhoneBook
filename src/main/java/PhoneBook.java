import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, String> book = new HashMap<>();

    public PhoneBook(){
    }

    public int add(String name, String number){
        if (!book.containsKey(name)) {
            book.put(name, number);
        }else {
            System.out.println("Имя " + name + " уже есть в книге");
        }

        return getSize();
    }

    public String findByNumber(String number){
        return null;
    }

    public int getSize(){
        return book.size();
    }
}
