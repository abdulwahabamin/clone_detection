    private final LayerDrawable createSeekBarDrawable( int fg_color ) {
        LayerDrawable ld = null;
        try {
            Drawable[] list = new Drawable[2];
            final int bg_color = 0xff9d9e9d;
            GradientDrawable bg = Utils.getShadingEx( atRight ? fg_color : bg_color, 0.6f );
            bg.setCornerRadius( 5 );
            list[0] = bg;
            GradientDrawable fg = Utils.getShadingEx( atRight ? bg_color : fg_color, 0.6f );
            fg.setCornerRadius( 5 );
            list[1] = new ClipDrawable( fg, Gravity.LEFT, ClipDrawable.HORIZONTAL );
            ld = new LayerDrawable( list );
            ld.setId( 0, android.R.id.background );
            ld.setId( 1, android.R.id.progress );
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        return ld;
    }

