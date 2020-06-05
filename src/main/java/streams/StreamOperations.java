package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {
    
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        /*
forEach()
The forEach method is a terminal operator that loops over each each element in the stream and performs a function on it.
         */
        
        nums.stream().forEach(numero -> System.out.println("Número: " + numero));
        
        /*
peek()
The peek method is like the forEach method except that it is not terminal, which means that it returns a new stream after performing some function on each element.
         */
        
        nums.stream()
                .peek(numero -> System.out.println("Número: " + numero))
                .map(numero -> numero * 2)
                .forEach(System.out::println);

    /*
collect()
The collect method has already been used in the first two examples, but this method is what we use to get an object at the end of chained stream operations.
     */
    
        List<Integer> numsAux = nums.stream()
                .map(numero->numero * 3)
                .collect(Collectors.toList());
        
        numsAux.stream()
                .forEach(numero -> System.out.println("Número * 3: " + numero));
        
    /*
    filter()
The filter method produces a new stream that contains only the elements of the original stream that pass a given test (Predicate). You can chain multiple filter methods together or combine all the tests into one Predicate.
     */
    
        numsAux = nums.stream()
            .filter(numero -> numero % 2 == 0)
            .collect(Collectors.toList());
        
        numsAux.stream()
                .forEach(numero -> System.out.println("Números pares: " + numero));
    }

    
    
    
    

    
}
