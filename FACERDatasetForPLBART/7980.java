    public final static GradientDrawable getShadingEx( int color, float drop ) {
        try {
            int[] cc = new int[2];
            cc[0] = color;
            cc[1] = setBrightness( color, drop );
            return new GradientDrawable( GradientDrawable.Orientation.TOP_BOTTOM, cc );
        } catch( Throwable e ) {
            e.printStackTrace();
        }
        return null;
    }

