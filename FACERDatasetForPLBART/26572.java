    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle tool bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        if(id == R.id.action_share){
            if (downloadSucessfull){
                String sharebody = "Wetterbericht für " + city + ", " + CountryCode + ": " + WeatherHelper.getDescription() + " bei " + String.format("%.1f", WeatherHelper.getTemperature_max()) + "°";
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, sharebody);
                startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.share_using)));
                return true;
            } else{
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

