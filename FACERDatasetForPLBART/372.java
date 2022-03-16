    public MessageFileAdapter(Context c, ArrayList<String> nom, ArrayList<String> intitu, ArrayList<String> m) {
        super(c,R.layout.file_message, nom);

        this.listNom=nom;
        this.context=c;
        this.listIntitule=intitu;
        this.macadresse=m;
    }

