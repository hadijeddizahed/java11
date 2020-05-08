package stackoverflow;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class Question24 {
    public static void main(String[] args) {

        Random random = new Random(441287210);
        for(int i=0;i<10;i++)
            System.out.print(random.nextInt(5)+" ");

    }
}

@Getter
@AllArgsConstructor
class ProtectionSet{

    private List<UUID> resourceIds;
}