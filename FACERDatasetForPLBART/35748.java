    private String getAqiQuality(int aqi) {

        if (aqi <= 50) {
            return "优";
        } else if (aqi > 50 && aqi <= 100) {
            return "良";
        } else if (aqi > 100 && aqi <= 150) {
            return "轻度污染";
        } else if (aqi > 150 && aqi <= 200) {
            return "中度污染";
        } else if (aqi > 200 && aqi <= 300) {
            return "�?度污染";
        } else if (aqi > 300 && aqi < 500) {
            return "严�?污染";
        } else if (aqi >= 500) {
            return "污染爆表";
        }
        return null;
    }

