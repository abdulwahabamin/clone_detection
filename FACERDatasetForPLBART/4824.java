        @Override
        public void onClick(View v) {
            //Log.e("FOLDER","open popchoosefolder");
            amb.done();
            State.addToState(State.SECTION_POP_FOLDER_CHOOSER, new StateObject(StateObject.STRING_FILE_PATH, fm.getCurrentDirectory().getAbsolutePath()));
            Bgo.openFragmentBackStack(activity, new FolderChooseFragment());
        }

