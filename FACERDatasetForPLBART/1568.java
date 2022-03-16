    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_scan) {
            if (chatSetUpViewModel.scanDevice()){
                chatSetUpViewModel.scanDevice();
                return true;
            }
                return false;
        }
        return super.onOptionsItemSelected(item);
    }

