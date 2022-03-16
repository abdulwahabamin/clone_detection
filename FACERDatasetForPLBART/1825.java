    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            openProfile();
        }
        else if(id==R.id.action_share)
        {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "BlueChat");
            String sAux = "\nCheck this cool Bluetooth chat app\n\n";
            sAux = sAux + "https://play.google.com/store/apps/details?id=com.justadeveloper96.bluechat \n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "Share on"));
        }else if(id==R.id.action_like)
        {

            Uri marketUri = Uri.parse("market://details?id=" + getPackageName());
            Utils.log("market url"+marketUri.toString());
            startActivity(new Intent(Intent.ACTION_VIEW).setData(marketUri));
           /* Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.justadeveloper96.bluechat"));
            startActivity(intent);*/
        }
        return true;
    }

