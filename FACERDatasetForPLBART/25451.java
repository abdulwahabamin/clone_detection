    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_now_playing) {
            if (MusicPlaybackService.isRunning()) {
                Intent intent = new Intent(AbstractMusicList.this, NowPlaying.class);
                intent.putExtra("From_Notification", true);
                startActivity(intent);
            } else {
                Toast.makeText(AbstractMusicList.this, R.string.nothing_playing, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        if (id == R.id.action_settings) {
            Intent intent = new Intent(AbstractMusicList.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_exit) {
            Intent msgIntent = new Intent(getBaseContext(), MusicPlaybackService.class);
            msgIntent.putExtra("Message", MusicPlaybackService.MSG_STOP_SERVICE);
            startService(msgIntent);
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(startMain);
            finish();
            return true;
        }
        if(id == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

