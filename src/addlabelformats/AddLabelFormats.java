/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addlabelformats;

import BusinessLogic.ReadFromFile;
import BusinessLogic.AddImage;
import entities.Device;
import entities.Fields;
import entities.ImageExample;
import entities.LabelFormat;
import entities.Size;
import entities.TemperatureFields;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Media Markt
 */
public class AddLabelFormats {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        Device d1 = new Device(1);
        d1.setDeviceName("Sm5500");
        
        Device d2 = new Device(2);
        d2.setDeviceName("Sm5100");
        
        Size s1 = new Size(1);
        s1.setWidth(40);
        s1.setHeight(46);
        
        Size s2 = new Size(2);
        s2.setWidth(40);
        s2.setHeight(62);
        
        Size s3 = new Size(3);
        s3.setWidth(60);
        s3.setHeight(49);
        
        Size s4 = new Size(4);
        s4.setWidth(60);
        s4.setHeight(60);
        
        Size s5 = new Size(5);
        s5.setWidth(60);
        s5.setHeight(62);
        
        Size s6 = new Size(6);
        s6.setWidth(60);
        s6.setHeight(70);
        
        Size s7 = new Size(7);
        s7.setWidth(60);
        s7.setHeight(73);
        
        Size s8 = new Size(8);
        s8.setWidth(60);
        s8.setHeight(80);
        
        Size s9 = new Size(9);
        s9.setWidth(60);
        s9.setHeight(90);
        
        Size s10 = new Size(10);
        s10.setWidth(60);
        s10.setHeight(100);
        
        Size s11 = new Size(11);
        s11.setWidth(60);
        s11.setHeight(120);
        
        Size s12 = new Size(12);
        s12.setWidth(80);
        s12.setHeight(80);
        
        Size s13 = new Size(13);
        s13.setWidth(80);
        s13.setHeight(100);
        
        Size s14 = new Size(14);
        s14.setWidth(80);
        s14.setHeight(120);
        
        Fields f1 = new Fields(1);
        f1.setFieldName("Ingrediënten");
        f1.setFieldCode("In");
        
        Fields f2 = new Fields(2);
        f2.setFieldName("Barcode");
        f2.setFieldCode("Bc");
        
        Fields f3 = new Fields(3);
        f3.setFieldName("Inpakdatum");
        f3.setFieldCode("Pd");
        
        Fields f4 = new Fields(4);
        f4.setFieldName("Speciale boodschap");
        f4.setFieldCode("Sm");
        
        Fields f5 = new Fields(5);
        f5.setFieldName("TGT datum");
        f5.setFieldCode("Ud");
        
        Fields f6 = new Fields(6);
        f6.setFieldName("UVD datum");
        f6.setFieldCode("Sd");
        
        Fields f7 = new Fields(7);
        f7.setFieldName("Bediende");
        f7.setFieldCode("Op");
        
        Fields f8 = new Fields(8);
        f8.setFieldName("Plu nummer");
        f8.setFieldCode("Pn");
        
        Fields f9 = new Fields(9);
        f9.setFieldName("Logo (klein)");
        f9.setFieldCode("Sl");
        
        Fields f10 = new Fields(10);
        f10.setFieldName("Logo (groot)");
        f10.setFieldCode("Sb");
        
        Fields f11 = new Fields(11);
        f11.setFieldName("Traceerbaarheid");
        f11.setFieldCode("Tr");
        
        Fields f12 = new Fields(12);
        f12.setFieldName("Traceerbaarheid - enkel lotnummer");
        f12.setFieldCode("Tl");
        
        Fields f13 = new Fields(13);
        f13.setFieldName("Kipwaarschuwing");
        f13.setFieldCode("Cw");
        
       
        
        Fields f14 = new Fields(14);
        f14.setFieldName("Verhitten tot in de kern");
        f14.setFieldCode("Ht");
        
        Fields f15 = new Fields(15);
        f15.setFieldName("Kalfsvlees jonger dan 8 maanden");
        f15.setFieldCode("Bt");
        
        Fields f16 = new Fields(20);
        f16.setFieldName("Kan sporen van sesam en noten bevatten"); 
        f16.setFieldCode("Nt");
        
        
        //Temperatuurvelden staan apart omdat ze niet gecombineerd kunnen worden
        TemperatureFields tf1 = new TemperatureFields(1);
        tf1.setFieldName("Vaste maximumbewaartemperatuur");
        tf1.setFieldCode("Tf");
        
        TemperatureFields tf2 = new TemperatureFields(2);
        tf2.setFieldName("Variabele maximumbewaartemperatuur");
        tf2.setFieldCode("Tv");
        
        TemperatureFields tf3 = new TemperatureFields(3);
        tf3.setFieldName("Vaste min. en max.bewaartemperatuur");
        tf3.setFieldCode("Tt");
        
