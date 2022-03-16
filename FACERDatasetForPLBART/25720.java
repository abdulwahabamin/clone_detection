    public static WeatherRepository getInstance() {

        for (;;) {
            WeatherRepository current = INSTANCE_REFERENCE.get();
            if (current != null) {
                return current;
            }
            current = new WeatherRepository();
            if (INSTANCE_REFERENCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }

