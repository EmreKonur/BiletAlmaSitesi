package entity;


public class Documents {
    private Long id;
    private String filePath;
    private String fileName;
    private String fileType;

    public Documents() {
    }

    public Documents(Long id, String filePath, String fileName, String fileType) {
        this.id = id;
        this.filePath = filePath;
        this.fileName = fileName;
        this.fileType = fileType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    
}