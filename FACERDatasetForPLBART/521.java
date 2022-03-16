    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_about) {
            displayAboutDialog();
            return true;
        } else if(id == R.id.menu_share){
            ToastUtil.showToast(mContext, getString(R.string.menu_share));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

