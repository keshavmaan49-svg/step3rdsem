public class AccessChecker {
    public enum Context {
        SAME_CLASS,
        SAME_PACKAGE,
        DIFFERENT_PACKAGE,
        SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE,
        SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE
    }

    public static boolean canAccess(String modifier, Context context) {
        switch (modifier.toLowerCase()) {
            case "public":
                return true;
            case "protected":
                return context == Context.SAME_CLASS ||
                       context == Context.SAME_PACKAGE ||
                       context == Context.SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE;
            case "default":
                return context == Context.SAME_CLASS ||
                       context == Context.SAME_PACKAGE;
            case "private":
                return context == Context.SAME_CLASS;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Testing Access Modifier Rules:");
        for (Context ctx : Context.values()) {
            System.out.printf("%-40s -> public: %b | protected: %b | default: %b | private: %b%n",
                    ctx,
                    canAccess("public", ctx),
                    canAccess("protected", ctx),
                    canAccess("default", ctx),
                    canAccess("private", ctx));
        }
    }
}
