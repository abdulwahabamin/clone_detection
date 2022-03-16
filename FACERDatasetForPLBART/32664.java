        private Intent fDroidIntent() {
            String ACTION_VIEW = Intent.ACTION_VIEW;
            String fDroidWebUri = String.format(Constants.F_DROID_WEB_URI,
                                                getActivity().getPackageName());

            return new Intent(ACTION_VIEW, Uri.parse(fDroidWebUri));
        }

