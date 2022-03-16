	private static String getFragmentNameBystate(int STATE_) {
		String fragname = null;

		switch (STATE_) {

        case State.SECTION_SEARCH:
            fragname = SearchFragment.class.getName();
            break;
		case State.SECTION_SEARCH_SHORTCUT:
			fragname = ShortcutSearchFragment.class.getName();
			break;
		case State.SECTION_IMAGES_SLIDER:
			fragname = ImagesSliderFragment.class.getName();
			break;
		case State.SECTION_FILE_EXPLORE:
			fragname = FileExploreFragment.class.getName();
			break;
		case State.SECTION_FILE_EXPLORE_ARCHIVE:
			fragname = ZipExploreFragment.class.getName();
			break;
		case State.SECTION_FILE_CREATE_ARCHIVE:
			fragname = FilesArchiveFragment.class.getName();
			break;
		case State.SECTION_FILE_EXPLORE_DELETE:
			fragname = FilesDeleteFragment.class.getName();
			break;
        case State.SECTION_POP_FOLDER_CHOOSER:
            fragname = FolderChooseFragment.class.getName();
            break;

            case State.SECTION_TEXT_FILE_VIEW:
                fragname = TextFileFragment.class.getName();
                break;
		case State.SECTION_SETTINGS:
			fragname = SettingsHomeTabbedFragment.class.getName();
			break;


		default:
			fragname = FileExploreFragment.class.getName();
			break;


		}
		//Log.e("ST", "GET getFragmentNameBystate(): "+fragname);
		return fragname;
	}

