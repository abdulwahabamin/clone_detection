    /**
     * 获�?�Serial Number
     */
    public static String getSerialNumber() {
        String serial;
        try {
            serial = Build.class.getField("SERIAL").get(null).toString();
        } catch (Exception exception) {
            //serial需�?一个�?始化
            serial = "serial"; // �?便一个�?始化
        }
        return object2String(serial, Build.UNKNOWN);
    }

