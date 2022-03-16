    private final Drawable createButtonStates() {
        try {
            float bbb = Utils.getBrightness( ck.btnColor );
            int sc = Utils.setBrightness( ck.btnColor, 0.2f );            
            StateListDrawable states = new StateListDrawable();
            GradientDrawable bpd = Utils.getShadingEx( ck.btnColor, 1f );
            bpd.setStroke( 1, sc );
            bpd.setCornerRadius( 2 );
            GradientDrawable bnd = Utils.getShadingEx( ck.btnColor, bbb < 0.4f ? 0f : 0.6f );
            bnd.setStroke( 1, sc );
            bnd.setCornerRadius( 2 );
            states.addState(new int[] { android.R.attr.state_pressed }, bpd );
            states.addState(new int[] { }, bnd );
            return states;
        }
        catch( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

