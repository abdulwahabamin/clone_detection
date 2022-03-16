    public final static int setBrightness( int color, float drop ) {
        float[] hsv = new float[3];
        Color.colorToHSV( color, hsv );
        hsv[2] *= drop;
        return Color.HSVToColor( hsv );
    }

