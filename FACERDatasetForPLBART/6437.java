    public Drawable loadIcon(Context context) {
        if (derivedIcon != 0) {
            return context.getResources().getDrawable(derivedIcon);
        } else {
            return IconUtils.loadPackageIcon(context, authority, icon);
        }
    }

