    private void saveData() {
        Utils.log("save data");


        if (!BlueHelper.getBluetoothAdapter().isEnabled())
        {
            BlueHelper.init(this);
            return;
        }

        current_name= Utils.getText(name);
        name.setEnabled(false);
        editMode(false);
        BlueHelper.getBluetoothAdapter().setName(current_name);
        Utils.showToast(this,"Device name updated!");
    }

