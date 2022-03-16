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
        return popup;
    }

