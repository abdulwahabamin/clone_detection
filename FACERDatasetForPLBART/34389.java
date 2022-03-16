        private Intent googlePlayIntent() {
            String ACTION_VIEW = Intent.ACTION_VIEW;
            String googlePlayAppUri = String.format(Constants.GOOGLE_PLAY_APP_URI,
                                                    getActivity().getPackageName());
            String googlePlayWebUri = String.format(Constants.GOOGLE_PLAY_WEB_URI,
                                                    getActivity().getPackageName());

            Intent intent = new Intent(ACTION_VIEW, Uri.parse(googlePlayAppUri));
            if (mPackageManager.resolveActivity(intent, 0) == null) {
                intent = new Intent(ACTION_VIEW, Uri.parse(googlePlayWebUri));
            }

            return intent;
        }