        TemperatureFields tf4 = new TemperatureFields(4);
        tf4.setFieldName("Variabele min. en max.bewaartemperatuur");
        tf4.setFieldCode("Tm");
        
        
        //vanaf hier labelformaten aan de database toevoegen
        LabelFormat l1 = new LabelFormat();
        l1.setDevice(d1);
        l1.setLabelFormatSize(s1);
        l1.setLabelFormatCode("In");
        String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\40x46\\Sm5500_40x46_0\\freeformats.dat";
        ReadFromFile rf = new ReadFromFile(filename);
        l1.setDigiDriverCode(rf.getDigiDriverText());
        String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\40x46\\Sm5500_40x46_0\\kg.png";

                
        ImageExample ie1 = new ImageExample();
        File file = new File(imagePath);
        AddImage ai = new AddImage();
        ie1.setImageFile(ai.readImageToBytes(file));
        l1.setImage(ie1);
        
          //formaat 2  
         LabelFormat l2 = new LabelFormat();
        l2.setDevice(d1);
        l2.setLabelFormatSize(s2);
        l2.setLabelFormatCode("In");
        //String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\40x62\\Sm5500_40x62_0\\freeformats.dat";
        rf = new ReadFromFile(filename);
        l2.setDigiDriverCode(rf.getDigiDriverText());
        //String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\40x62\\Sm5500_40x62_0\\kg.png";
                
            
        ImageExample ie2 = new ImageExample();

        file = new File(imagePath);
        //ai = new AddImage();
        ie2.setImageFile(ai.readImageToBytes(file));
        l2.setImage(ie2);
        
        
          //formaat 3 
         LabelFormat l3 = new LabelFormat();
        l3.setDevice(d1);
        l3.setLabelFormatSize(s3);
        l3.setLabelFormatCode("In");
        //String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x49\\Sm5500_60x49_0\\freeformats.dat";
        rf = new ReadFromFile(filename);
        l3.setDigiDriverCode(rf.getDigiDriverText());
        //String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x49\\Sm5500_60x49_0\\kg.png";
                
            
        ImageExample ie3 = new ImageExample();

        file = new File(imagePath);
        ai = new AddImage();
        ie3.setImageFile(ai.readImageToBytes(file));
        l3.setImage(ie3);
        
        
           //formaat 3 
         LabelFormat l4 = new LabelFormat();
        l4.setDevice(d1);
        l4.setLabelFormatSize(s4);
        l4.setLabelFormatCode("In");
        //String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x60\\Sm5500_60x60_0\\freeformats.dat";
        rf = new ReadFromFile(filename);
        l4.setDigiDriverCode(rf.getDigiDriverText());
        //String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x60\\Sm5500_60x60_0\\kg.png";
                
            
        ImageExample ie4 = new ImageExample();

        file = new File(imagePath);
        //ai = new AddImage();
        ie4.setImageFile(ai.readImageToBytes(file));
        l4.setImage(ie4);
        
           //formaat 5
         LabelFormat l5 = new LabelFormat();
        l5.setDevice(d1);
        l5.setLabelFormatSize(s5);
        l5.setLabelFormatCode("In");
        //String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x62\\Sm5500_60x62_0\\freeformats.dat";
        rf = new ReadFromFile(filename);
        l5.setDigiDriverCode(rf.getDigiDriverText());
        //String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x62\\Sm5500_60x62_0\\kg.png";
                
            
        ImageExample ie5 = new ImageExample();

        file = new File(imagePath);
        ai = new AddImage();
        ie5.setImageFile(ai.readImageToBytes(file));
        l5.setImage(ie5);
       
        
           //formaat 6
         LabelFormat l6 = new LabelFormat();
        l6.setDevice(d1);
        l6.setLabelFormatSize(s6);
        l6.setLabelFormatCode("In");
        //String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x70\\Sm5500_60x70_0\\freeformats.dat";
        rf = new ReadFromFile(filename);
        l6.setDigiDriverCode(rf.getDigiDriverText());
        //String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x70\\Sm5500_60x70_0\\kg.png";
                
            
        ImageExample ie6 = new ImageExample();

        file = new File(imagePath);
        ai = new AddImage();
        ie6.setImageFile(ai.readImageToBytes(file));
        l6.setImage(ie6);
       
        
           //formaat 7
         LabelFormat l7 = new LabelFormat();
        l7.setDevice(d1);
        l7.setLabelFormatSize(s7);
        l7.setLabelFormatCode("In");
        //String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x73\\Sm5500_60x73_0\\freeformats.dat";
        rf = new ReadFromFile(filename);
        l7.setDigiDriverCode(rf.getDigiDriverText());
        //String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x73\\Sm5500_60x73_0\\kg.png";
                
            
        ImageExample ie7 = new ImageExample();

        file = new File(imagePath);
        ai = new AddImage();
        ie7.setImageFile(ai.readImageToBytes(file));
        l7.setImage(ie7);
        
