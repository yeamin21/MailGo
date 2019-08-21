/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoMailMain;

/**
 *
 * @author yeami
 */
public class NewClass {
    static int date[]={5,4,3,8};
    public static void main(String[]args)
    {
        
   int n = date.length;  
             
             
        int temp = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(date[j-1] > date[j]){  
                            
                            temp = date[j-1];  
                                 date[j-1] = date[j];  
                                 date[j] = temp;  
                         }  
                          
                 }  
         }
         
          for(int i=0; i < n; i++){  
     System.out.println(date[i]);
          }
    }
}
