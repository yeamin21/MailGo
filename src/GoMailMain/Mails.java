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
public class Mails {
   private final String senderA;
   private final String receiverA;
   private final String subjectA;
   private final String bodyA;
   private final int dateA;
   private final int code;
   
   Mails(String senderA,String receiverA,String subjectA,String bodyA,int code,int date)
   {
       this.senderA=senderA;
       this.receiverA=receiverA;
       this.subjectA=subjectA;
       this.bodyA=bodyA;
       this.code=code;
       this.dateA=date;
   }

  
   public String getSender()
   {
       return senderA;
   }
   public String getReceiver()
   {
       return receiverA;
   }
    
   public String getSubjectA()
   {
       return subjectA;
   }
    
   public String getBodyA()
   {
       return bodyA;
   }
   public int getCode()
   {
       return code;
   }
   public int getDate()
   {
       return dateA;
   }
   
    
    
    
}
