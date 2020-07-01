package api.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal();

    static {
        if (threadLocal.get() == null) {
            threadLocal.set(new HashMap<>());
        }
    }

    private ScenarioContext() {
    }

    public static void setContext(Context key, Object value) {
        threadLocal.get().put(key.toString(), value);
    }

    public static Object getContext(Context key) {
        return threadLocal.get().get(key.toString());
    }


    public enum Context {
     USER_NAME;
    }

}


