    public static String getNameFromPermission(String permission) {

        String key = permission.toLowerCase();
        if (key.contains("storage")) {
            return "Storage";
        }
        if (key.contains("camera")) {
            return "Camera";
        }
        if (key.contains("phone") || key.contains("call")) {
            return "Call";
        }
        if (key.contains("location")) {
            return "Location";
        }

        String[] split = permission.split("\\.");
        return split[split.length - 1];
    }

