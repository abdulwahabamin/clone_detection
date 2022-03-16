    private void handleCommand(String command) {
        int currentSongIndex = viewPager.getCurrentItem();
        int lastSongIndex = viewPager.getAdapter().getCount() - 1;

        switch (command) {
            case "next":
                if (currentSongIndex == lastSongIndex) {
                    viewPager.setCurrentItem(0);
                } else {
                    viewPager.setCurrentItem(currentSongIndex + 1);
                }
                break;
            case "previous":
                if (currentSongIndex == 0) {
                    viewPager.setCurrentItem(lastSongIndex);
                } else {
                    viewPager.setCurrentItem(currentSongIndex - 1);
                }
                break;
        }
    }

