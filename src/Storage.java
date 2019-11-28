import java.util.ArrayDeque;
import java.util.Collection;

public class Storage<T> {

    private final int storageLength;
    private final int storageHeight;
    private final int storageWidth;
    private final int maxLoadableWeight; // The max weight the flatbed can take.
    private int currentLoadedWeight;
    private Collection<? extends T> storedItems;


    public Storage(int storageLength, int storageHeight, int storageWidth, int maxLoadableWeight) {
        this.storageLength = storageLength;
        this.storageHeight = storageHeight;
        this.storageWidth = storageWidth;
        this.maxLoadableWeight = maxLoadableWeight;
        currentLoadedWeight = 0;

    }
}
