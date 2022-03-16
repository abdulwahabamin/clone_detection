    private void populateSongs(List<SongDTO> songsList, int songPosition) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            viewPager.setAdapter(new SongFragmentPager(this.getSupportFragmentManager(),
                    songsList));
            if (songPosition > 0) {
                viewPager.setCurrentItem(songPosition, true);
            }
        }
    }

