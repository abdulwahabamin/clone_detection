    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Check what request we’re responding to//
        if (requestCode == ACTION_REQUEST_ENABLE) {

            //If the request was successful…//
            if (resultCode == Activity.RESULT_OK) {
                //...then display the following toast.//
                Toast.makeText(MainActivity.this, "Bluetooth has been enabled", Toast.LENGTH_SHORT).show();
                openUserList();
            }

            //If the request was unsuccessful...//
            if (resultCode == RESULT_CANCELED) {

                //...then display this alternative toast.//
                Toast.makeText(MainActivity.this, "An error occurred while attempting to enable Bluetooth",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }

