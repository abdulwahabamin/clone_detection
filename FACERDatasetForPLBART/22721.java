    public void setEmptyView(Context context, View emptyView, String text) {
        this.emptyView = emptyView;
        ((TextView) emptyView).setText(text);

        MaterialDrawableBuilder builder = MaterialDrawableBuilder.with(context)
                .setIcon(MaterialDrawableBuilder.IconValue.MUSIC_NOTE)
                .setColor(Config.textColorPrimary(context, Helpers.getATEKey(context)))
                .setSizeDp(30);

        ((TextView) emptyView).setCompoundDrawables(null, builder.build(), null, null);
    }

