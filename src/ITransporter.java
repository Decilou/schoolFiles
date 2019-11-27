
/**
 * Interface for all objects that can transport something.
 * A contract that all objects that want to transport something must implement.
 */
public interface ITransporter {

    //TODO: Create implementation for comparison of transporter and transportee.
    //TODO: If the dimensions fit, storage is not full and objects are still then it is valid to load. Not sure where to put the logic.
    boolean isValidToLoad(ITransportable object);
}
