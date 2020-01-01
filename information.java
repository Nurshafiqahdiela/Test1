/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2;

/**
 *
 * @author Asus
 */
class information {
    
    public void application (){
        
        try{
            
           saveToExcel save = new saveToExcel();
           save.saveData();
           
           System.out.println("\n\nSaving data...");
           Thread.sleep(3000);
           System.out.println("Excel written Successfully....");
           
           
        }catch (InterruptedException e ){
            e.printStackTrace();
        }
    }

    
    
}
