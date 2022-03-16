    private void updateSoundEffectItem(Menu menu) {
        MenuItem item = menu.findItem(R.id.effect_panel);
        if (item != null) {
            Intent intent = new Intent(AudioEffect.ACTION_DISPLAY_AUDIO_EFFECT_CONTROL_PANEL);
            item.setVisible(getPackageManager().resolveActivity(intent, 0) != null);
        }
    }

