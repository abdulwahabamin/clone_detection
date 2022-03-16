    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==BlueHelper.REQUEST_ENABLE_BT && resultCode==RESULT_CANCELED)
        {
            Utils.log("Bluetooth Needed");
            return;
        }

        if (requestCode==BlueHelper.REQUEST_ENABLE_BT && resultCode==RESULT_OK)
        {
            if (save.isEnabled())
            {
                saveData();
            }
        }
    }

