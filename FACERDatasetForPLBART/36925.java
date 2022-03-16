    private int getUV(String str) {
        int uv = 0;
        try {
            uv = Integer.valueOf(str);
        } catch (NumberFormatException ignored) {
        }
        return (uv < 0) ? 0 : uv;
    }

