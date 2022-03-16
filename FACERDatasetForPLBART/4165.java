        @Override
        protected void onPostExecute(Boolean result) {
            GridView lastfiles = (GridView) getActivity().findViewById(R.id.nav_shortcuts);
            lastfilesadapter = new LastFilesAdapter(getActivity(),lastfiles,items);
            lastfiles.setAdapter(lastfilesadapter);
            lastfiles.refreshDrawableState();
        }

