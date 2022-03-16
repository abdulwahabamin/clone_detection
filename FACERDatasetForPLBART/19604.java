        @Override
        public boolean onPreferenceClick(Preference preference) {
            Uri webpage = Uri.parse("http://www.apache.org/licenses/LICENSE-2.0");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            {
                startActivity(intent);
                return false;
            }

        }

