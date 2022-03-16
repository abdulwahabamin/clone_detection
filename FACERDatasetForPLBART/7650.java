    @Override
    protected void onLayout( boolean changed, int l, int t, int r, int b ) {
        try {
            //Log.v( "PanelsView", "l:" + l + " t:" + t + " r:" + r + " b:" + b + " ch:" + changed );
            //Log.v( "PanelsView", "rv mw:" + rv.getMeasuredWidth() );
            lv.layout(  l, t, panel_width, b );
            dv.layout(  l + panel_width, t, l + panel_width + 1, b );
            rv.layout(  l + panel_width + 1, t, r, b );
        } catch( Exception e ) {
            e.printStackTrace();
        } catch( Error e ) {
            e.printStackTrace();
        }
    }

