package string;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    private String[] stream;
    private int pointer;

    public OrderedStream(int n) {
        stream = new String[n];
        pointer = 0;
    }

    public List<String> insert(int idKey, String value) {
        // Insert the value into the stream array
        stream[idKey - 1] = value;

        // Check if the next values are also available in the stream
        List<String> chunk = new ArrayList<>();
        while (pointer < stream.length && stream[pointer] != null) {
            chunk.add(stream[pointer]);
            pointer++;
        }

        return chunk;
    }
}



class OrderedStreamSolution{
    public static void main(String[] args) {
        OrderedStream os = new OrderedStream(5);
        os.insert(3, "ccccc");
        os.insert(1, "aaaaa");
        os.insert(2, "bbbbb");
        os.insert(5, "eeeee");
        os.insert(4, "ddddd");
    }
}