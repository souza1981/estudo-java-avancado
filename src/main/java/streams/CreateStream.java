package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        
        //Criando stream de uma lista existente usando arrays.stream()
        
        Stream<Integer> streamNums = nums.stream();
        
        //Criando uma stream de valores
        
        streamNums = Stream.of(1,2,3);
    }
}
