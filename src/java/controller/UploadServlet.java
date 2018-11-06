/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.User;
import javax.servlet.annotation.WebServlet;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import dataaccess.UserDB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;


@WebServlet(
    name = "UploadServlet",
    urlPatterns = {"/uploadFile"}
)

@MultipartConfig
public class UploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    public static final String UPLOAD_DIRECTORY = "upload";
    public static final String DEFAULT_FILENAME = "default.file";
    
    public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;
    public static final int MAX_FILE_SIZE = 1024 * 1024 * 40;
    public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50;
    
    private static final String API_KEY = "316524138981326";
    private static final String API_SECRET = "BTqszUROATiTSOlv2LOktd4gIFc";
    private static final String CLOUD_NAME = "minitwitter";
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", CLOUD_NAME,
            "api_key", API_KEY,
            "api_secret", API_SECRET));
        
        String filePath = "";
        
        //Upload file to this web server
        if (ServletFileUpload.isMultipartContent(request)) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(MEMORY_THRESHOLD);
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setFileSizeMax(MAX_FILE_SIZE);
            upload.setSizeMax(MAX_REQUEST_SIZE);
            String uploadPath = getServletContext().getRealPath("/") + UPLOAD_DIRECTORY;
            
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            
            try {
                List<FileItem> formItems = upload.parseRequest(request);

                if (formItems != null && formItems.size() > 0) {
                    for (FileItem item : formItems) {
                        if (!item.isFormField()) {
                            String fileName = new File(item.getName()).getName();
                            filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            item.write(storeFile);
                        }
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        
        //Get file just uploaded and upload to cloudinary, store url to DB
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        String uploadType = (String) session.getAttribute("uploadType");
        System.out.println("uploadTYPE: " + uploadType);
        String imageURL = "";
        if(uploadType != null){
            String public_id = uploadType + File.separator + uploadType + "_" + user.getUserID();
            Map params = ObjectUtils.asMap(
                "public_id", public_id, 
                "overwrite", true,
                "resource_type", "image"         
            );
            File profile_file = new File(filePath);
            Map uploadResult = cloudinary.uploader().upload(profile_file, params);
            imageURL = (String) uploadResult.get("secure_url");
        }
        
        // Save profileURL to the database
        if(uploadType.equals("profile")){
            UserDB.uploadProfileImage(user.getUserID(), imageURL);
        }
        else if(uploadType.equals("cover")){
            UserDB.uploadCoverImage(user.getUserID(), imageURL);
        }
        
        //Update user objct
        user = UserDB.searchUsername(user.getUsername());
        session.setAttribute("user", user);
        
        //Delete the file in the web server
        File profile_file = new File(filePath);
        profile_file.delete();
        
    getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
    }
}
