    public void onGenerated(/* Palette palette */) {
        //try {
            //bgDrawable = new ColorDrawable(palette.getVibrantColor().getRgb());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                mView.setBackground(bgDrawable);
            else
                mView.setBackgroundDrawable(bgDrawable);
        //} catch (Exception e) {
            //e.printStackTrace();
            //mView.setBackgroundColor(0x99555555);
        //}

    }

