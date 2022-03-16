    /**
     * 拆分气温
     *
     * @param temperature 如：5℃~-3℃
     * @return {5, 3}
     */
    private int[] splitTemperature(String temperature) {
        if (temperature != null && temperature.contains("~")) {
            if (temperature.contains("℃")) {
                temperature = temperature.replaceAll("℃", "");
            }
            String[] temps = temperature.split("~");
            return new int[]{Integer.parseInt(temps[0]), Integer.parseInt(temps[1])};
        } else {
            return null;
        }
    }

