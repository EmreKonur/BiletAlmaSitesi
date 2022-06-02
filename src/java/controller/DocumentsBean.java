package controller;

import dao.DocumentsDAO;
import entity.Documents;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

@Named(value="documentsBean")
@SessionScoped
public class DocumentsBean implements Serializable {

    private Documents documents;
    private List<Documents> documentsList;
    private DocumentsDAO documentsDao;

    private Part doc;
    private final String uploadTo = "C:\\Users\\oguzh\\Documents\\NetBeansProjects\\Assets\\";

    public void upload() {
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());

            documents = this.getDocuments();
            documents.setFilePath(f.getParent());
            documents.setFileName(f.getName());
            documents.setFileType(doc.getContentType());

            this.getDocumentsDao().insert(documents);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Documents getDocuments() {
        if (this.documents == null) {
            this.documents = new Documents();
        }
        return documents;
    }

    public DocumentsDAO getDocumentsDao() {
        if (this.documentsDao == null) {
            this.documentsDao = new DocumentsDAO();
        }
        return documentsDao;
    }

    public void setDocumentsDao(DocumentsDAO documentsDao) {
        this.documentsDao = documentsDao;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public List<Documents> getDocumentsList() {
        this.documentsList = this.getDocumentsDao().findAll();
        return documentsList;
    }

    public void setDocumentsList(List<Documents> documentsList) {
        this.documentsList = documentsList;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

}