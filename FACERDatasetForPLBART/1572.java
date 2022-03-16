    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Check what request we’re responding to//
        if (requestCode == ACTION_REQUEST_DISCOVERABLE ) {

            //If the request was successful…//
            if (resultCode == Activity.RESULT_OK) {
                //...then display the following toast.//
                Toast.makeText(UserList.this, "device is discoverable", Toast.LENGTH_SHORT).show();
            }

            //If the request was unsuccessful...//
            if (resultCode == RESULT_CANCELED) {

                //...then display this alternative toast.//
                Toast.makeText(UserList.this, "An error occurred while attempting to enable Bluetooth make the device discoverable",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }

