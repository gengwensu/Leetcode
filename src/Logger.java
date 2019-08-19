/*[LeetCode]359 Logger Rate Limiter 记录速率限制器



        Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

        Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

        It is possible that several messages arrive roughly at the same time.

        Example:

        Logger logger = new Logger();

// logging string "foo" at timestamp 1
        logger.shouldPrintMessage(1, "foo"); returns true;

// logging string "bar" at timestamp 2
        logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
        logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
        logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
        logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
        logger.shouldPrintMessage(11,"foo"); returns true;*/

import java.util.HashMap;
import java.util.Map;

public class Logger {
    private Map<String, Integer> hm;

    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));//true
        System.out.println(logger.shouldPrintMessage(2, "bar"));//true
        System.out.println(logger.shouldPrintMessage(3, "foo"));//false
        System.out.println(logger.shouldPrintMessage(8, "bar"));//false
        System.out.println(logger.shouldPrintMessage(10, "foo"));//false
        System.out.println(logger.shouldPrintMessage(11, "foo"));//true
    }


    Logger() {
        hm = new HashMap<>();
    }

    boolean shouldPrintMessage(int timestamp, String message) {
        if (hm.containsKey(message)) {
            int last = hm.get(message);
            if ((timestamp - last) < 10) return false;
        }
        hm.put(message, timestamp);
        return true;
    }
}
