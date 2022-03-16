    private void editData() {
        Utils.log("edit data");
        if (!BlueHelper.getBluetoothAdapter().isEnabled())
        {
            BlueHelper.init(this);
            return;
        }

        name.setEnabled(true);
        editMode(true);
    }

