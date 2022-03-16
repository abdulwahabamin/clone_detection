    /**
     * {@inheritDoc}
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // If the item is selected, then just open it like ActivityChooserView
        // If there is no parent, that means an internal call. In this case ignore it.
        if (parent != null && mGrid.isItemChecked(position)) {
            this.mDialog.getButton(DialogInterface.BUTTON_POSITIVE).performClick();

        } else {
            mGrid.setItemChecked(position, true);

            // Internal editors can be associated
            boolean isPlatformSigned = AndroidHelper.isAppPlatformSignature(this.mContext);
            if (isPlatformSigned && this.mAllowPreferred) {
                ResolveInfo ri = getSelected();
                this.mRemember.setVisibility(
                        IntentsActionPolicy.isInternalEditor(ri) ?
                               View.INVISIBLE :
                               View.VISIBLE);
            }

            // Enable action button
            this.mDialog.getButton(DialogInterface.BUTTON_POSITIVE).setEnabled(true);
        }
    }

