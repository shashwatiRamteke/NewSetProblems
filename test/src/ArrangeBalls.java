import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrangeBalls {

    public static void main(String[] args) {
        List<String> balls = Arrays.asList("G", "B", "G", "G", "R", "B", "R", "G");
        int blueptr = 0;
        int greenptr = -1;
        int redptr = -1;


        for(blueptr = 0;blueptr<balls.size();blueptr++){
            if(balls.get(blueptr).equals("G")){
                greenptr++;
                Collections.swap(balls,greenptr,blueptr);
            }
            if(balls.get(blueptr).equals("R")){
                redptr++;
                Collections.swap(balls,redptr,blueptr);
                blueptr=greenptr;
            }
        }

        balls.stream().forEach(System.out::println);

    }
}
