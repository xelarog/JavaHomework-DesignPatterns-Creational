import java.util.ArrayList;
import java.util.List;

public class Filter {
    private int f;

    public Filter(int f) {
        this.f = f;
    }

    public List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (Integer value : list) {
            if (value < f) {
                logger.log("Элемент \"" + value + "\" не проходит");
                continue;
            }
            logger.log("Элемент \"" + value + "\" проходит");
            result.add(value);
        }
        return result;
    }
}
