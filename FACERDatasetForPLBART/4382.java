    public static ColorDrawable getAlphaBackground100(Activity activity) {
        if(ACT.backgroundAlpha100 ==null) {
            ACT.backgroundAlpha100 = new ColorDrawable(activity.getResources().getColor(R.color.browse_brand));
            ACT.backgroundAlpha100.setAlpha(0);
        }
        return ACT.backgroundAlpha100;
    }

