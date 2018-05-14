package netty.AttributeMapTest.client;

import io.netty.util.AttributeKey;

/**
 * @author Aria E-mail:wangzhen36@meituan.com
 * @time on 2018/2/7.
 */
public class AttributeMapConstant{
        public static final AttributeKey<NettyChannel> NETTY_CHANNEL_KEY = AttributeKey.valueOf("channel");
}
