
import java.util.ArrayList;

public class SortedList {

    private final ArrayList<String> items;

    public SortedList() {
        items = new ArrayList<>();
    }

    // Binary search for an item or its insertion position
    // Returns index if found, otherwise -(insertionPoint + 1)
    public int binarySearch(String target) {
        int low = 0;
        int high = items.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = items.get(mid).compareTo(target);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -(low + 1);
    }

    // Insert while maintaining alphabetical order
    public void add(String item) {
        int index = binarySearch(item);

        if (index < 0) {
            index = -(index + 1);
        }

        items.add(index, item);
    }

    public int size() {
        return items.size();
    }

    public String get(int index) {
        return items.get(index);
    }

    public String displayList() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < items.size(); i++) {
            result.append(i)
                    .append(": ")
                    .append(items.get(i))
                    .append("\n");
        }

        return result.toString();
    }
}
