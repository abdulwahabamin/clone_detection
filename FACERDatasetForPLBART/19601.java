        @Override
        public boolean onPreferenceClick(Preference preference) {

            Uri webpage = Uri.parse("market://details?id=com.aniruddhc.acemusic.player");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            {
                startActivity(intent);
                return false;
            }
        }

