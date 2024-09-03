/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;


public class OpenPdf {
//    public static void openById(String id){
//        try{
//            if((new File("E:\\PDF\\"+id+".pdf")).exists()){
//                Process p = Runtime
//                        .getRuntime()
//                        .exec("rundll32 url.dll,FileProtocolHandler E:\\PDF\\" + id + ".pdf");
//            }
//        }
//        catch(Exception e){
//            JOptionPane.showMessageDialog(null,"File not exist");
//        }
        
         public static void openPdfFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
        

//        File pdfFile = new File("E:\\PDF\\" + id + ".pdf");
//        if (pdfFile.exists()) {
//           Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler E:\\PDF\\" + id + ".pdf");
//        } else {
//            JOptionPane.showMessageDialog(null, "PDF file not found");
//        }

//        Desktop desktop = Desktop.getDesktop();
//        File pdfFile =new File("E:\\PDF\\"+id+".pdf");
//        if (pdfFile.exists()) {
//        desktop.open(pdfFile);
//    } else {
//        JOptionPane.showMessageDialog(null, "PDF file not found");
//        }
//    }
//}
