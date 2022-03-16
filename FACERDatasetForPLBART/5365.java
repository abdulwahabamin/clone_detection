    void setAppShortcuts(){
        if(Build.VERSION.SDK_INT>=25) {
            shortcutManager = getSystemService(ShortcutManager.class);
            if (shortcutManager.getDynamicShortcuts().size() == 0) {
                Intent i = new Intent(SplashScreen.this, QuickAccess.class);
                i.setAction(Intent.ACTION_MAIN);
                i.putExtra("select_data", QuickAccess.IMAGES);
                ShortcutInfo imageShortcut = new ShortcutInfo.Builder(SplashScreen.this, "images")
                        .setShortLabel("Images")
                        .setLongLabel("Explore images")
                        .setIcon(Icon.createWithResource(SplashScreen.this, R.drawable.picture))
                        .setIntent(i)
                        .build();

                shortcutManager.setDynamicShortcuts(Arrays.asList(imageShortcut));

                i.putExtra("select_data", QuickAccess.AUDIO);
                ShortcutInfo musicShortcut = new ShortcutInfo.Builder(SplashScreen.this, "music")
                        .setShortLabel("Music")
                        .setLongLabel("Explore music")
                        .setIcon(Icon.createWithResource(SplashScreen.this, R.drawable.music))
                        .setIntent(i)
                        .build();
                shortcutManager.addDynamicShortcuts(Arrays.asList(musicShortcut));

                i.putExtra("select_data", QuickAccess.VIDEO);
                ShortcutInfo videoShortcut = new ShortcutInfo.Builder(SplashScreen.this, "video")
                        .setShortLabel("Videos")
                        .setLongLabel("Explore videos")
                        .setIcon(Icon.createWithResource(SplashScreen.this, R.drawable.video))
                        .setIntent(i)
                        .build();
                shortcutManager.addDynamicShortcuts(Arrays.asList(videoShortcut));

                i.putExtra("select_data", QuickAccess.DOCUMENTS);
                ShortcutInfo documentShortcut = new ShortcutInfo.Builder(SplashScreen.this, "document")
                        .setShortLabel("Documents")
                        .setLongLabel("Explore documents")
                        .setIcon(Icon.createWithResource(SplashScreen.this, R.drawable.file))
                        .setIntent(i)
                        .build();
                shortcutManager.addDynamicShortcuts(Arrays.asList(documentShortcut));
            }
        }
    }

