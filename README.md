# MailGo
MailGo is a gmail like email client (localhost) which uses sqlite3 to manage database. User can send and receive email. We used some algorithms for users ease.
For searching we used Linear Search algorithm
For sorting we used two algorithms:
              1. Bubble Searching (sorting mails by date)
              2. Merge Sort (sorting mails by senders email)
The frontend was developed by JAVA Swing
Backend was developed by sqlite3

## Screenshot Of Login Page
![image](https://github.com/yeamin21/MailGo/blob/master/69054710_665788217231232_7253383199466717184_n.png?raw=true)
### login code

```java
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        try {
            c = "select * from users where email='" + jTextField1.getText() + "' and password='" + (String) jPasswordField2.getText() + "'";
            stm = con.prepareStatement(c);
            rs = stm.executeQuery();
            if (rs.next()) {
                LoginAndSignUp.LoggedEmail = rs.getString("email");
                new MailBox().setVisible(true);
                con.close();
            } else {
                JOptionPane.showMessageDialog(null, "No Such User Found", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
      }
```
## Screenshot Main Page
![image](https://github.com/yeamin21/MailGo/blob/master/Annotation%202019-08-22%20192433.png?raw=true)

## Screenshot After Searching
![image](https://github.com/yeamin21/MailGo/blob/master/69078722_506206216806803_7159643725755318272_n.png?raw=true)
### Linear Search Code

```java
 public void SortByDate() {
        refreshTable();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < mails.size(); i++) {
            date[i] = mails.get(i).getDate();
        }

        int temp = 0;
        int n = mails.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (date[j - 1] > date[j]) {

                    temp = date[j - 1];
                    date[j - 1] = date[j];
                    date[j] = temp;
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (date[i] == mails.get(j).getDate()) {
                   /* Object[] row = new Object[4];
                    row[0] = mails.get(j).getDate();
                    row[1] = mails.get(j).getSender();
                    row[2] = mails.get(j).getSubjectA();
                    row[3] = mails.get(j).getBodyA();
                    model.addRow(row);  */
                }
            }

        }
    }
```
## Screenshot after sorting by Sender (Merge Sort)

![image](https://github.com/yeamin21/MailGo/blob/master/Annotation%202019-08-22%20220410.png?raw=true)

### Merge Sort code Snippet

```java
void SortBySender() {
        refreshTable();
        String sender[] = new String[mails.size()];
        for (int i = 0; i < mails.size(); i++) {
            sender[i] = mails.get(i).getSender();
        }
        mergeSort(sender, 0, sender.length - 1);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < mails.size(); i++) {

            for (int j = 0; j < mails.size(); j++) {
                if (sender[i] == mails.get(j).getSender()) {
                    Object[] row = new Object[4];
                    row[0] = mails.get(j).getDate();
                    row[1] = mails.get(j).getSender();
                    row[2] = mails.get(j).getSubjectA();
                    row[3] = mails.get(j).getBodyA();
                    model.addRow(row);
                }
            }

        }
    }

    public static void mergeSort(String[] a, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;

        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }

    public static void merge(String[] a, int from, int mid, int to) {
        int n = to - from + 1;
        String[] b = new String[n];
        int i1 = from;
        int i2 = mid + 1;
        int j = 0;

        while (i1 <= mid && i2 <= to) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }

        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }

        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }

        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }

    }
 ```
 
 ## Screenshot after sorting by date (Bubble Sort)
 
 ![image](https://github.com/yeamin21/MailGo/blob/master/68741357_473462376570492_5426280918924918784_n.png?raw=true)
 
 ### Bubble Sort Code Snippet
 
 ```java
 void SortByDate() {
        refreshTable();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < mails.size(); i++) {
            date[i] = mails.get(i).getDate();
        }

        int temp = 0;
        int n = mails.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (date[j - 1] > date[j]) {

                    temp = date[j - 1];
                    date[j - 1] = date[j];
                    date[j] = temp;
                }

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (date[i] == mails.get(j).getDate()) {
                    Object[] row = new Object[4];
                    row[0] = mails.get(j).getDate();
                    row[1] = mails.get(j).getSender();
                    row[2] = mails.get(j).getSubjectA();
                    row[3] = mails.get(j).getBodyA();
                    model.addRow(row);
                }
            }

        }
    }
```
