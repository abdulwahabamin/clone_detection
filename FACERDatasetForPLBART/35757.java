    /**
     * 拆分气温
     *
     * @param temperatureRange 如：-6~2°
     * @return {-6, 2}
     */
    private int[] splitTemperature(String temperatureRange) {
        if (temperatureRange != null && temperatureRange.contains("~")) {
            if (temperatureRange.contains("°")) {
                temperatureRange = temperatureRange.replaceAll("°", "");
            }
            String[] temps = temperatureRange.split("~");
            return new int[]{Integer.parseInt(temps[0]), Integer.parseInt(temps[1])};
        } else {
            return null;
        }
    }

