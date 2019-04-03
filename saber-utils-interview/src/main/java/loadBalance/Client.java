package loadBalance;

import java.nio.channels.Channel;
import java.util.List;

/**
 * @author Aria
 * @time on 2019-04-03.
 */
public interface Client<C extends Channel> {



    void open();

    void close();


    void setActive(boolean active);

    boolean isActive();

    boolean isWritable();

    boolean isClosed();

    List<C> getChannels();

    String getHost();

    String getAddress();

    int getPort();

    String getProtocol();

}
