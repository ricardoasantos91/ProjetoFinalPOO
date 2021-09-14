package com.mycompany.projeto.arquivo;
import com.mycompany.projeto.cadastro.CadastroChamado;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ChamadoArquivo{
  
  public static void escreverArquivo(CadastroChamado chamados){
    File file = new File("ChamadoArquivo.bin");
    try{
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(chamados);
            //oos.writeObject(funcionario2);
            //oos.writeObject(funcionario3);

      oos.close();
      fos.close();
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static CadastroChamado lerArquivo(File file){
    CadastroChamado chamados = new CadastroChamado();

    try{
        FileInputStream fileStream = new FileInputStream(file);
            // Creating an object input stream
            try{
                ObjectInputStream objStream = new ObjectInputStream(fileStream);
                try{
                    chamados = (CadastroChamado) objStream.readObject();
                    return chamados;
                }catch(Exception e){
                    e.printStackTrace();
                }
                    
                objStream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            
        
    }
    catch(FileNotFoundException e){
      return chamados;
    }
    catch(IOException e){
      e.printStackTrace();
    }
    return chamados;
  }

    
}