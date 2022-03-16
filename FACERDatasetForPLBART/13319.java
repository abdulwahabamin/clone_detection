    /**
     * Method that creates and returns a {@list ListPopupWindow} reference.
     *
     * @param context The current context
     * @param adapter The adapter to associate with the popup
     * @param anchor The view that is used as an anchor to show the popup
     * @return ListPopupWindow The {@list ListPopupWindow} reference
     */
    public static ListPopupWindow createListPopupWindow(
            Context context, final ListAdapter adapter, View anchor) {
        final ListPopupWindow popup = new ListPopupWindow(context);
        popup.setAdapter(adapter);
        popup.setContentWidth(context.getResources().getDimensionPixelSize(R.dimen.popup_width));
        popup.setAnchorView(anchor);
        popup.setModal(true);

        // HACK: set the height to the size of the device screen width or height depending on
        // which is smaller.
        // Because we are handling the orientation change instead of letting
        // android do its thing, this never redraws. If we remove the orientation
        // change, then all the other popup dialogs break when rotating.
        // This isn't perfect, but without some significant changes to this app we cannot
        // properly do this.
        // Get the screen size, determine what number is lower, use that for the height
        DisplayMetrics dM = context.getResources().getDisplayMetrics();
        float width = dM.widthPixels / dM.density;
        float height = dM.heightPixels / dM.density;
        popup.setHeight((int)Math.min(height, width));

        return popup;
    }

