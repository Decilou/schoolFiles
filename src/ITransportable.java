public interface ITransportable {

    boolean isLoaded();

    void unload();

    void load();

    void updateTransportable();

    void placeUnloadedTransportableInWorld();


}
