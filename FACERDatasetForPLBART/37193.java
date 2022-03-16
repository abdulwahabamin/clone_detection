    public static String formatCity(String city, String area) {
        if (!TextUtils.isEmpty(area) && (area.endsWith("市") || area.endsWith("县"))) {
            if (area.length() > 2) {
                area = area.substring(0, area.length() - 1);
            }
            return area;
        } else {
            return city.replace("市", "").replace("盟", "");
        }
    }

