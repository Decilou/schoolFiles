package Model;

import java.util.Collection;


/**
 * A class for a storage space.
 *
 * @param <T>
 */

// TODO: Implement this solution in all classes with some kind of storage.
public class Storage<T> {

    private final int storageLength;
    private final int storageHeight;
    private final int storageWidth;
    private final int maxLoadableWeight; // The max weight the flatbed can take.
    private int currentLoadedWeight;
    private Collection storedItems;


    public Storage(Collection storedItems, int storageLength, int storageHeight, int storageWidth, int maxLoadableWeight) {
        this.storageLength = storageLength;
        this.storageHeight = storageHeight;
        this.storageWidth = storageWidth;
        this.maxLoadableWeight = maxLoadableWeight;
        currentLoadedWeight = 0;
        this.storedItems = storedItems;
    }

    public Collection getStoredItems() {
        return storedItems;
    }
}
