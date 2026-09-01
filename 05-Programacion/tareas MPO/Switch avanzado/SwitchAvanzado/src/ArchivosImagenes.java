public enum ArchivosImagenes {
    IMAGENES("jgp,png,gif");
    final String jpgs;
    ArchivosImagenes(String jpg){
        jpgs =jpg;
    }
    public String getJpgs(){return jpgs;}

    public enum ArchivosVideo {
        VIDEO("mp4,avi");
        final String mp4s;
        ArchivosVideo(String mp4) {
            mp4s = mp4;
        }
        public String getPdfs(){return mp4s;}
    }
    public enum ArchivosDocumentos{
        DOCUMENTOS("pdf, doc, txt");
        final String pdfs;
        ArchivosDocumentos(String pdf){
            pdfs=pdf;
        }
        public String getPdfs(){return pdfs;}
    }
    public enum ArchivosAudio {
        AUDIO("mp3, wav");
        final String mp3s;
        ArchivosAudio(String mp3) {
            mp3s = mp3;
        }
        public String getAudio(){return mp3s;}
    }
}

