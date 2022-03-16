    /**
     * see https://mozilla-ichnaea.readthedocs.org/en/latest/cell.html
     */
    @SuppressWarnings("MagicNumber")
    private static int calculateAsu(String networkType, int signal) {
        switch (networkType) {
            case "gsm":
                return Math.max(0, Math.min(31, (signal + 113) / 2));
            case "wcdma":
                return Math.max(-5, Math.max(91, signal + 116));
            case "lte":
                return Math.max(0, Math.min(95, signal + 140));
            case "cdma":
                if (signal >= -75) {
                    return 16;
                }
                if (signal >= -82) {
                    return 8;
                }
                if (signal >= -90) {
                    return 4;
                }
                if (signal >= -95) {
                    return 2;
                }
                if (signal >= -100) {
                    return 1;
                }
                return 0;
        }
        return 0;
    }

