    /**
     * èŽ·å?–Serial Number
     */
    public static String getSerialNumber() {
        String serial;
        try {
            serial = Build.class.getField("SERIAL").get(null).toString();
        } catch (Exception exception) {
            //serialéœ€è¦?ä¸€ä¸ªåˆ?å§‹åŒ–
            serial = "serial"; // éš?ä¾¿ä¸€ä¸ªåˆ?å§‹åŒ–
        }
        return object2String(serial, Build.UNKNOWN);
    }

