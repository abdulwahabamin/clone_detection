 	public static void openCurrentState(Activity activity) {
		Class<? extends BFragment> fragment = null;

		BLog.e("STATE", "openCurrentState: " + State.getCurrentSection() + ", size: " + State.getSectionsSize());
		switch (State.getCurrentSection()) {
		//case State.SECTION_TWITTER:
		//	fragment = new TwitterHomeFragment();
		//	break;
			case State.SECTION_FILE_EXPLORE:
				fragment = FileExploreFragment.class;
				break;
			case State.SECTION_FILE_EXPLORE_DELETE:
				fragment = FilesDeleteFragment.class;
				break;
			case State.SECTION_FILE_CREATE_ARCHIVE:
				fragment = FilesArchiveFragment.class;
				break;

			case State.SECTION_FILE_EXPLORE_ARCHIVE:
				fragment = ZipExploreFragment.class;
				break;
			case State.SECTION_SEARCH:
				fragment = SearchFragment.class;
				break;
			case State.SECTION_SEARCH_SHORTCUT:
				fragment = ShortcutSearchFragment.class;
				break;
			case State.SECTION_IMAGES_SLIDER:
				fragment = ImagesSliderFragment.class;
				break;
            case State.SECTION_POP_FOLDER_CHOOSER:
                fragment = FolderChooseFragment.class;
                break;
			case State.SECTION_SETTINGS:
				fragment = SettingsHomeTabbedFragment.class;
				break;
			case State.SECTION_TEXT_FILE_VIEW:
				fragment= TextFileFragment.class;
			default:
				fragment = FileExploreFragment.class;
				break;
		}
		if (fragment != null) {
			Bgo.openFragment(activity, fragment);
		}
	}

