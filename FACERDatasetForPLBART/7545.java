    public final int getNumItemsSelectedOrChecked() {
        int checked = getNumItemsChecked();
        if( checked > 0 )
            return checked;
        return getSelection( false ) >= 1 ? 1 : 0; // excluding the parent (0)
                                                   // item
    }

