package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
                .map(numero -> numero * 3)
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
        
        /*
The method map is an intermediate operation that produces a new stream that is the result of applying a Function to each element in the original stream.
        *
         */
        
        numsAux = nums.stream()
                .map((aux) -> {
                    aux = aux * 5;
                    return aux;
                })
                .collect(Collectors.toList());
        numsAux.stream()
                .forEach(aux -> System.out.println("Números multiplicados por 5: " + aux));
        
/*
The limit method returns a Stream of the first n elements of the original Stream.
 */
        numsAux = nums.stream()
                .limit(3)
                .collect(Collectors.toList());
        
        numsAux.stream()
                .forEach(aux -> System.out.println("Somente os três primeiros: " + aux));
        
        /*
        The skip method skips the first n elements in the original Stream.
         */
        
        numsAux = nums.stream()
                .skip(2)
                .collect(Collectors.toList());
        
        numsAux.stream()
                .forEach(aux -> System.out.println("Evitando os dois primeiros: " + aux));
        
        IntStream.range(5, 10)
                .forEach(aux -> System.out.println("IntStream.range: " + aux));
    
    
        /*
reduce()
The reduce operation allows us to produce a single result from a stream of elements. To do this we repeatedly apply a combining operation the elements in the collection.
         */
        
        int reduceAux = nums.stream()
                .reduce(0, (a, b) -> a + b);
        
        System.out.println("Reduce: " + reduceAux);
        
        /*
generate()
We pass in a Generator to the generate function of Stream to generate an infinite or unbounded Stream of objects.
         */
        
        Stream.generate(Math::random).limit(20).forEach(System.out::println);
        
        /*
iterator()
This method takes in two parameters, and initial value called seed and a function that generates the next element using the previous value.
         */
        
        Stream.iterate(4, i -> i * 2)
                .limit(10)
                .forEach(System.out::println);


    /*
Parallel Streams
Creating parallel code is Java is extremely easy with streams. Just add parallel() after a stream declaration and you have a parallel stream! No more messing around with confusing configurations.

Parallel streams can greatly speed up computing time, but they can only be used on stateless, associative, and non-interfacing operations. Stateless means that the operation on one element does not effect other ones, associative means that the order of operators does not matter, and non-interfacing means that is doesn’t effect the underlying data.
     */
        
        nums.stream()
                .parallel()
                .filter(aux -> aux % 2 == 0)
                .forEach(System.out::println);
        
    }
    
    
}