            //formaat 8
         LabelFormat l8 = new LabelFormat();
        l8.setDevice(d1);
        l8.setLabelFormatSize(s8);
        l8.setLabelFormatCode("In");
        //String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x80\\Sm5500_60x80_0\\freeformats.dat";
        rf = new ReadFromFile(filename);
        l8.setDigiDriverCode(rf.getDigiDriverText());
        //String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x80\\Sm5500_60x80_0\\kg.png";
                
            
        ImageExample ie8 = new ImageExample();

        file = new File(imagePath);
        ai = new AddImage();
        ie8.setImageFile(ai.readImageToBytes(file));
        l8.setImage(ie8);
        
                //formaat 9
         LabelFormat l9 = new LabelFormat();
        l9.setDevice(d1);
        l9.setLabelFormatSize(s9);
        l9.setLabelFormatCode("In");
        //String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x90\\Sm5500_60x90_0\\freeformats.dat";
        rf = new ReadFromFile(filename);
        l9.setDigiDriverCode(rf.getDigiDriverText());
        //String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x90\\Sm5500_60x90_0\\kg.png";
                
            
        ImageExample ie9 = new ImageExample();

        file = new File(imagePath);
        ai = new AddImage();
        ie9.setImageFile(ai.readImageToBytes(file));
        l9.setImage(ie9);
        
                //formaat 10
         LabelFormat l10 = new LabelFormat();
        l10.setDevice(d1);
        l10.setLabelFormatSize(s10);
        l10.setLabelFormatCode("In");
        //String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x100\\Sm5500_60x100_0\\freeformats.dat";
        rf = new ReadFromFile(filename);
        l10.setDigiDriverCode(rf.getDigiDriverText());
        //String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x100\\Sm5500_60x100_0\\kg.png";
                
            
        ImageExample ie10 = new ImageExample();

        file = new File(imagePath);
        ai = new AddImage();
        ie10.setImageFile(ai.readImageToBytes(file));
        l10.setImage(ie10);
       
            //formaat 11
         LabelFormat l11 = new LabelFormat();
        l11.setDevice(d1);
        l11.setLabelFormatSize(s11);
        l11.setLabelFormatCode("In");
        //String filename;
        filename = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x120\\Sm5500_60x120_0\\freeformats.dat";
        rf = new ReadFromFile(filename);
        l11.setDigiDriverCode(rf.getDigiDriverText());
        //String imagePath;
        imagePath = "C:\\Speclijsten\\LabelFormats\\Database\\Sm5500\\60x120\\Sm5500_60x120_0\\kg.png";
                
            
        ImageExample ie11 = new ImageExample();

        file = new File(imagePath);
        ai = new AddImage();
        ie11.setImageFile(ai.readImageToBytes(file));
        l11.setImage(ie11);
        
        
       
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AddLabelFormatsPU");
        EntityManager entityManager = emf.createEntityManager();
        
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(d1);
        entityManager.persist(d2);
        entityManager.persist(s1);
        entityManager.persist(s2);
        entityManager.persist(s3);
        entityManager.persist(s4);
        entityManager.persist(s5);
        entityManager.persist(s6);
        entityManager.persist(s7);
        entityManager.persist(s8);
        entityManager.persist(s9);
        entityManager.persist(s10);
        entityManager.persist(s11);
        entityManager.persist(s12);
        entityManager.persist(s13);
        entityManager.persist(s14);
        entityManager.persist(f1);
        entityManager.persist(f2);
        entityManager.persist(f3);
        entityManager.persist(f4);
        entityManager.persist(f5);
        entityManager.persist(f6);
        entityManager.persist(f7);
        entityManager.persist(f8);
        entityManager.persist(f9);
        entityManager.persist(f10);
        entityManager.persist(f11);
        entityManager.persist(f12);
        entityManager.persist(f13);
        entityManager.persist(f14);
        entityManager.persist(f15);
        entityManager.persist(f16);
        entityManager.persist(tf1);
        entityManager.persist(tf2);
        entityManager.persist(tf3);
        entityManager.persist(tf4);
       
        
        //labelformaten toevoegen
        entityManager.persist(ie1);
        entityManager.persist(l1);
        entityManager.persist(ie2);
        entityManager.persist(l2);
        entityManager.persist(ie3);
        entityManager.persist(l3);
        entityManager.persist(ie4);
        entityManager.persist(l4);
        entityManager.persist(ie5);
        entityManager.persist(l5);
        entityManager.persist(ie6);
        entityManager.persist(l6);
        entityManager.persist(ie7);
        entityManager.persist(l7);
        entityManager.persist(ie8);
        entityManager.persist(l8);
        entityManager.persist(ie9);
        entityManager.persist(l9);
        entityManager.persist(ie10);
        entityManager.persist(l10);
        entityManager.persist(ie11);
        entityManager.persist(l11);
       
//        entityManager.persist(a);
//        entityManager.persist(p1);
        
         transaction.commit();
        
        emf.close();
    }
    

}
