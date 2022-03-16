    public static ColorDrawable getAlphaBackground50(Activity activity) {
        if(ACT.backgroundAlpha50 ==null) {
            ACT.backgroundAlpha50 = new ColorDrawable(activity.getResources().getColor(R.color.browse_brand));
            ACT.backgroundAlpha50.setAlpha(80);
        }
        return ACT.backgroundAlpha50;
    }

