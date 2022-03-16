    @Override
    public void onClick( View b ) {
        try {
            int i = 0;
            int bid = b.getId();
            if( bid == R.id.add_new_type ) {
                i = ck.addTypeColor();
                addView( i, ck.ftColors.get( i - 1 ) );
                return;
            }
            clicked = (Integer)b.getTag();
            if( clicked != null ) {
                int color = clicked == 0 ? ck.fgrColor : ck.ftColors.get( clicked - 1 ).color;
                new RGBPickerDialog( this, this, color, 0 ).show();
            }
        } catch( Exception e ) {
            Log.e( TAG, null, e );
        }        
    }

