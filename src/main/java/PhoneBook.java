import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

        Optional res = book.entrySet().stream()
                .filter(entry -> number.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        if (res.isEmpty()){
            return null;
        }

        return res.get().toString();

    }

    public int getSize(){
        return book.size();
    }
}
