package com.mycompany.projeto.arquivo;
import com.mycompany.projeto.cadastro.CadastroEquipamento;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EquipamentoArquivo{
  
  public static void escreverArquivo(CadastroEquipamento equipamentos){
    File file = new File("ChamadoEquipamento.bin");
    try{
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(equipamentos);


      oos.close();
      fos.close();
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static CadastroEquipamento lerArquivo(File file){
    CadastroEquipamento equipamentos = new CadastroEquipamento();

    try(FileInputStream fileStream = new FileInputStream(file)){

            try(ObjectInputStream objStream = new ObjectInputStream(fileStream)){
                
                try{
                    equipamentos = (CadastroEquipamento) objStream.readObject();
                    return equipamentos;
                }catch(Exception e){
                    e.printStackTrace();
                }
                    
                objStream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            
        
    }
    catch(FileNotFoundException e){
      return equipamentos;
    }
    catch(IOException e){
      e.printStackTrace();
    }
    return equipamentos;
  }

    
}