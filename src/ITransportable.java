public interface ITransportable {

    boolean isLoaded();

    void unloadFromTransporter();

    void loadOnTransporter();

    void updateTransportable();

    void placeUnloadedTransportableInWorld();


}
